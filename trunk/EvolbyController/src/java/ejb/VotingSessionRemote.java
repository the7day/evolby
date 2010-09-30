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

    CandidateDTO[] getCandidates(final Integer eventId) throws ControllerException;

 /*   byte[] getPublicKey(final Integer electionId) throws ControllerException;*/

    List<ElectionEvent> getVoterElectionEvents(final String login) throws ControllerException;

    void startVoting(final Integer eventId) throws ControllerException;

    void endVoting(final Integer eventId) throws ControllerException;
}
