/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;


import entity.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pojos.ControllerException;

/**
 *
 * @author defiler
 */
@Stateless
public class NominatingSessionBean implements NominatingSessionRemote {

    @EJB
    private ValidatorSessionRemote validatorBean;
    @EJB
    private CounterRemote counterBean;
    @PersistenceContext(unitName = "EvolbyControllerPU")
    private EntityManager em;
    private Boolean nominatingDone = false;

    /**
     * Sets the voter with given login to candidate to given event.
     * @param candidateLogin login of the voter who wants to become a candidate
     * @param electionEventId where the voter want to become a candidate.
     * @param programme
     */
    public void nominate(final String candidateLogin, final Integer electionEventId, final String programme) throws ControllerException {
        ElectionEvent event = em.find(ElectionEvent.class, electionEventId);
        if (event == null) {
            throw new ControllerException("Election event not found");
        }
        Candidate candidate = em.find(Candidate.class, candidateLogin);
        if (candidate == null) {
            candidate = new Candidate();
            candidate.setLogin(candidateLogin);
            candidate.setVotedInEvents(new ArrayList<ElectionEvent>());
            candidate.setProgrammes(new HashMap<ElectionEvent, Programme>());
        } else if (candidate.getVotedInEvents().contains(event)) {
            throw new ControllerException("User is already nominated.");
        }
        Programme programmeEntity = new Programme();
        programmeEntity.setText(programme);
        em.persist(programmeEntity);
        candidate.getProgrammes().put(event, programmeEntity);
        candidate.getVotedInEvents().add(event);
        em.persist(candidate);
        event.getCandidates().add(candidate);
        em.persist(event);
        try {
            counterBean.addCandidate(candidateLogin, electionEventId);
            validatorBean.addCandidate(candidateLogin, electionEventId);
        } catch (Exception ex) {
            em.remove(programmeEntity);
            em.remove(candidate);
            throw new ControllerException(ex.getMessage());
        }
    }

    /**
     *
     * @param login of the voter
     * @return returns list of election events which are in the nominating state
     */
    public List<ElectionEvent> getVoterElectionEvents(String login) throws ControllerException {
        Voter voter = em.find(Voter.class, login);
        if (voter == null) {
            throw new ControllerException("Voter not found");
        }
        Collection<ElectionEvent> events = voter.getElectionEvents();
        List<ElectionEvent> eventsOut = new ArrayList();
        for (ElectionEvent event : events) {
            if (event.getNominatingStarted()) {
                eventsOut.add(event);
            }
        }
        return eventsOut;
    }

    /**
     * Sets the given election event to nominating state.
     * @param eventId
     */
    public void startNominating(final Integer eventId) {
        ElectionEvent event = em.find(ElectionEvent.class, eventId);
        event.setNominatingStarted(true);
        em.persist(event);

    }

    /**
     * Ends the nominating state in the givent election event.
     * @param eventId
     */
    public void endNominating(final Integer eventId) {
        ElectionEvent event = em.find(ElectionEvent.class, eventId);
        event.setNominatingStarted(false);
        em.persist(event);
        nominatingDone = true;
    }

    /**
     *
     * @param eventId
     * @return candidates who are in the given election event.
     */
    public Collection<Candidate> getCandidates(final Integer eventId) {
        ElectionEvent event = em.find(ElectionEvent.class, eventId);
        Collection<Candidate> candidates = event.getCandidates();
        candidates.size();
        return candidates;
    }

    /**
     *
     * @param candidate candidate that you want to delete
     * @param eventId if voting event
     * @throws ControllerException if voter not found.
     */
    public void deleteCandidateFromEvent(Candidate candidate, Integer eventId) throws ControllerException {
        ElectionEvent event = em.find(ElectionEvent.class, eventId);
        Collection<Candidate> candidates = event.getCandidates();
        candidates.size();
        Candidate can = em.find(Candidate.class, candidate.getLogin());
        Collection<ElectionEvent> events = can.getVotedInEvents();
        events.size();
        events.remove(event);
        candidates.remove(can);

        try {
            validatorBean.deleteVoterFromEvent(candidate.getLogin(), eventId);
            counterBean.deleteCandidateFromEvent(candidate.getLogin(), eventId);
        } catch (Exception ex) {
            //TODO db synchronizovano?
            throw new ControllerException(ex.getMessage());
        }
    }

    /**
     *
     * @param eventId id of voting event
     * @return true if nominating already started

     */
    public boolean isStartedNominating(Integer eventId) {
        ElectionEvent ee = em.find(ElectionEvent.class, eventId);
        if (ee.getNominatingStarted()) {
            return true;
        } else {
            return false;
        }
    }
}
