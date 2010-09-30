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
public class VoteDTO implements Serializable {
    private String[] votedCandidates;

    public VoteDTO(String[] votedCandidates) {
        this.votedCandidates = votedCandidates;
    }

    public VoteDTO() {
    }

    public String[] getVotedCandidates() {
        return votedCandidates;
    }

    public void setVotedCandidates(String[] votedCandidates) {
        this.votedCandidates = votedCandidates;
    }
}
