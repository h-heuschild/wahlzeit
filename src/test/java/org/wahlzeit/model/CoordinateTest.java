/*
 * CoordinateTest.java
 * 
 * adap-cw04
 * 
 * 05.11.2017 
 * 
 */

package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {
	
	private Coordinate firstcoord;
	private Coordinate secondcoord;
	
	@Before
	public void setUp() {
		firstcoord = new Coordinate(2.0, 2.0, 1.0);
		secondcoord = new Coordinate(2.0, 2.0, 2.0);
	}
	
	@Test
	public void setterGetterTest() {
		firstcoord.setX(5.0);
		assertTrue(0 == Double.compare(firstcoord.getX(), 5.0));
		firstcoord.setY(5.0);
		assertTrue(0 == Double.compare(firstcoord.getY(), 5.0));
		firstcoord.setZ(5.0);
		assertTrue(0 == Double.compare(firstcoord.getZ(), 5.0));		
	}

	@Test
	public void distanceTests() {
		assertTrue(0 == Double.compare(secondcoord.getDistance(secondcoord), 0.0));
		assertTrue(0 == Double.compare(firstcoord.getDistance(secondcoord), 1.0));
				
	}
	
	@Test
	public void equalTests() {
		assertTrue(firstcoord.isEqual(secondcoord));
		assertFalse(firstcoord.isEqual(null));
		assertFalse(firstcoord.isEqual(secondcoord));
		
		firstcoord = new Coordinate(0.0, 0.0, 0.0);
		secondcoord = new Coordinate(-0.0, -0.0, -0.0);
		assertTrue(firstcoord.isEqual(secondcoord));
	}

}
