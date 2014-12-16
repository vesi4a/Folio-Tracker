package com.team11.Tracker.Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.team11.Tracker.Model.Portfolio;
import com.team11.Tracker.Model.PortfolioHolder;

public class PortfolioHolderTest {

	PortfolioHolder holder;
	Portfolio p1;
	Portfolio p2;
	
	
	@Before
	public void setUp() throws Exception {
		holder = new PortfolioHolder();
		
		p1 = new Portfolio("P1");
		p2 = new Portfolio("P2");
		
		holder.addPortfolio(p1);
		holder.addPortfolio(p2);
	}

	@Test
	public void testPortfolioHolder() {
	}

	@Test
	public void testGetPortfolios() {
		assertEquals(holder.getPortfolios().size(), 2);
	}

	@Test
	public void testAddPortfolio() {
		Portfolio p3 = new Portfolio("p3");
		holder.addPortfolio(p3);
		assertEquals(holder.getPortfolios().size(), 3);
	}

	@Test
	public void testRemoveFolio() {
		holder.removeFolio(p2);
		assertEquals(holder.getPortfolios().size(), 1);
	}

	@Test
	public void testLoadFolio() {
	}

	@Test
	public void testSaveFolio() {
	}

}
