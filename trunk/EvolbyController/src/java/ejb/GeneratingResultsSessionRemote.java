/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entity.ElectionEvent;
import entity.ElectionResult;
import java.util.Collection;
import javax.ejb.Remote;
import pojos.ControllerException;

/**
 *
 * @author defiler
 */
@Remote
public interface GeneratingResultsSessionRemote {
 /**
     * Generates result for the given election event.
     * @param eventId Id of the given election event
     * @throws ControllerException if election event not found
     */
    void generateResult(final Integer eventId) throws ControllerException;
  /**
     * Finishes the given election event.
     * @param eventId id of the given election event
     */
    void finishElectionEvent(final Integer eventId) throws ControllerException;
 /**
     * Finishes the given election.
     * Notices the counter modul about it.
     * @param electionId id of the given election
     * @todo implement election finishing
     */
    void finishElection(final Integer electionId);
 /**
     *
     * @param login login of the given voter
     * @return ended election events of the given voter
     * @throws if voter not found
     */
    Collection<ElectionEvent> getEndedEvents(final String login) throws ControllerException;
 /**
     *
     * @param eventId id of the given election event
     * @return ElectionResults of the given election event
     * @throws if election event not found
     */
    Collection<ElectionResult> getElectionEventResults(final Integer eventId) throws ControllerException;

}
