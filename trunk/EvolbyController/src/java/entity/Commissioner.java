/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author lordondrak
 */
@Entity
public class Commissioner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id   
    private String login;    
    @ManyToMany
    private Collection<Election> elections;
    private String firstName;
    private String lastName;
/**
 * Returns the commissioners first name
 * @return
 */
    public String getFirstName() {
        return firstName;
    }
/**
 * Sets the commissioners first name
 * @param firstName
 */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
/**
 * Returns the commissioners last name
 * @return
 */
    public String getLastName() {
        return lastName;
    }
/**
 * Sets the commissioners last name
 * @param lastName
 */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the login of the commissioner
     * @return
     */
    public String getLogin() {
        return login;
    }

/**
 * Sets the login of the commissioner
 * @param login
 */
    public void setLogin(String login) {
        this.login = login;
    }
/**
 * Returns a collection of elections where the commissioner is commisioning
 * @return
 */
    public Collection<Election> getElections() {
        return elections;
    }
/**
 * Gives the commissioner a collection of elections
 * @param elections
 */
    public void setElections(Collection<Election> elections) {
        this.elections = elections;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Commissioner)) {
            return false;
        }
        Commissioner other = (Commissioner) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Commissioner[id=" + login + "]";
    }

}
