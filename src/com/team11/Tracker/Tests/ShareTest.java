package com.team11.Tracker.Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.team11.Tracker.Model.Share;

public class ShareTest {
	
	Share s;

	@Before
	public void setUp() throws Exception {
		s = new Share("AAPL", 10.0, 10);
		Share s2 = new Share ("MSFT", 10.0, 5.0, 20);
	}

	@Test
	public void testGetAndSetAmount() {
		int newAmountOwned = s.getAmountOwned();
		assertEquals(newAmountOwned, 10);
		s.setAmountOwned(20);
		newAmountOwned = s.getAmountOwned();
		assertEquals(newAmountOwned, 20);
	}

	@Test
	public void testUpdateShare() {
		s.updateShare();
		assertNotEquals(s.getCurrentSharePrice(), 10.0, 0.001);
	}

	@Test
	public void testGetAndSetCurrentSharePrice() {
		assertEquals(s.getCurrentSharePrice(), 10.0, 0.001);
		
		s.setCurrentSharePrice(20.0);
		
		assertEquals(s.getCurrentSharePrice(), 20.0, 0.001);
	}


	@Test
	public void testGetPreviousPrice() {
		s.updateShare();
		
		assertEquals(s.getPreviousPrice(), 10.0, 0.001);
	}

	@Test
	public void testGetTicker() {
		assertEquals(s.getTicker(), "AAPL");
	}

	@Test
	public void testToString() {
		String expected = "AAPL" + " "  + 10 + " " + 10.0 + " " + 10.0;
		assertEquals(s.toString(), expected);
	}

}
