package entityCounter;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Class representing an election for counting purposes.
 * @author mz
 */
@Entity
public class CounterElection implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    //private byte[] privateKey;
    @OneToMany(mappedBy="election")
    private Collection<CounterElectionEvent> electionEvents;
    
    /**
     * Returns election events for this election.
     * @return Collection of CounterelectionEvents assigned to this election.
     */
    public Collection<CounterElectionEvent> getElectionEvents() {
        return electionEvents;
    }

    /**
     * Sets election events for this election.
     * @param electionEvents collection of CounterElectionEvents to be assigned to this election.
     */
    public void setElectionEvents(Collection<CounterElectionEvent> electionEvents) {
        this.electionEvents = electionEvents;
    }

    /**
     * Returns id of the election.
     * @return Integer representing id of election.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id of the election.
     * @param id integer representing id of election.
     */
    public void setId(Integer id) {
        this.id = id;
    }
/*
    public byte[] getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(byte[] privateKey) {
        this.privateKey = privateKey;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CounterElection)) {
            return false;
        }
        CounterElection other = (CounterElection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Election[id=" + id + "]";
    }
}
