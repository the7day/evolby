/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author defiler
 */
public class VotingCardDTO implements Serializable {

    private String[] candidates;
    private String token;
    private String login;

    public void setToken(String token) {
        this.token = token;
    }

    public String getLogin() {
        return login;
    }

    public VotingCardDTO(String[] candidates, String token, String login, int electionEvent) {
        this.candidates = candidates;
        this.token = token;
        this.login = login;
        this.electionEvent = electionEvent;
    }
    private int electionEvent;

    public VotingCardDTO() {
    }

    public String[] getCandidates() {
        return candidates;
    }

    public void setCandidates(String[] candidates) {
        this.candidates = candidates;
    }

    public int getElectionEvent() {
        return electionEvent;
    }

    public void setElectionEvent(int electionEvent) {
        this.electionEvent = electionEvent;
    }

    public String getToken() {
        return token;
    }

    public void setLogin(String token) {
        this.token = token;
    }
}
