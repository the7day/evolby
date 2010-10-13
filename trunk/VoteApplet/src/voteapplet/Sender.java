/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package voteapplet;

import DTO.VotingCardDTO;
import ejb.ValidatorSessionRemote;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import pojos.ValidatorException;

/**
 *
 * @author lordondrak
 */
public class Sender {

    private ResultSet results;
    private String[] candidates;
    private VotingCardDTO votingCard;
    private String token;
    private int eventId;

    public Sender(ResultSet results, String eventId, String token) {
        this.results = results;
        this.eventId = Integer.parseInt(eventId);
        this.token = token;
        Collection<String> votedCandidates = new ArrayList();
        for(Result r : this.results.getResults()) {
            if(r.isVote()) {
                votedCandidates.add(r.getLogin());
            }
        }
        this.candidates = new String [votedCandidates.size()];
        int i = 0;
        for(String login : votedCandidates) {
            this.candidates[i] = login;
            i++;
        }
        this.votingCard = new VotingCardDTO(this.candidates, this.token, this.eventId);
        System.out.println("Token = "+this.token);
    }

    public boolean send(){
        for(int i=0;i<results.getResults().size();i++){
            System.out.println("Candidate id: " + results.getResults().get(i).getLogin() +
                                    "  vote: " + results.getResults().get(i).isVote() );
        }
        ValidatorSessionRemote validator;
        try {
            Context context = getInitialContext();
            validator = (ValidatorSessionRemote)context.lookup("ejb.ValidatorSessionRemote");
        } catch (NamingException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        try {
            validator.sendVote(votingCard);
        } catch (ValidatorException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    private Context getInitialContext() throws NamingException {
        return new InitialContext();
    }

}