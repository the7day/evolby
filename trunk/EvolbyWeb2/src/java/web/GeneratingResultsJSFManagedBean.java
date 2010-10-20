/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import ejb.GeneratingResultsSessionRemote;
import ejb.TellerSessionRemote;
import entity.ElectionEvent;
import entity.ElectionResult;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import pojos.ControllerException;

/**
 *
 * @author defiler
 */

public class GeneratingResultsJSFManagedBean {
    private GeneratingResultsSessionRemote generatingResultsBean;
    private TellerSessionRemote tellerSessionBean;

    private Integer eventId;


    public GeneratingResultsJSFManagedBean() {
        Context context;
        try {
            context = new InitialContext();
            tellerSessionBean = (TellerSessionRemote) context.lookup("ejb.TellerSessionRemote");
            generatingResultsBean = (GeneratingResultsSessionRemote) context.lookup("ejb.GeneratingResultsSessionRemote");
        } catch (NamingException ex) {
            Logger.getLogger(CreateElectionJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Collection<ElectionEvent> getEndedEvents() {
        String login = tellerSessionBean.getLoginLoggedUser();
        try {
            return generatingResultsBean.getEndedEvents(login);
        } catch (ControllerException ex) {
            Logger.getLogger(GeneratingResultsJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Collection<ElectionResult> getElectionEventResults() {
        try {
            Collection<ElectionResult> results = generatingResultsBean.getElectionEventResults(getEventId());
            if(results.size() == 0) {
                generatingResultsBean.generateResult(getEventId());
                results = generatingResultsBean.getElectionEventResults(getEventId());
            }
            return results;
        } catch (ControllerException ex) {
            Logger.getLogger(GeneratingResultsJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
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
}
