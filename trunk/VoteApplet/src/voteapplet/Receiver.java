/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package voteapplet;

import DTO.CandidateDTO;
import ejb.VotingSessionRemote;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import pojos.ControllerException;

/**
 *
 * @author lordondrak
 */
public class Receiver {
    
    private List<Candidate> candidates;
    private int count;
    private int eventId;

    public Receiver(){
        candidates = new ArrayList<Candidate>();
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = Integer.parseInt(eventId);
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }
    public boolean receive(){
        // nacteni parametru pres RMI
        VotingSessionRemote votingBean;
        try {
            Context context = getInitialContext();
            votingBean = (VotingSessionRemote)context.lookup("ejb.VotingSessionRemote");
        } catch (NamingException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        CandidateDTO candidatesDTO[];
        try {
            candidatesDTO = votingBean.getCandidates(eventId);
        } catch (ControllerException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        for(int i=0; i<candidatesDTO.length; i++) {
            candidates.add(new Candidate(candidatesDTO[i].getLogin(),
                    candidatesDTO[i].getFirstName(),
                    candidatesDTO[i].getLastName()) );
        }
        this.count = candidatesDTO.length;
        return true;
    }
    
    private Context getInitialContext() throws NamingException {
        return new InitialContext();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
