package voteapplet2;

import DTO.CandidateDTO;
import DTO.VotingCardDTO;
import ejb.ValidatorSessionRemote;
import java.util.List;
import ejb.VotingSessionRemote;
import java.util.ArrayList;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import pojos.ControllerException;
import pojos.ValidatorException;

/**
 * Trida zajistujici komunikaci se serverem.
 * @author Tomáš Čerevka
 */
public class Communication {

    private String voter;
    private int event;
    private List<Candidate> candidateList;
    private String host;
    private String port;

    /**
     * Vytvoreni komunikacniho objektu fixovaneho na dane prostredi.
     * @param voter Login hlasujiciho volice.
     * @param event ID udalosti, v niz se hlasuje.
     * @param host IP adresa, na ktere posloucha server.
     * @param port Port, na kterem posloucha server.
     */
    public Communication(String voter, int event, String host, String port) {
        this.voter = voter;
        this.event = event;
        this.host = host;
        this.port = port;
        candidateList = new ArrayList<Candidate>();
    }

    /**
     * Prijme ze serveru kandidaty a ulozi si je do seznamu.
     * @return True v pripade uspechu, false pri selhani.
     */
    public boolean recieveCandidates() {
        VotingSessionRemote votingBean;
        try {
            Properties props = new Properties();
            props.setProperty("org.omg.CORBA.ORBInitialHost", this.host);
            props.setProperty("org.omg.CORBA.ORBInitialPort", this.port);
            Context context = new InitialContext(props);
            // nacte se vzdalena beana
            votingBean = (VotingSessionRemote) context.lookup("ejb.VotingSessionRemote");
        } catch (NamingException ex) {
            System.err.println("Naming Exception: " + ex.toString());
            return false;
        }

        CandidateDTO candidates[];
        try {
            // prijmou se kandidati
            candidates = votingBean.getCandidates(this.event);
        } catch (ControllerException ex) {
            System.err.println("Controller Exception: " + ex.toString());
            return false;
        }
        // kandidati se ulozi do seznamu
        for (int i = 0; i < candidates.length; i++) {
            candidateList.add(new Candidate(
                    candidates[i].getLogin(),
                    candidates[i].getFirstName(),
                    candidates[i].getLastName()));
        }
        return true;
    }

    /**
     * Preda seznam kandidatu.
     * @return Seznam kandidatu.
     */
    public List<Candidate> getCandidates() {
        return candidateList;
    }

    /**
     * Nastavi u daneho kandidata v kolekci priznak zvoleni.
     * @param i Pozice kandidata v seznamu.
     * @param elected Priznak, na kterou hodnotu nastavit.
     */
    public void setElected(int i, boolean elected) {
        this.candidateList.get(i).setElected(elected);
    }

    /**
     * Vrati pocet kandidatu.
     * @return Pocet kandidatu.
     */
    public int getCount() {
        return candidateList.size();
    }

    /**
     * Odesle na server seznam zvolenych kandidatu.
     * @return True = uspech, false = neuspech.
     */
    public boolean sendVoteCard() {
        ValidatorSessionRemote validator;

        try {
            // pripravi se prostredi
            Properties props = new Properties();
            props.setProperty("org.omg.CORBA.ORBInitialHost", this.host);
            props.setProperty("org.omg.CORBA.ORBInitialPort", this.port);
            Context context = new InitialContext(props);

            // nacte se vzdalena beana
            validator = (ValidatorSessionRemote) context.lookup("ejb.ValidatorSessionRemote");
        } catch (NamingException ex) {
            System.err.println("Naming exception: " + ex.toString());
            return false;
        }

        // pripravi se zvoleni kandidati k odeslani
        List<String> electedCandidates = new ArrayList<String>();
        for (Candidate candidate : candidateList) {
            if (candidate.isElected()) {
                // je-li zvolen, vlozi se jeho login do seznamu
                electedCandidates.add(candidate.getLogin());
                System.out.println(candidate.getLogin());
            }
        }

        // sestavi se listek        
        VotingCardDTO votingCard = new VotingCardDTO( (String[]) electedCandidates.toArray(new String[electedCandidates.size()]),
                this.voter, this.event);

        try {
            validator.sendVote(votingCard);
        } catch (ValidatorException ex) {
            System.err.println("Validator exception: " + ex.toString());
            return false;
        }
        return true;
    }
}
