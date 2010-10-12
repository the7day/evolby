/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entity.Commissioner;
import entity.Election;
import entity.ElectionEvent;
import entity.Person;
import entity.Voter;
import java.util.Collection;
import javax.ejb.Remote;
import pojos.ControllerException;

/**
 *
 * @author defiler
 */
@Remote
public interface CreatingElectionSessionRemote {
/**
     * Creates a new election with the given name and type.
     * @param electionName the name of the created election
     * @param electionType the election type LOCAL or INTERNET
     * @throws ControllerException //TODO description
     */
    void createElection(final String electionName, final String electionType) throws ControllerException;
/**
     *Returns all the persons in the database
     * @return all the persons in the database
     */
    Collection<Person> getAllPerson();
 /**
     * Returns a collection of elections where the given comissioner is active
     * @param commissionerLogin login of the given commissioner
     * @return elections where is the given commissioner
     * @throws ControllerException if commissioner not found
     */
    Collection<Election> getCommissionerElection(final String commissionerLogin) throws ControllerException;
 /**
     * Returns unfinished election events
     * @param electionId Id of the given election
     * @return election events of the given election
     * @throws ControllerException if election not found
     */
    Collection<ElectionEvent> getUnfinishedElectionEvents(final Integer electionId) throws ControllerException;
  /**
     * Returns an election event relevant to the ID
     * @param eventId
     * @return election event of the given Id
     * @throws ControllerException if election event not found
     */
    ElectionEvent getElectionEvent(final Integer eventId) throws ControllerException;
/**
     * Assigns a commisioner from the persons database to commission an election
     * @param commissioner the given Commissioner
     * @param electionId Id of the given election
     * @throws ControllerException if election not found
     */
    void addCommissioner(final Person person, final Integer electionId) throws ControllerException;
/**
     *
     * @return all elections in database
     */
    Collection<Election> getAllElection();
 /**
     * Returns an election with the given ID
     * @param electionId
     * @return election of the given election Id
     * @throws ControllerException if election not found.
     */
    Election getElection(final Integer electionId) throws ControllerException;
 /**
     *  Returns a collection of commissioners for the inputted election
     * @param electionId Id of the given election
     * @return commissioners of the given election
     * @throws ControllerException if election not found.
     */
    Collection<Commissioner> getElectionCommissioners(final Integer electionId) throws ControllerException;
/**
     * Adds the given voter to the given election event.
     * @param voterLogin login of the given voter
     * @param eventId Id of the given election event
     * @throws ControllerException if election event not found
     */
    void addVoter(final String voterLogin,final Integer eventId) throws ControllerException;
/**
     * Persists the given election event.
     * @param electionEvent
     */
    void changeEvent(final ElectionEvent electionEvent) throws ControllerException;
/**
     * Creates the new election event within the given election, name nad info.
     * @param electionId election where the new election event will  event stand
     * @param name name of the new election event
     * @param info info ot the new election event
     * @throws ControllerException if election not found and .. //TODO description
     */
    void createElectionEvent(final Integer electionId,final String name, final String info) throws ControllerException;
  /**
     *
     * @param eventId Id of the given election event
     * @return voters who vote in the given election event
     * @throws ControllerException if election event not found.
     */
    Collection<Voter> getEventVoters(final Integer eventId) throws ControllerException;
 /**
     *
     * @param login login of the given voter
     * @return ended election events of the given voter
     * @throws ControllerException if voter not found.
     */
    public Collection<ElectionEvent> getEndedEvents(final String login) throws ControllerException;
}
