package voteapplet2;

/**
 * Trida reprezantujici kandidata.
 * @author Tomáš Čerevka
 */
public class Candidate {

    private String login;
    private String firstName;
    private String surname;
    private boolean elected;

    /**
     * Vytvori kandidata.
     * @param login Login kandidata.
     * @param firstName Krestni jmeno kandidata.
     * @param surname Prijmeni kandidata.
     */
    public Candidate(String login, String firstName, String surname) {
        this.login = login;
        this.firstName = firstName;
        this.surname = surname;
        this.elected = false;
    }

    /**
     * Vrati login kandidata.
     * @return Login kandidata.
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * Vrati krestni jmeno kandidata.
     * @return Krestni jmeno kandidata.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Vrati prijmeni kandidata.
     * @return Prijmeni kandidata.
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Vrati cele jmeno kandidata.
     * @return Cele jmeno kandidata.
     */
    public String getName() {
        return this.firstName + " " + this.surname;
    }

    /**
     * Zjisti, zda byl kandidat zvolen.
     * @return true = zvolen, false = nezvolen.
     */
    public boolean isElected() {
        return this.elected;
    }

    /**
     * Nastavi priznak zvoleni/nezvoleni.
     * @param elected Priznak - true = zvolen, false = nezvolen.
     */
    public void setElected(boolean elected) {
        this.elected = elected;
    }

}
