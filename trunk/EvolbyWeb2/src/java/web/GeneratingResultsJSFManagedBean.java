/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.GeneratingResultsSessionRemote;
import ejb.TellerSessionRemote;
import entity.ElectionEvent;
import entity.ElectionResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import pojos.ControllerException;
import sun.misc.Sort;

/**
 *
 * @author defiler
 */
public class GeneratingResultsJSFManagedBean {

    private GeneratingResultsSessionRemote generatingResultsBean;
    private TellerSessionRemote tellerSessionBean;
    private String eventName;
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

            if (results.size() == 0) {
                generatingResultsBean.generateResult(getEventId());
                results = generatingResultsBean.getElectionEventResults(getEventId());
                System.out.println("EXCEPTED");
                return results;


            }
            List<ElectionResult> resList = new ArrayList<ElectionResult>();
            List<ElectionResult> outList = new ArrayList<ElectionResult>();

            try {
                resList.addAll(results);
                int max;
                int pos = 0;
                while(!resList.isEmpty()){
                    pos=0;
                    max = resList.get(0).getVotes();

                    for (int i= 0; i < resList.size(); i++) {
                        if(max<resList.get(i).getVotes()){
                            max=resList.get(i).getVotes();
                            pos=i;

                        }
                    }
                    outList.add(resList.get(pos));
                    resList.remove(pos);


                }
            } catch (Exception ex) {
                System.out.println(ex);
                System.out.println("EXCEPTED2");
                return results;
            }
           results.clear();
            results.addAll(outList);
            System.out.println("CLEARED");
            return results;
        } catch (ControllerException ex) {
            Logger.getLogger(GeneratingResultsJSFManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
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

    public String getEventName() {
        return "fsafsa";
    }

    public void setEventName(String name) {
        eventName = name;
    }
}
