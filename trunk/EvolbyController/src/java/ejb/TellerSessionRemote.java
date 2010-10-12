/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import javax.ejb.Remote;

/**
 *
 * @author defiler
 */
@Remote
public interface TellerSessionRemote {

    String getLoginLoggedUser();
    /**
     * Takes the Username and the password of the logged user, encrypts it and returns
     * @return the encrypted user name and password hash, salted
     */
    String getUserHash();
    
}
