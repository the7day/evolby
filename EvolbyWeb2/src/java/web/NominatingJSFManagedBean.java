/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import ejb.NominatingSessionRemote;
import ejb.TellerSessionRemote;
import entity.*;
import java.util.ArrayList;
import java.util.Collection;
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

public class NominatingJSFManagedBean {
 
    private TellerSessionRemote tellerSessionBean; 
    private NominatingSessionRemote nominatingSessionBean;

    private Integer eventId;

    private String programme;
    
    public NominatingJSFManagedBean() {
        Context context;
        try {
            context = new InitialContext();
            tellerSessionBean = (TellerSessionRemote) context.lookup("ejb.TellerSessionRemote");
            nominatingSessionBean = (NominatingSessionRemote) context.lookup("ejb.NominatingSessionRemote");
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
        } catch (ControllerException ex) {
            Logger.getLogger(NominatingJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        return "goMain";
    }

    public String startNominating() {
        nominatingSessionBean.startNominating(getEventId());
        return "goMain";
    }

    public String endNominating() {
        nominatingSessionBean.endNominating(getEventId());
        return "goMain";
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
        if(eventId != null)  {
            return eventId;
        }
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) context.getSession(true);
        return (Integer) session.getAttribute("eventId");
    }

    public void setEventId(Integer eventId) {
        if(eventId == null) return;
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
}
