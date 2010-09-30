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
public class VotesDTO implements Serializable {
    private int electionEventID;
    private VoteDTO[] votes;

    public VotesDTO(int electionEventID, VoteDTO[] votes) {
        this.electionEventID = electionEventID;
        this.votes = votes;
    }

    public VotesDTO() {
        
    }

    public VoteDTO[] getVotes() {
        return votes;
    }

    public void setVotes(VoteDTO[] votes) {
        this.votes = votes;
    }

    public int getElectionEventID() {
        return electionEventID;
    }

    public void setElectionEventID(int electionEventID) {
        this.electionEventID = electionEventID;
    }
}
