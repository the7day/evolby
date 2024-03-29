package entityCounter;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
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

     //candidateRole rozlisuje role profesor/student
    private String candidateRole;

    public String getCandidateLogin() {
        return candidateLogin;
    }

    public void setCandidateLogin(String candidateLogin) {
        this.candidateLogin = candidateLogin;
    }

    public Collection<CounterElectionEvent> getVotedInEvents() {
        return votedInEvents;
    }

    public void setVotedInEvents(Collection<CounterElectionEvent> votedInEvents) {
        this.votedInEvents = votedInEvents;
    }

    public Collection<VotesCount> getVotesCount() {
        return votesCount;
    }

    public void setVotesCount(Collection<VotesCount> votesCount) {
        this.votesCount = votesCount;
    }

    public String getCandidateRole() {
        return candidateRole;
    }

    public void setCandidateRole(String candidateRole) {
        this.candidateRole = candidateRole;
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
