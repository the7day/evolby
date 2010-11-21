package voteapplet2;

import DTO.CandidateDTO;
import java.util.List;
import ejb.VotingSessionRemote;
import java.util.ArrayList;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import pojos.ControllerException;

/**
 * Trida zarucuji komunikaci se serverem.
 * @author Tomáš Čerevka
 */
public class Communication {
    
    private String voter;
    private int event;
    private List<Candidate> candidateList;

    /**
     * Kontrukturor.
     */
    public Communication(String voter, int event) {
        this.voter = voter;
        this.event = event;
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
            // Nastavi se prostredi pro komunikaci s beanou.
            //props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            //props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            // props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            props.setProperty("org.omg.CORBA.ORBInitialHost", "147.32.94.91");
            props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
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
     * Vrati pocet kandidatu.
     * @return Pocet kandidatu.
     */
    public int getCount() {
        return candidateList.size();
    }



}
