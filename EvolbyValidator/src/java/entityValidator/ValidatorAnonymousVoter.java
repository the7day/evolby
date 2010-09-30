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
 *
 * @author Finkky 
 */
@Entity
public class ValidatorAnonymousVoter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @OneToMany
    private Collection<ValidatorVote> votes;

    public Collection<ValidatorVote> getVotes() {
        return votes;
    }

    public void setVotes(Collection<ValidatorVote> votes) {
        this.votes = votes;
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
        if (!(object instanceof ValidatorAnonymousVoter)) {
            return false;
        }
        ValidatorAnonymousVoter other = (ValidatorAnonymousVoter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityValidator.ValidatorAnonymousVoter[id=" + id + "]";
    }
}
