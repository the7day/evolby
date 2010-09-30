/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package voteapplet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lordondrak
 */
public class ResultSet {
    
    private List<Result> results;

    public ResultSet(){
        results = new ArrayList<Result>();
    }
    public void add(String login, String firstName, String lastName, boolean vote){
        Result result = new Result();
        result.setLogin(login);
        result.setFirstName(firstName);
        result.setLastName(lastName);
        result.setVote(vote);
        results.add(result);
    }

    public List<Result> getResults() {
        return results;
    }


}
