/*
 * LocationTest.java
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

public class LocationTest {
	
	private Coordinate coordinate;
	private Location firstlocation;
	private Location secondlocation;

	@Before
	public void setUp() {
		coordinate = new Coordinate();
		firstlocation = new Location();
		secondlocation = new Location(coordinate);
	}
	
	@Test
	public void getterSetterTests() {
		assertTrue(coordinate.equals(secondlocation.getCoordinates()));
		
		secondlocation.setCoordinates(new Coordinate());
		assertFalse(coordinate.equals(secondlocation.getCoordinates()));
	}
	
	@Test
	public void locationHasCoordinate() {
		assertTrue(null != firstlocation.getCoordinates());
		assertTrue(null != secondlocation.getCoordinates());
	}

}
