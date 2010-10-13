/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import DTO.ElectionEventResultDTO;
import entity.Candidate;
import entity.ElectionEvent;
import entity.ElectionResult;
import entity.Voter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pojos.ControllerException;
import pojos.CounterException;
import pojos.ValidatorException;

/**
 *
 * @author defiler
 */
@Stateless
public class GeneratingResultsSessionBean implements GeneratingResultsSessionRemote {
    @EJB
    private ValidatorSessionRemote validatorSessionBean;
    @PersistenceContext(unitName="EvolbyControllerPU")
    private EntityManager em;
    @EJB
    private CounterRemote counterBean;

    /**
     * Finishes the given election event.
     * @param eventId id of the given election event
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW )
    public void finishElectionEvent(final Integer eventId) throws ControllerException {
        ElectionEvent electionEvent = em.find(ElectionEvent.class, eventId);
        if(electionEvent == null) {
            throw new ControllerException("Election event not found.");
        }
        try {
            validatorSessionBean.endElectionEvent(eventId);
        } catch (ValidatorException ex) {
            throw new ControllerException(ex.getMessage());
        }
        electionEvent.setFinished(Boolean.TRUE);
        em.persist(electionEvent);
    }

    /**
     * Finishes the given election.
     * Notices the counter modul about it.
     * @param electionId id of the given election
     * @todo implement election finishing
     */
    public void finishElection(final Integer electionId) {
        //counterBean.finishElection(electionId);
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Generates result for the given election event.
     * @param eventId Id of the given election event
     * @throws ControllerException if election event not found
     */
    public void generateResult(final Integer eventId) throws ControllerException {
        ElectionEvent event = em.find(ElectionEvent.class, eventId);
        if(event == null) {
            throw new ControllerException("Election event not found.");
        }
        ElectionEventResultDTO resultDTO = null;
        try {
            resultDTO = counterBean.getElectionEventResult(eventId);
        } catch (CounterException ex) {
            throw new ControllerException(ex.getMessage());
        }
        ElectionResult result;
        Candidate candidate;
        int size = resultDTO.getCandidates().length;
        System.out.println("ResultDTO size: " + size);
        for(int i=0; i<size; i++) {
            result = new ElectionResult();
            result.setElectionEvent(event);
            candidate = em.find(Candidate.class, resultDTO.getCandidates()[i]);
            if(candidate == null) {
                throw new ControllerException("Candidate not found.");
            }
            result.setCandidate(candidate);
            result.setVotes(resultDTO.getVotes()[i]);
            em.persist(result);
            event.getElectionResults().add(result);
        }
        em.persist(event);
    }

    /**
     *
     * @param login login of the given voter
     * @return ended election events of the given voter
     * @throws if voter not found
     */
    public Collection<ElectionEvent> getEndedEvents(final String login) throws ControllerException {
        Voter voter = em.find(Voter.class, login);
        if(voter == null) {
            throw new ControllerException("Voter not found.");
        }
        Collection<ElectionEvent> eventsOut = new ArrayList<ElectionEvent>();
        for(ElectionEvent event : voter.getElectionEvents()) {
            if(event.getFinished()) {
                eventsOut.add(event);
            }
        }
        return eventsOut;
    }

    /**
     * 
     * @param eventId id of the given election event
     * @return ElectionResults of the given election event
     * @throws if election event not found
     */
    public Collection<ElectionResult> getElectionEventResults(final Integer eventId) throws ControllerException {
        ElectionEvent electionEvent = em.find(ElectionEvent.class, eventId);
        if(electionEvent == null) {
            throw new ControllerException("Election event not found.");
        }
        Collection<ElectionResult> electionResults = electionEvent.getElectionResults();
        electionResults.size(); // hack
        return electionResults;
    }
}
