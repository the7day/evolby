/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import org.junit.Ignore;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import entity.Election;
import entity.ElectionEvent;
import entity.Person;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.lang.NullPointerException;
import static org.junit.Assert.*;

/**
 *
 * @author Murko
 */
public class CreatingElectionSessionBeanTest {
 @PersistenceContext(unitName="EvolbyControllerPU")
    private EntityManager em;
    @PersistenceContext(unitName="EvolbyControllerPU2")
    private EntityManager em2;
    public CreatingElectionSessionBeanTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
 
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createElection method, of class CreatingElectionSessionBean.
     */
 //   @Test(expected=java.lang.NullPointerException.class)
    @Ignore
    @Test
    public void testCreateElection() throws Exception {
        System.out.println("createElection");
        String electionName = "testName";
        String electionType = "testType";
        Collection<Election> asd = null;

        CreatingElectionSessionBean instance = new CreatingElectionSessionBean();
   
        instance.createElection(electionName, electionType); 
        asd = instance.getAllElection();
        if (asd == null) fail("Horrible error");
        assertTrue(asd.size()==1);
    }

    /**
     * Test of getAllPerson method, of class CreatingElectionSessionBean.
     */
    @Test
    @Ignore
    public void testGetAllPerson() {
        System.out.println("getAllPerson");
        CreatingElectionSessionBean instance = new CreatingElectionSessionBean();
        Collection expResult = null;
        Collection result = instance.getAllPerson();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCommissionerElection method, of class CreatingElectionSessionBean.
     */
    @Test
    @Ignore
    public void testGetCommissionerElection() throws Exception {
        System.out.println("getCommissionerElection");
        String commissionerLogin = "";
        CreatingElectionSessionBean instance = new CreatingElectionSessionBean();
        Collection expResult = null;
        Collection result = instance.getCommissionerElection(commissionerLogin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnfinishedElectionEvents method, of class CreatingElectionSessionBean.
     */
    @Test
    @Ignore
    public void testGetUnfinishedElectionEvents() throws Exception {
        System.out.println("getUnfinishedElectionEvents");
        Integer electionId = null;
        CreatingElectionSessionBean instance = new CreatingElectionSessionBean();
        Collection expResult = null;
        Collection result = instance.getUnfinishedElectionEvents(electionId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addVoter method, of class CreatingElectionSessionBean.
     */
    @Test
    @Ignore
    public void testAddVoter() throws Exception {
        System.out.println("addVoter");
        String voterLogin = "";
        Integer eventId = null;
        CreatingElectionSessionBean instance = new CreatingElectionSessionBean();
        instance.addVoter(voterLogin, eventId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCommissioner method, of class CreatingElectionSessionBean.
     */
    @Test
    @Ignore
    public void testAddCommissioner() throws Exception {
        System.out.println("addCommissioner");
        Person person = null;
        Integer electionId = null;
        CreatingElectionSessionBean instance = new CreatingElectionSessionBean();
        instance.addCommissioner(person, electionId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllElection method, of class CreatingElectionSessionBean.
     */
    @Test
    @Ignore
    public void testGetAllElection() {
        System.out.println("getAllElection");
        CreatingElectionSessionBean instance = new CreatingElectionSessionBean();
        Collection expResult = null;
        Collection result = instance.getAllElection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getElectionCommissioners method, of class CreatingElectionSessionBean.
     */
    @Test
    @Ignore
    public void testGetElectionCommissioners() throws Exception {
        System.out.println("getElectionCommissioners");
        Integer electionId = null;
        CreatingElectionSessionBean instance = new CreatingElectionSessionBean();
        Collection expResult = null;
        Collection result = instance.getElectionCommissioners(electionId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getElectionEvent method, of class CreatingElectionSessionBean.
     */
    @Test
    @Ignore
    public void testGetElectionEvent() throws Exception {
        System.out.println("getElectionEvent");
        Integer eventId = null;
        CreatingElectionSessionBean instance = new CreatingElectionSessionBean();
        ElectionEvent expResult = null;
        ElectionEvent result = instance.getElectionEvent(eventId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeEvent method, of class CreatingElectionSessionBean.
     */
    @Test
    @Ignore
    public void testChangeEvent() {
        System.out.println("changeEvent");
        ElectionEvent electionEvent = null;
        CreatingElectionSessionBean instance = new CreatingElectionSessionBean();
        instance.changeEvent(electionEvent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createElectionEvent method, of class CreatingElectionSessionBean.
     */
    @Test
    @Ignore
    public void testCreateElectionEvent() throws Exception {
        System.out.println("createElectionEvent");
        Integer electionId = null;
        String name = "";
        String info = "";
        CreatingElectionSessionBean instance = new CreatingElectionSessionBean();
        instance.createElectionEvent(electionId, name, info);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEventVoters method, of class CreatingElectionSessionBean.
     */
    @Test
    @Ignore
    public void testGetEventVoters() throws Exception {
        System.out.println("getEventVoters");
        Integer eventId = null;
        CreatingElectionSessionBean instance = new CreatingElectionSessionBean();
        Collection expResult = null;
        Collection result = instance.getEventVoters(eventId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEndedEvents method, of class CreatingElectionSessionBean.
     */
    @Test
    @Ignore
    public void testGetEndedEvents() throws Exception {
        System.out.println("getEndedEvents");
        String login = "";
        CreatingElectionSessionBean instance = new CreatingElectionSessionBean();
        Collection expResult = null;
        Collection result = instance.getEndedEvents(login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getElection method, of class CreatingElectionSessionBean.
     */
    @Test
    @Ignore
    public void testGetElection() throws Exception {
        System.out.println("getElection");
        Integer electionId = null;
        CreatingElectionSessionBean instance = new CreatingElectionSessionBean();
        Election expResult = null;
        Election result = instance.getElection(electionId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}