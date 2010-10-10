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
 * Class of ValidatorVoter.
 * @author defiler
 */
@Entity
public class ValidatorVoter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String login;

    @ManyToMany
    private Collection<ValidatorElectionEvent> electionEvents;

    /**
     * Returns ValidatorElectionEvents.
     * @return ValidatorElectionEvents.
     */
    public Collection<ValidatorElectionEvent> getElectionEvents() {
        return electionEvents;
    }

    /**
     * Sets ValidatorElectionEvent.
     * @param electionEvents
     */
    public void setElectionEvents(Collection<ValidatorElectionEvent> electionEvents) {
        this.electionEvents = electionEvents;
    }

    /**
     * Returns voter's login.
     * @return Voter's login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets voter's login.
     * @param login Choosen voter's login.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Returns hash of voter's login.
     * @return Hash of voter's login.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

     /**
     * Compare ValidatorVoter with another ValidatorVoter.
     * Comparison depends on equality of their login.
     * @param object ValidatorVoter.
     * @return True if logins corespond, false if they does not.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValidatorVoter)) {
            return false;
        }
        ValidatorVoter other = (ValidatorVoter) object;
        if ((this.login == null && other.login != null) || (login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

     /**
     * Convert ValidatorVoter into a string.
     * @return String that describes this instance.
     */
    @Override
    public String toString() {
        return "entityValidator.ValidatorVoter[id=" + login + "]";
    }

}
