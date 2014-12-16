package com.team11.Tracker.Tests;

import com.team11.Tracker.Model.Portfolio;
import com.team11.Tracker.Model.Share;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PortfolioTest {


    Portfolio folio;
    String portFolioName = "PortfolioName";
    Share s1;
    Share s2;
    @Before
    public void setUp() throws Exception {
        folio = new Portfolio(portFolioName);
        s1 = new Share("AAPL", 10.0, 10);
        s2 = new Share("MSFT", 10.0, 10);
        folio.getShares().add(s1);
        folio.getShares().add(s2);

    }

    @Test
    public void testGetShares() throws Exception {
        ArrayList<Share> expectedArray = new ArrayList<Share>();
        expectedArray.add(s1);
        expectedArray.add(s2);
        ArrayList<Share> getSharesArray = folio.getShares();
        assertEquals(expectedArray,getSharesArray);
    }

    @Test
    public void testGetPortfolioName() throws Exception {
        assertEquals(portFolioName, folio.getPortfolioName());
    }

    @Test
    public void testUpdateAllShares() throws Exception {

    }

    @Test
    public void testGetFolioValue() throws Exception {
        // 0.0001 is the epsilon
        // doubles won't be EXACTLY the same
        // This helps account for that
        assertEquals(folio.getFolioValue(), 200, 0.0001);
    }

    @Test
    public void testAddShare() throws Exception {

    }

    @Test
    public void testAddShare1() throws Exception {

    }

    @Test
    public void testSellShare() throws Exception {

    }

    @Test
    public void testOwnShare() throws Exception {
        assertTrue(folio.ownShare("AAPL"));
        assertFalse(folio.ownShare("VZ"));
    }

    @Test
    public void testGetShare() throws Exception {
        assertEquals(folio.getShare("AAPL"), s1);
    }
}