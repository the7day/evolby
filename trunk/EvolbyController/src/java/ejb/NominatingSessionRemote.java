/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entity.*;
import java.util.Collection;
import java.util.List;
import javax.ejb.Remote;
import pojos.ControllerException;

/**
 *
 * @author defiler
 */
@Remote
public interface NominatingSessionRemote {
  /**
     * Sets the voter with given login to candidate in the given event.
     * @param candidateLogin login of the voter who wants to become a candidate
     * @param electionEventId where the voter want to become a candidate.
     * @param programme the election programme of the candidate
     */
    void nominate(final String candidateLogin, final Integer electionEventId, final String programme) throws ControllerException;
/**
     * Returns a collection of nominating event in which the logged user can participate
     * @param login of the voter
     * @return the lis of nominating events
     */
    List<ElectionEvent> getVoterElectionEvents(String login) throws ControllerException;
/**
     * Sets the given election event to nominating state.
     * @param eventId
     */
    void startNominating(final Integer eventId);
 /**
     * Ends the nominating state in the givent election event.
     * @param eventId
     */
    void endNominating(final Integer eventId);
/**
     *
     * @param eventId
     * @return candidates who are in the given election event.
     */
    Collection<Candidate> getCandidates(final Integer eventId);
    
}
