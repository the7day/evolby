/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.CreatingElectionSessionRemote;
import ejb.NominatingSessionRemote;
import ejb.TellerSessionRemote;
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
 * @author lordondrak
 */
public class CreateElectionEventJSFManagedBean {

    private CreatingElectionSessionRemote electionSessionBean;
    private TellerSessionRemote tellerSessionBean;
    private NominatingSessionRemote nominatingSessionBean;
    private String eventName;
    private String voterLogin;
    private String info;
    private Integer elecId;
    private Integer eventId;
    private String voterName;
    private ElectionEvent electionEvent;
    private List<SelectItem> voterSel;
    private DataModel unfinishedElectionEvents;
    private DataModel comToEndNominatingModel;

    public CreateElectionEventJSFManagedBean() {
        Context context;
        try {
            context = new InitialContext();
            electionSessionBean = (CreatingElectionSessionRemote) context.lookup("ejb.CreatingElectionSessionRemote");
            nominatingSessionBean = (NominatingSessionRemote) context.lookup("ejb.NominatingSessionRemote");
            tellerSessionBean = (TellerSessionRemote) context.lookup("ejb.TellerSessionRemote");
        } catch (NamingException ex) {
            Logger.getLogger(CreateElectionJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PostConstruct
    public void fill() {
        Integer id = getEventId();
        if (id == null) {
            return;
        }
        ElectionEvent electionEvent;
        try {
            electionEvent = electionSessionBean.getElectionEvent(id);
            this.eventName = electionEvent.getName();
            this.info = electionEvent.getInfo();
        } catch (ControllerException ex) {
            Logger.getLogger(CreateElectionEventJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String createEvent() {
        try {
            electionSessionBean.createElectionEvent(elecId, eventName, info);
            FacesMessage m = new FacesMessage("Event was succesfully created");
            FacesContext.getCurrentInstance().addMessage("", m);
        } catch (ControllerException ex) {
            Logger.getLogger(CreateElectionEventJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        setElecId(elecId);
        return "goViewEvents";
    }

    public String viewEvent() {
        setEventId(eventId);
        return "goViewEvent";
    }

    public String changeEvent() {
        try {
            ElectionEvent electionEvent = electionSessionBean.getElectionEvent(getEventId());
            electionEvent.setName(eventName);
            electionEvent.setInfo(info);
            electionSessionBean.changeEvent(electionEvent);
            FacesMessage m = new FacesMessage("Event was succesfully changed");
            FacesContext.getCurrentInstance().addMessage("", m);
        } catch (ControllerException ex) {
            Logger.getLogger(CreateElectionEventJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }

        return "";
    }

    public String addVoter() {
        Collection<Person> personList = getPersonList();
        Person finalPerson = null;
        for (Person p : personList) {
            if (p.getLogin().equals(voterLogin)) {
                finalPerson = p;
                break;
            }
        }
        if (finalPerson == null) {
            return "";
        }
        try {
            electionSessionBean.addVoter(voterLogin, getEventId());
            FacesMessage m = new FacesMessage("Voter " + voterLogin + " was successfully added");
            FacesContext.getCurrentInstance().addMessage("", m);
        } catch (ControllerException ex) {
            Logger.getLogger(CreateElectionEventJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        return "";
    }

    public Collection<Voter> getEventVoters() {
        try {
            return electionSessionBean.getEventVoters(getEventId());
        } catch (ControllerException ex) {
            Logger.getLogger(CreateElectionEventJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<SelectItem> getVoterSel() {
        Collection<Person> col = electionSessionBean.getAllPerson();
        voterSel = new ArrayList<SelectItem>();
        for (int i = 0; i < col.size(); i++) {
            voterSel.add(new SelectItem(((Person) col.toArray()[i]).getLogin()));
        }
        return voterSel;
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

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    private Collection<Person> getPersonList() {
        return electionSessionBean.getAllPerson();
    }

    public Collection<ElectionEvent> getUnfinishedElectionEvents() {
        try {
            return electionSessionBean.getUnfinishedElectionEvents(elecId);
        } catch (ControllerException ex) {
            Logger.getLogger(CreateElectionEventJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public DataModel getUnfinishedElectionEventsModel() {
        unfinishedElectionEvents = new ListDataModel((List) getUnfinishedElectionEvents());
        return unfinishedElectionEvents;
    }

    public DataModel getComToEndNominatingModel() {
        comToEndNominatingModel = new ListDataModel((List) getComToEndNominating());
        return comToEndNominatingModel;
    }

    public Collection<Commissioner> getComToEndNominating() {
        //ElectionEvent ev = (ElectionEvent) unfinishedElectionEvents.getRowData();
        return nominatingSessionBean.getComToEndNominating(getEventId());
    }

    public Collection<ElectionEvent> getEndedEvents() {
        String login = tellerSessionBean.getLoginLoggedUser();
        try {
            return electionSessionBean.getEndedEvents(login);
        } catch (ControllerException ex) {
            Logger.getLogger(CreateElectionEventJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Collection<Election> getComElection() {
        String login = tellerSessionBean.getLoginLoggedUser();
        try {
            return electionSessionBean.getCommissionerElection(login);
        } catch (ControllerException ex) {
            Logger.getLogger(CreateElectionEventJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean isRenderAlert() {
        ElectionEvent ee = (ElectionEvent) unfinishedElectionEvents.getRowData();
        String login = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        if (nominatingSessionBean.alertCommissioner(ee.getId(), login, elecId)) {
            return true;
        } else {
            return false;
        }
    }

    public String viewResultEvent() {
        return "goViewResultEvent";
    }

    public void setElecId(Integer elecId) {
        this.elecId = elecId;
    }

    public Integer getElecId() {
        return elecId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getVoterLogin() {
        return voterLogin;
    }

    public void setVoterLogin(String voterLogin) {
        this.voterLogin = voterLogin;
    }
}
