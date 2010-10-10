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

/**
 * Class of ValidatorCandidate.
 * @author defiler
 */
@Entity
public class ValidatorCandidate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String login;
    @ManyToMany
    private Collection<ValidatorElectionEvent> votedInEvents;

    /**
     * Returns candidate's login.
     * @return Candidate's login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets cadidate's login.
     * @param login Choosen login for cadidate.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Returns VotedInEvents.
     * @return VotedInEvens.
     */
    public Collection<ValidatorElectionEvent> getVotedInEvents() {
        return votedInEvents;
    }

    /**
     * Sets VotedInEvents.
     * @param votedInEvents
     */
    public void setVotedInEvents(Collection<ValidatorElectionEvent> votedInEvents) {
        this.votedInEvents = votedInEvents;
    }

    /**
     * Returns hash code of candidate's login.
     * @return Hash code of candidate's login.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    /**
     * Compares ValidatorCandidate with another ValidatorCandidate.
     * Comparison depends on equality of their login.
     * @param object ValidatorCandidate.
     * @return True if logins corespond, false if they does not.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValidatorCandidate)) {
            return false;
        }
        ValidatorCandidate other = (ValidatorCandidate) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    /**
     * Convert ValidatorCandidate into a string.
     * @return String that describes this instance.
     */
    @Override
    public String toString() {
        return "entityValidator.ValidatorCandidate[id=" + login + "]";
    }

}
