package ejb;

import DTO.*;
import javax.ejb.Remote;
import pojos.CounterException;

/**
 *
 * @author mz
 */
@Remote
public interface CounterRemote {

    ElectionEventResultDTO getElectionEventResult(final Integer electionEventId) throws CounterException;

    byte[] createNewElection(final Integer electionId) throws CounterException;

    void createNewElectionEvent(final Integer electionId, final Integer electionEventId) throws CounterException;

    void addCandidate(final String candidateLogin, final Integer electionEventId) throws CounterException;

    void finishElection(Integer electionId);
    
}
