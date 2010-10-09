package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author lordondrak
 */
@Entity
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String login;

    private String firstname;
    private String lastname;
    private String personGroup;
    
    private String password; 

/**
 * Returns the last name of this person
 * @return
 */
    public String getLastname() {
        return lastname;
    }
/**
 * sets the last name
 * @param lastname
 */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
/**
 * returns the first name
 * @return
 */
    public String getFirstname() {
        return firstname;
    }
/**
 * sets the first name
 * @param firstname
 */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
/**
 * returns the login
 * @return
 */
    public String getLogin() {
        return login;
    }
/**
 * sets the login
 * @param login
 */
    public void setLogin(String login) {
        this.login = login;
    }
/**
 * returns the group this person belongs to
 * @return
 */
    public String getPersonGroup() {
        return personGroup;
    }
/**
 * sets the group this person belongs to
 * @param personGroup
 */
    public void setPersonGroup(String personGroup) {
        this.personGroup = personGroup;
    }
/**
 * returns the password
 * @todo password not hashed
 * @return
 */
    public String getPassword() {
        return password;
    }
/**
 * sets the password
 * @param password
 */
    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.firstname+" "+this.lastname+" ("+this.login+")";
    }
}
