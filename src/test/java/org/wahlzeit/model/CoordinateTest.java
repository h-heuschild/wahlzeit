package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {
	
	private Coordinate coordinate;
	
	@Before
	public void setUp() {
		coordinate = new Coordinate(6.9,2.0,1.7);
	}

	@Test
	public void testDistance() {
		Coordinate testCoordinate = new Coordinate(5.0,6.0,8.0);
		double distanceCoordinate = coordinate.getDistance(testCoordinate);
		
		assertEquals(7.7, distanceCoordinate,0.1);
	}

}
