package entityCounter;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Class representing the count of votes for one candidate in one election event.
 * @author defiler
 */
@Entity
public class VotesCount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private CounterElectionEvent electionEvent;
    @ManyToOne
    private CounterCandidate candidate;
    private Integer count;

    /**
     * Returns the id of this vote count.
     * @return Integer representing id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id of this vote count.
     * @param id integer with and id.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns the number of votes.
     * @return Integer representing the number of votes.
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Sets the number of votes.
     * @param count integer representing the number of votes.
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * Returns the election event this vote count is assigned to.
     * @return CounterElectionEvent assigned to this vote count.
     */
    public CounterElectionEvent getElectionEvent() {
        return electionEvent;
    }

    /**
     * Sets an election event this vote count is assigned to.
     * @param electionEvent electionEvent to be assigned to this vote count.
     */
    public void setElectionEvent(CounterElectionEvent electionEvent) {
        this.electionEvent = electionEvent;
    }

    /**
     * Returns the candidate this vote count is assigned to.
     * @return CounterCandidate assigned to this vote count.
     */
    public CounterCandidate getCandidate() {
        return candidate;
    }

    /**
     * Sets the candidate this vote count is assigned to.
     * @param candidate CounterCandidate assigned to this vote count.
     */
    public void setCandidate(CounterCandidate candidate) {
        this.candidate = candidate;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VotesCount)) {
            return false;
        }
        VotesCount other = (VotesCount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityCounter.VotesCount[id=" + id + "]";
    }

}
