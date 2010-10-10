/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entityValidator;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Class of ValidatorAnonymousVoters.
 * @author Finkky 
 */
@Entity
public class ValidatorAnonymousVoter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /**
     * Returns id of anonymous voter.
     * @return id of anonymous voter
     */
    public String getId() {
        return id;
    }

    /**
     * Set id of anonymous voter.
     * @param id Choosen id for anonymous voter.
     */
    public void setId(String id) {
        this.id = id;
    }
    @OneToMany
    private Collection<ValidatorVote> votes;

    /**
     * Returns votes.
     * @return Votes.
     */
    public Collection<ValidatorVote> getVotes() {
        return votes;
    }

    /**
     * Sets votes.
     * @param votes
     */
    public void setVotes(Collection<ValidatorVote> votes) {
        this.votes = votes;
    }

    /**
     * Returns hash of id.
     * @return Calculated hash of id.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compares ValidatorAnonymousVoter with another ValidatorAnonymousVoters.
     * Comparison depends on equality of ids.
     * @param object ValidatorAnonymousVoter.
     * @return True if ids corespond, false if they does not.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValidatorAnonymousVoter)) {
            return false;
        }
        ValidatorAnonymousVoter other = (ValidatorAnonymousVoter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Convert ValidatorAnonymousVoter into a string.
     * @return String that describes this instance.
     */
    @Override
    public String toString() {
        return "entityValidator.ValidatorAnonymousVoter[id=" + id + "]";
    }
}
