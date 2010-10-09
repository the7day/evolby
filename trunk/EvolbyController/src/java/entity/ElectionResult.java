/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author defiler
 */
@Entity
public class ElectionResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    private Candidate candidate;
    private Integer votes;
    @ManyToOne
    private ElectionEvent electionEvent;
    /**
     * returns the Election Event this result is valid for
     * @return
     */
    public ElectionEvent getElectionEvent() {
        return electionEvent;
    }
/**
 * sets the Election Event this result is valid for
 * @param electionEvent
 */
    public void setElectionEvent(ElectionEvent electionEvent) {
        this.electionEvent = electionEvent;
    }
    /**
     * returns the id of this result
     * @return
     */
    public Integer getId() {
        return id;
    }
/**
 * sets the id of this result
 * @param id
 */
    public void setId(Integer id) {
        this.id = id;
    }
/**
 *  returns the candidate for which this result is valid
 * @return
 */
    public Candidate getCandidate() {
        return candidate;
    }
/**
 * sets the candidate of this result
 * @param candidate
 */
    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
/**
 * returns the number of votes the candidate has recieved in this election event
 * @return
 */
    public Integer getVotes() {
        return votes;
    }
/**
 * Sets the number of votes the candicate has in this event
 * @param votes
 */
    public void setVotes(Integer votes) {
        this.votes = votes;
    }
/**
 *
 * @return
 */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
/**
 *
 * @param object
 * @return
 */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ElectionResult)) {
            return false;
        }
        ElectionResult other = (ElectionResult) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ElectionResult[id=" + id + "]";
    }

}
