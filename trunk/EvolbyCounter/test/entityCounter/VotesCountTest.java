/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entityCounter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pk
 */
public class VotesCountTest {

    public VotesCountTest() {
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
     * Test of getId method, of class VotesCount.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        VotesCount instance = new VotesCount();
        Integer id = 1;
        instance.setId(id);
        Integer expResult = 1;
        Integer result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class VotesCount.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        testGetId();
    }

    /**
     * Test of getCount method, of class VotesCount.
     */
    @Test
    public void testGetCount() {
        System.out.println("getCount");
        VotesCount instance = new VotesCount();
        Integer id = 1;
        instance.setCount(id);
        Integer expResult = 1;
        Integer result = instance.getCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCount method, of class VotesCount.
     */
    @Test
    public void testSetCount() {
        System.out.println("setCount");
        testGetCount();
    }

    /**
     * Test of getElectionEvent method, of class VotesCount.
     */
    @Test
    public void testGetElectionEvent() {
        System.out.println("getElectionEvent");
        VotesCount instance = new VotesCount();
        CounterElectionEvent a = new CounterElectionEvent();
        instance.setElectionEvent(a);
        CounterElectionEvent expResult = a;
        CounterElectionEvent result = instance.getElectionEvent();
        assertEquals(expResult, result);

    }

    /**
     * Test of setElectionEvent method, of class VotesCount.
     */
    @Test
    public void testSetElectionEvent() {
        System.out.println("setElectionEvent");
        testGetElectionEvent();
    }

    /**
     * Test of getCandidate method, of class VotesCount.
     */
    @Test
    public void testGetCandidate() {
        System.out.println("getCandidate");
        CounterCandidate candidate = new CounterCandidate();
        VotesCount instance = new VotesCount();
        instance.setCandidate(candidate);
        CounterCandidate expResult = candidate;
        CounterCandidate result = instance.getCandidate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCandidate method, of class VotesCount.
     */
    @Test
    public void testSetCandidate() {
        System.out.println("setCandidate");
        testGetCandidate();
    }

    /**
     * Test of hashCode method, of class VotesCount.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        VotesCount instance = new VotesCount();
        int expResult = 0;
        instance.setId(10);
        int result = instance.hashCode();
        assertNotSame(expResult, result);
    }

    /**
     * Test of equals method, of class VotesCount.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        VotesCount instance = new VotesCount();
        VotesCount instance2 = new VotesCount();
        instance.setId(1);
        instance2.setId(2);
        boolean expResult = false;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class VotesCount.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        VotesCount instance = new VotesCount();
        instance.setId(1);
        String expResult = "entityCounter.VotesCount[id=1]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
