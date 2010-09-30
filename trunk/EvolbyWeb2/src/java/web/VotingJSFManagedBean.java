/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.GeneratingResultsSessionRemote;
import ejb.TellerSessionRemote;
import ejb.VotingSessionRemote;
import entity.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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
public class VotingJSFManagedBean {

    private TellerSessionRemote tellerSessionBean;
    private VotingSessionRemote votingSessionBean;
    private Integer eventId;

    public VotingJSFManagedBean() {
        Context context;
        try {
            context = new InitialContext();
            tellerSessionBean = (TellerSessionRemote) context.lookup("ejb.TellerSessionRemote");
            votingSessionBean = (VotingSessionRemote) context.lookup("ejb.VotingSessionRemote");
        } catch (NamingException ex) {
            Logger.getLogger(CreateElectionJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PostConstruct
    public void validate() {
        //TODO kontrola jestli komisarovi patri electionID a eventId
    }

    public String goVote() {
        setEventId(eventId);
        return "goVote";
    }

    public String startVoting() {
        try {
            votingSessionBean.startVoting(getEventId());
        } catch (ControllerException ex) {
            Logger.getLogger(VotingJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        return "goMain";
    }

    public String endVoting() {
        try {
            votingSessionBean.endVoting(getEventId());
        } catch (ControllerException ex) {
            Logger.getLogger(VotingJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        return "goMain";
    }

    public List<SelectItem> getSelectItems() {
        try {
            String login = tellerSessionBean.getLoginLoggedUser();
            List<ElectionEvent> electionEvents = votingSessionBean.getVoterElectionEvents(login);
            List<SelectItem> items = new ArrayList<SelectItem>();
            for (ElectionEvent event : electionEvents) {
                items.add(new SelectItem(event.getId()));
            }
            return items;
        } catch (ControllerException ex) {
            Logger.getLogger(VotingJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getToken() {
        return tellerSessionBean.getUserHash();
    }

    public String getLogin() {
        return tellerSessionBean.getLoginLoggedUser();
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
}
