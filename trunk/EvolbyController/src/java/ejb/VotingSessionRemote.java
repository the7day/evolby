/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

/*import DTO.CandidateDTO;*/
import DTO.CandidateDTO;
import entity.*;
import java.util.List;
import javax.ejb.Remote;
import pojos.ControllerException;

/**
 *
 * @author defiler
 */
@Remote
public interface VotingSessionRemote {
/**
     * Method for the voteApplet, creates and array of CandidateDTO for a given election event
     * which is then possible to communicate to the client
     * @param eventId Id of the given election event
     * @return filled field of CandidateDTO of the given election event for voteApplet
     */
    CandidateDTO[] getCandidates(final Integer eventId) throws ControllerException;

 /*   byte[] getPublicKey(final Integer electionId) throws ControllerException;*/
 /**
     * Creates a list of open election events for the given voter
     * @param login of the voter
     * @return list of election events which are in the voting state
     */
    List<ElectionEvent> getVoterElectionEvents(final String login) throws ControllerException;
/**
     * Sets the given election event to voting state.
     * @param eventId
     */
    void startVoting(final Integer eventId) throws ControllerException;
 /**
     * Ends the voting state in the givent election event.
     * Starts GeneratingResults process.
     * Notifies about it the validator modul.
     * @param eventId
     */
    void endVoting(final Integer eventId) throws ControllerException;
}
