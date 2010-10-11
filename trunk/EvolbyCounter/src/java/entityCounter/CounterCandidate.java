package entityCounter;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Class representing candidates for counting purposes.
 * @author mz
 */
@Entity
public class CounterCandidate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String candidateLogin;
    @ManyToMany
    private Collection<CounterElectionEvent> votedInEvents;
    @OneToMany(mappedBy="candidate")
    private Collection<VotesCount> votesCount;

     /**
     * Returns candidate's login.
     * @return string containing candidate's login
     */
    public String getCandidateLogin() {
        return candidateLogin;
    }


    /**
     * Sets candidate's login.
     * @param candidateLogin string with candidate's login.
     */
    public void setCandidateLogin(String candidateLogin) {
        this.candidateLogin = candidateLogin;
    }

    /**
     * Returns the election events this candidate is participating in.
     * @return collection of CounterElectionEvents
     */
    public Collection<CounterElectionEvent> getVotedInEvents() {
        return votedInEvents;
    }

    /**
     * Sets the events this candidate is participating in.
     * @param votedInEvents collection of CounterElectionEvents
     */
    public void setVotedInEvents(Collection<CounterElectionEvent> votedInEvents) {
        this.votedInEvents = votedInEvents;
    }

    /**
     * Returns vote counts for the candidate.
     * @return collection of VotesCount
     */
    public Collection<VotesCount> getVotesCount() {
        return votesCount;
    }

    /**
     * Sets vote counts for the candidate.
     * @param votesCount collection of VotesCount
     */
    public void setVotesCount(Collection<VotesCount> votesCount) {
        this.votesCount = votesCount;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (candidateLogin != null ? candidateLogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CounterCandidate)) {
            return false;
        }
        CounterCandidate other = (CounterCandidate) object;
        if ((this.candidateLogin == null && other.candidateLogin != null) || (this.candidateLogin != null && !this.candidateLogin.equals(other.candidateLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Candidate[id=" + candidateLogin + "]";
    }
}
