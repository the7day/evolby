/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import java.io.Serializable;

/**
 *
 * @author defiler
 */
public class ElectionEventResultDTO implements Serializable {
    private int electionEvent;
    private String[] candidates; // id kandidatu
    private int[] votes; // pocet hlasu daneho kandidata (dany pocet hlasu a kandidat jsou na stejnem indexu)

    public ElectionEventResultDTO(int electionEvent, String[] candidates, int[] votes) {
        this.electionEvent = electionEvent;
        this.candidates = candidates;
        this.votes = votes;
    }

    public ElectionEventResultDTO() {
    }
    
    public String[] getCandidates() {
        return candidates;
    }

    public void setCandidates(String[] candidates) {
        this.candidates = candidates;
    }

    public int getElectionEvent() {
        return electionEvent;
    }

    public void setElectionEvent(int electionEvent) {
        this.electionEvent = electionEvent;
    }

    public int[] getVotes() {
        return votes;
    }

    public void setVotes(int[] votes) {
        this.votes = votes;
    }
}
