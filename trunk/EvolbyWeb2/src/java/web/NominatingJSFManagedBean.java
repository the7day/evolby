/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.NominatingSessionRemote;
import ejb.TellerSessionRemote;
import ejb.VotingSessionRemote;
import entity.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import pojos.ControllerException;

/**
 *
 * @author defiler
 */
public class NominatingJSFManagedBean {

    private DataModel candidatesModel;
    private TellerSessionRemote tellerSessionBean;
    private NominatingSessionRemote nominatingSessionBean;
    private VotingSessionRemote votingSessionBean;
    private Integer eventId;
    private String programme;
    private Candidate candidate;

    public NominatingJSFManagedBean() {
        Context context;
        try {
            context = new InitialContext();
            tellerSessionBean = (TellerSessionRemote) context.lookup("ejb.TellerSessionRemote");
            nominatingSessionBean = (NominatingSessionRemote) context.lookup("ejb.NominatingSessionRemote");
            votingSessionBean = (VotingSessionRemote) context.lookup("ejb.VotingSessionRemote");
        } catch (NamingException ex) {
            Logger.getLogger(CreateElectionJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String goNominate() {
        return "goNominate";
    }

    public String nominate() {
        setEventId(eventId);
        String login = tellerSessionBean.getLoginLoggedUser();
        try {
            nominatingSessionBean.nominate(login, getEventId(), programme);
            FacesMessage m = new FacesMessage("You were successfully nominated");
            FacesContext.getCurrentInstance().addMessage("", m);
        } catch (ControllerException ex) {
            Logger.getLogger(NominatingJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        return "goMain";
    }

    public String startNominating() {
        nominatingSessionBean.startNominating(getEventId());
        FacesMessage m = new FacesMessage("Nominating started");
        FacesContext.getCurrentInstance().addMessage("", m);
        return "";
    }

    public String endNominating() {
        nominatingSessionBean.endNominating(getEventId());
        FacesMessage m = new FacesMessage("Nominating ended");
        FacesContext.getCurrentInstance().addMessage("", m);
        return "";
    }

    public boolean isRenderStartNominating() {
        eventId = getEventId();
        if ((nominatingSessionBean.isStartedNominating(eventId) == false) && (votingSessionBean.isStartedVoting(eventId) == false) && (isAnyoneNominated() == false)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isRenderEndNominating() {
        eventId = getEventId();
        if ((nominatingSessionBean.isStartedNominating(eventId) == true) && (votingSessionBean.isStartedVoting(eventId) == false)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isRenderStartVoting() {
        eventId = getEventId();
        if ((nominatingSessionBean.isStartedNominating(eventId) == false) && (votingSessionBean.isStartedVoting(eventId) == false) && (isAnyoneNominated() == true)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isRenderEndVoting() {
        eventId = getEventId();
        if ((nominatingSessionBean.isStartedNominating(eventId) == false) && (votingSessionBean.isStartedVoting(eventId) == true) && (isAnyoneNominated() == true)) {
            return true;
        } else {
            return false;
        }
    }

    public List<SelectItem> getSelectItems() {
        try {
            String login = tellerSessionBean.getLoginLoggedUser();
            Collection<ElectionEvent> electionEvents = nominatingSessionBean.getVoterElectionEvents(login);
            List<SelectItem> items = new ArrayList<SelectItem>();
            for (ElectionEvent event : electionEvents) {
                items.add(new SelectItem(event.getId()));
            }
            return items;
        } catch (ControllerException ex) {
            Logger.getLogger(NominatingJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Collection<Candidate> getCandidates() {
        return nominatingSessionBean.getCandidates(getEventId());
    }

    public Integer getEventId() {
        if (eventId != null) {
            return eventId;
        }
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) context.getSession(true);
        return (Integer) session.getAttribute("eventId");
    }

    public void setEventId(Integer eventId) {
        if (eventId == null) {
            return;
        }
        this.eventId = eventId;
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) context.getSession(true);
        session.setAttribute("eventId", eventId);
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public DataModel getCandidatesModel() {
        candidatesModel = new ListDataModel((List) getCandidates());
        return candidatesModel;
    }

    public String deleteCandidate() {
        this.candidate = (Candidate) candidatesModel.getRowData();
        this.eventId = getEventId();
        try {
            nominatingSessionBean.deleteCandidateFromEvent(candidate, eventId);
            FacesMessage m = new FacesMessage("Candidate " + candidate.getLogin() + " was successfully removed");
            FacesContext.getCurrentInstance().addMessage("nic", m);
        } catch (ControllerException ex) {
            Logger.getLogger(VotingJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        return "";

    }

    public boolean isAnyoneNominated() {
        int count = 0;
        count = getCandidates().size();
        if (count > 0) {
            return true;
        } else {
            return false;
        }

    }
}
