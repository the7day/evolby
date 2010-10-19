/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entityValidator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author pk
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({entityValidator.ValidatorVoterTest.class,entityValidator.ValidatorVoteTest.class,entityValidator.ValidatorElectionEventTest.class,entityValidator.ValidatorCandidateTest.class})
public class EntityValidatorSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}