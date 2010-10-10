/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

/**
 * Class of ValidatorException.
 * @author defiler
 */
public class ValidatorException extends Exception {
    String msg;

    /**
     * Creates validaor's expection.
     * @param msg Message of exception.
     */
    public ValidatorException(String msg) {
        super(msg);
        this.msg = msg;
    }


}
