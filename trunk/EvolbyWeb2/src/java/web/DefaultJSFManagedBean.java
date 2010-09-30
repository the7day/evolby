/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author defiler
 */

public class DefaultJSFManagedBean {

    /** Creates a new instance of DefaultJSFManagedBean */
    public DefaultJSFManagedBean() {
    }

    public String logout() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) ec.getSession(true);
        session.invalidate();
        return "logout";
    }
}
