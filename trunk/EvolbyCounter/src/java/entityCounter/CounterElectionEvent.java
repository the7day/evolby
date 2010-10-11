/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entityCounter;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Class representing an election event for counting purposes.
 * @author mz
 */
@Entity
public class CounterElectionEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    @ManyToOne
    private CounterElection election;
    @ManyToMany(mappedBy="votedInEvents")
    private Collection<CounterCandidate> candidates;
    @OneToMany(mappedBy="electionEvent")
    private Collection<VotesCount> votesCounts;

    /**
     * Returns candidates in election event.
     * @return Collection of CounterCandidates in this election event.
     */
    public Collection<CounterCandidate> getCandidates() {
        return candidates;
    }

    /**
     * Sets candidates in the election event.
     * @param candidates collection of CounterCandidates in this election event.
     */
    public void setCandidates(Collection<CounterCandidate> candidates) {
        this.candidates = candidates;
    }

    /**
     * Returns election event id.
     * @return Integer representing id of this election event.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets election event id.
     * @param id integer representing id of this election
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Returns the election for this election event.
     * @return CounterElection assigned to this election event.
     */
    public CounterElection getElection() {
        return election;
    }

    /**
     * Sets election for this election event.
     * @param election CounterElection to be assigned to this election event.
     */
    public void setElection(CounterElection election) {
        this.election = election;
    }

    /**
     * Return votes counts for this election event.
     * @return Collection of VotesCount for this election event.
     */
    public Collection<VotesCount> getVotesCounts() {
        return votesCounts;
    }

    /**
     * Sets votes counts for this election event.
     * @param votesCounts collection of VotesCount to be assigned to this election event.
     */
    public void setVotesCounts(Collection<VotesCount> votesCounts) {
        this.votesCounts = votesCounts;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CounterElectionEvent)) {
            return false;
        }
        CounterElectionEvent other = (CounterElectionEvent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ElectionEvent[id=" + id + "]";
    }
}
