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

    void nominate(final String candidateLogin, final Integer electionEventId, final String programme) throws ControllerException;

    List<ElectionEvent> getVoterElectionEvents(String login) throws ControllerException;

    void startNominating(final Integer eventId);

    void endNominating(final Integer eventId);

    Collection<Candidate> getCandidates(final Integer eventId);
    
}
