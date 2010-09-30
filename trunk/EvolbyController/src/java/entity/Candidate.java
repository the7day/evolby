/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author defiler
 */
@Entity
public class Candidate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String login;
    @OneToMany
    private Map<ElectionEvent, Programme> programmes;
    @ManyToMany
    private Collection<ElectionEvent> votedInEvents;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Map<ElectionEvent, Programme> getProgrammes() {
        return programmes;
    }

    public void setProgrammes(Map<ElectionEvent, Programme> programmes) {
        this.programmes = programmes;
    }

    public Collection<ElectionEvent> getVotedInEvents() {
        return votedInEvents;
    }

    public void setVotedInEvents(Collection<ElectionEvent> votedInEvents) {
        this.votedInEvents = votedInEvents;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Candidate)) {
            return false;
        }
        Candidate other = (Candidate) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return login;
    }

}
