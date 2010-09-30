/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;


import DTO.CandidateDTO;
import entity.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pojos.ControllerException;
import pojos.ValidatorException;

/**
 *
 * @author defiler
 */
@Stateless
public class VotingSessionBean implements VotingSessionRemote {
    @EJB
    private ValidatorSessionRemote validatorSessionBean;
    @EJB
    private GeneratingResultsSessionRemote generatingResultsSessionBean;

    @PersistenceContext(unitName="EvolbyControllerPU")
    private EntityManager em;
    @PersistenceContext(unitName="EvolbyControllerPU2")
    private EntityManager em2;

    /**
     * Method for the voteApplet
     * @param eventId Id of the given election event
     * @return filled field of CandidateDTO of the given election event for voteApplet
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW )
    public CandidateDTO[] getCandidates(final Integer eventId) throws ControllerException {
        ElectionEvent electionEvent = em.find(ElectionEvent.class, eventId);
        if(electionEvent == null) {
            throw new ControllerException("Election event not found.");
        }
        Collection<Candidate> candidates = electionEvent.getCandidates();
        CandidateDTO candidatesDTO[]  = new CandidateDTO[candidates.size()];
        CandidateDTO c;
        int i = 0;
        for(Candidate candidate : candidates) {
            c = new CandidateDTO();
            c.setLogin(candidate.getLogin());
            //c.setProgramme(candidate.getProgrammes().get(electionEvent).getText());
            Person person = getPerson(candidate.getLogin());
            c.setFirstName(person.getFirstname());
            c.setLastName(person.getLastname());
            candidatesDTO[i] = c;
            i++;
        }
        return candidatesDTO;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW )
    private Person getPerson(String login) throws ControllerException {
        Person person = em2.find(Person.class, login);
        if(person == null) {
            throw new ControllerException("Person not found.");
        }
        return person;
    }

    /**
     * 
     * @param electionId Id of the given election
     * @return public key of the given election
     */
 /*   public byte[] getPublicKey(final Integer electionId) throws ControllerException {
        Election election = em.find(Election.class, electionId);
        if(election == null) {
            throw new ControllerException("Election not found.");
        }
        return election.getPublicKey();
    }

    /**
     *
     * @param login of the voter
     * @return list of election events which are in the voting state
     */
    public List<ElectionEvent> getVoterElectionEvents(final String login) throws ControllerException {
        Voter voter = em.find(Voter.class, login);
        if(voter == null) {
            throw new ControllerException("Voter not found.");
        }
        Collection<ElectionEvent> events = voter.getElectionEvents();
        List<ElectionEvent> eventsOut = new ArrayList<ElectionEvent>();
        for(ElectionEvent event : events) {
            if(event.getVotingStarted()) {
                eventsOut.add(event);
            }
        }
        return eventsOut;
    }

    /**
     * Sets the given election event to voting state.
     * @param eventId
     */
    public void startVoting(final Integer eventId) throws ControllerException {
        ElectionEvent event = em.find(ElectionEvent.class, eventId);
        if(event == null) {
            throw new ControllerException("Election event not found.");
        }
        event.setVotingStarted(true);
        em.persist(event);
        try {
            validatorSessionBean.startVoting(eventId);
        } catch (ValidatorException ex) {
            throw new ControllerException(ex.getMessage());
        }
    }

    /**
     * Ends the voting state in the givent election event.
     * Starts GeneratingResults process.
     * Notifies about it the validator modul.
     * @param eventId
     */
    public void endVoting(final Integer eventId) throws ControllerException {
        ElectionEvent event = em.find(ElectionEvent.class, eventId);
        if(event == null) {
            throw new ControllerException("Election event not found.");
        }
        event.setVotingStarted(false);
        em.persist(event);
        try {
            validatorSessionBean.endVoting(eventId);
        } catch (ValidatorException ex) {
            throw new ControllerException(ex.getMessage());
        }
        generatingResultsSessionBean.finishElectionEvent(eventId);
    }
}
