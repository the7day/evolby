/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entityValidator;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Class of ValidatorElectionEvent.
 * @author defiler
 */
@Entity
public class ValidatorElectionEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    @ManyToMany(mappedBy="votedInEvents")
    private Collection<ValidatorCandidate> candidates;
    @ManyToMany(mappedBy="electionEvents")
    private Collection<ValidatorVoter> voters;
    @OneToMany(mappedBy="electionEvent")
    private Collection<ValidatorVote> votes;
    private Boolean votingStarted;

    /**
     * Returns candidates who are assigned to election event.
     * @return Collection of candidates.
     */
    public Collection<ValidatorCandidate> getCandidates() {
        return candidates;
    }

    /**
     * Sets candidates who will be assigned to election event.
     * @param candidates Collection of candidates.
     */
    public void setCandidates(Collection<ValidatorCandidate> candidates) {
        this.candidates = candidates;
    }

    /**
     * Returns id of election event.
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id of election event.
     * @param id Choosen id for election event.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns collection of voters who are assigned to election event.
     * @return Collection of voters.
     */
    public Collection<ValidatorVoter> getVoters() {
        return voters;
    }

    /**
     * Sets voters who will be assigned to election even.
     * @param voters Collection of voters.
     */
    public void setVoters(Collection<ValidatorVoter> voters) {
        this.voters = voters;
    }

    /**
     * Returs votes in election event.
     * @return Collection of votes.
     */
    public Collection<ValidatorVote> getVotes() {
        return votes;
    }

    /**
     * Sets votes in elction event.
     * @param votes Collection of votes.
     */
    public void setVotes(Collection<ValidatorVote> votes) {
        this.votes = votes;
    }

    /**
     * Check state of election event.
     * @return True if election event has started, othewise false.
     */
    public Boolean getVotingStarted() {
        return votingStarted;
    }

    /**
     * Sets state of election event.
     * @param votingStarted True = it has started, False = it has not started.
     */
    public void setVotingStarted(Boolean votingStarted) {
        this.votingStarted = votingStarted;
    }

    /**
     * Return hash code of election event's id.
     * @return Hash code of election event's id.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compare ValidatorElectionEvent with another ValidatorElectionEvent.
     * Comparison depends on equality of their id.
     * @param object ValidatorElectionEvent.
     * @return True if ids corespond, false if they does not.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValidatorElectionEvent)) {
            return false;
        }
        ValidatorElectionEvent other = (ValidatorElectionEvent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Convert ValidatorElectionEvent into a string.
     * @return String that describes this instance.
     */
    @Override
    public String toString() {
        return "entityValidator.ValidatorElectionEvent[id=" + id + "]";
    }

}
