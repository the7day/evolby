/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Person;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author defiler
 */
@Stateless
public class TellerSessionBean implements TellerSessionRemote {

    @PersistenceContext(unitName = "EvolbyControllerPU")
    private EntityManager em;
    @Resource
    private SessionContext ctx;


    public  String getLoginLoggedUser() {
        return ctx.getCallerPrincipal().getName();
    }

    /**
     *
     * @author Finkky
     */
    private String getPasswordLoggedUser() {
        String name = ctx.getCallerPrincipal().getName();
        Person loggedPerson = em.find(Person.class, name);
        String passwordHash = loggedPerson.getPassword();
        return passwordHash;
    }
    private static final String salt = "c5300d2776f5143c5c803b4aaec2";
    public String getUserHash() {
        String uname = getLoginLoggedUser();
        String passwordhash = getPasswordLoggedUser();

        return encryptSHA(uname + passwordhash, salt);
    }

    private static String encryptSHA(String data, final String salt) {
        String enc = "";
        try {
            String mode = "HmacSHA256";
            byte[] keyBytes = salt.getBytes("utf-8");
            final SecretKey key = new SecretKeySpec(keyBytes, mode);
            Mac mac = Mac.getInstance(mode);
            mac.init(key);
            byte[] digest = mac.doFinal(data.getBytes("utf-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            enc = sb.toString();
        } catch (Exception e) {
        }
        return enc;
    }
}
