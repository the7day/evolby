/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author defiler
 */
@Entity
public class Election implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToMany( mappedBy="elections" )
    private Collection<Commissioner> commissioners;
    @OneToMany
    private Collection<ElectionEvent> electionEvents;
    //private byte[] publicKey;
    private String type;
/**
 * Returns the election id
 * @return
 */
    public Integer getId() {
        return id;
    }
/**
 * Sets the election id
 * @param id
 */
    public void setId(Integer id) {
        this.id = id;
    }
/**
 * Returns the name of the election
 * @return
 */
    public String getName() {
        return name;
    }
    /**
     * Sets the election name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
/*
    public byte[] getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(byte[] publicKey) {
        this.publicKey = publicKey;
    }
 */
/**
 * Returns a collection of election events belonging to these elections
 * @return
 */
    public Collection<ElectionEvent> getElectionEvents() {
        return electionEvents;
    }
/**
 *  Sets a colletion of election events belonging to these elections
 * @param electionEvents
 */
    public void setElectionEvents(Collection<ElectionEvent> electionEvents) {
        this.electionEvents = electionEvents;
    }
/**
 * Returns a set of commissioners belonging to these elections
 * @return
 */
    public Collection<Commissioner> getCommissioners() {
        return commissioners;
    }
/**
 * Sets the collection of commissioners to these elections
 * @param commissioners
 */
    public void setCommissioners(Collection<Commissioner> commissioners) {
        this.commissioners = commissioners;
    }
/**
 * Returns the type of elections
 * @return
 */
    public String getType() {
        return type;
    }
/**
 * Sets the type of the elections
 * @param type
 */
    public void setType(String type) {
        this.type = type;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Election)) {
            return false;
        }
        Election other = (Election) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }
/**
 * Returns "entity.Election[id=" + name of the elections + "]"
 * @return
 */
    @Override
    public String toString() {
        return "entity.Election[id=" + name + "]";
    }
}
