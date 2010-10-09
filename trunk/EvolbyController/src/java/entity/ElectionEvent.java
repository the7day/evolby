/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
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
public class ElectionEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToMany(mappedBy="votedInEvents")
    private Collection<Candidate> candidates;
    @ManyToMany(mappedBy="electionEvents")
    private Collection<Voter> voters;
    @OneToMany(mappedBy="electionEvent")
    private Collection<ElectionResult> electionResults;
    private String name;
    private String info;
    private Boolean votingStarted;
    private Boolean nominatingStarted;
    private Boolean finished;
/**
 * Returns the results of this election event
 * @return
 */
    public Collection<ElectionResult> getElectionResults() {
        return electionResults;
    }
/**
 *  Sets the elections results for this event
 * @param electionResults
 */
    public void setElectionResults(Collection<ElectionResult> electionResults) {
        this.electionResults = electionResults;
    }
/**
 * Returns the electionevent name
 * @return
 */
    public String getName() {
        return name;
    }
/**
 * Sets the election event name
 * @param name
 */
    public void setName(String name) {
        this.name = name;
    }
/**
 * Returns the election Id
 * @return
 */
    public Integer getId() {
        return id;
    }
/**
 * Sets the election Id
 * @param id
 */
    public void setId(Integer id) {
        this.id = id;
    }
/**
 * returns a collection of candidates in this event
 * @return
 */
    public Collection<Candidate> getCandidates() {
        return candidates;
    }
/**
 * Sets the candidates
 * @param candidates
 */
    public void setCandidates(Collection<Candidate> candidates) {
        this.candidates = candidates;
    }
/**
 * Has nominaning started?
 * @return
 */
    public Boolean getNominatingStarted() {
        return nominatingStarted;
    }
/**
 * Sets the nominating state
 * @param nominatingStarted
 */
    public void setNominatingStarted(Boolean nominatingStarted) {
        this.nominatingStarted = nominatingStarted;
    }
/**
 * Has voting started?
 * @return
 */
    public Boolean getVotingStarted() {
        return votingStarted;
    }
/**
 * Sets the voting state
 * @param votingStarted
 */
    public void setVotingStarted(Boolean votingStarted) {
        this.votingStarted = votingStarted;
    }
/**
 * returns a collection of voters
 * @return
 */
    public Collection<Voter> getVoters() {
        return voters;
    }
/**
 * Sets the voters eligible to vote in these elections
 * @param voters
 */
    public void setVoters(Collection<Voter> voters) {
        this.voters = voters;
    }
/**
 * returns information concerning this event
 * @return
 */
    public String getInfo() {
        return info;
    }
/**
 * Sets the election event info
 * @param info
 */
    public void setInfo(String info) {
        this.info = info;
    }
/**
 * Has the event finished?
 * @return
 */
    public Boolean getFinished() {
        return finished;
    }
/**
 * Sets the finished flag
 * @param finished
 */
    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ElectionEvent)) {
            return false;
        }
        ElectionEvent other = (ElectionEvent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ElectionEvent[id=" + id + "]";
    }

}
