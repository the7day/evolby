/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entityValidator;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Class of ValidatorVote.
 * @author defiler
 */
@Entity
public class ValidatorVote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date recievedDate;
    @OneToMany
    Collection<ValidatorCandidate> votedCandidates;
    @ManyToOne
    private ValidatorElectionEvent electionEvent;

    /**
     * Returns ValidatorElectionEvent.
     * @return ValidatorElectionEvent.
     */
    public ValidatorElectionEvent getElectionEvent() {
        return electionEvent;
    }

    /**
     * Sets ValidatorElectionEvent.
     * @param electionEvent Choosen ValidatorElectionEvent.
     */
    public void setElectionEvent(ValidatorElectionEvent electionEvent) {
        this.electionEvent = electionEvent;
    }

    /**
     * Returns id of vote.
     * @return Id of vote.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id of vote.
     * @param id Choosen id for vote.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns recieved date of vote.
     * @return Recieved date of vote.
     */
    public Date getRecievedDate() {
        return recievedDate;
    }

    /**
     * Sets recived date of vote.
     * @param recievedDate
     */
    public void setRecievedDate(Date recievedDate) {
        this.recievedDate = recievedDate;
    }

    /**
     * Returns collection of voted candidates.
     * @return Collection of voted candidates.
     */
    public Collection<ValidatorCandidate> getVotedCandidates() {
        return votedCandidates;
    }

    /**
     * Sets collection of voted candidates.
     * @param votedCandidates Collection of voted candidates.
     */
    public void setVotedCandidates(Collection<ValidatorCandidate> votedCandidates) {
        this.votedCandidates = votedCandidates;
    }
    

    /**
     * Returns hash code of votes's id.
     * @return Hash code of votes's id.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

     /**
     * Compare ValidatorVote with another ValidatorVote.
     * Comparison depends on equality of their id.
     * @param object ValidatorElectionEvent.
     * @return True if ids corespond, false if they does not.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValidatorVote)) {
            return false;
        }
        ValidatorVote other = (ValidatorVote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

     /**
     * Convert ValidatorVote into a string.
     * @return String that describes this instance.
     */
    @Override
    public String toString() {
        return "entityValidator.ValidatorVote[id=" + id + "]";
    }

}
