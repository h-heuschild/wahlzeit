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
	
	private CartesianCoordinate firstCartesianCoordinate;
	private CartesianCoordinate secondCartesianCoordinate;
	
	private SphericCoordinate firstSphericCoordinate;
	private SphericCoordinate secondSphericCoordinate;
	
	@Before
	public void setUp() {
		firstCartesianCoordinate = new CartesianCoordinate(2.0, 2.0, 1.0);
		secondCartesianCoordinate = new CartesianCoordinate(2.0, 2.0, 2.0);
		
		firstSphericCoordinate = new SphericCoordinate(54.5, 124.5, 6.6);
		secondSphericCoordinate = new SphericCoordinate(54.5, 124.5, 4.4 );
	}
	
	@Test
	public void constructorTest() {
		assertNotNull(firstCartesianCoordinate);
		assertTrue(firstCartesianCoordinate.getX() == 2.0);
		assertTrue(firstCartesianCoordinate.getY() == 2.0);
		assertTrue(firstCartesianCoordinate.getZ() == 1.0);
		
		assertNotNull(firstSphericCoordinate);
		assertTrue(firstSphericCoordinate.getLatitude() == 54.5);
		assertTrue(firstSphericCoordinate.getLongitude() == 124.5);
		assertTrue(firstSphericCoordinate.getRadius() == 6.6);		
		
	}
	
	@Test
	public void cartesianSetterGetterTest() {
		firstCartesianCoordinate.setX(5.0);
		firstCartesianCoordinate.setY(5.0);
		firstCartesianCoordinate.setZ(5.0);
		
		assertTrue(firstCartesianCoordinate.getX() == 5.0);		
		assertTrue(firstCartesianCoordinate.getY() == 5.0);		
		assertTrue(firstCartesianCoordinate.getZ() == 5.0);		
	}
	
	@Test
	public void sphericSetterGetterTest() {
		secondSphericCoordinate.setLatitude(12.0);
		secondSphericCoordinate.setLongitude(45.5);
		secondSphericCoordinate.setRadius(180.6);
		
		assertTrue(secondSphericCoordinate.getLatitude() == 12.0);
		assertTrue(secondSphericCoordinate.getLongitude() == 45.5);
		assertTrue(secondSphericCoordinate.getRadius() == 180.6);
	}

	@Test
	public void cartesianDistanceTests() {
		assertTrue(0 == Double.compare(secondCartesianCoordinate.getDistance(secondCartesianCoordinate), 0.0));
		assertTrue(0 == Double.compare(firstCartesianCoordinate.getDistance(secondCartesianCoordinate), 1.0));
				
	}
	
	@Test
	public void sphericDistanceTest() {
		
	}
	
	@Test
	public void equalTests() {
		assertTrue(firstCartesianCoordinate.isEqual(firstCartesianCoordinate));
		assertFalse(firstCartesianCoordinate.isEqual(null));
		assertFalse(firstCartesianCoordinate.isEqual(secondCartesianCoordinate));
		
		assertTrue(firstSphericCoordinate.isEqual(firstSphericCoordinate));
		assertFalse(firstSphericCoordinate.isEqual(null));
		assertFalse(firstSphericCoordinate.isEqual(secondSphericCoordinate));		
		
		firstCartesianCoordinate = new CartesianCoordinate(0.0, 0.0, 0.0);
		secondCartesianCoordinate = new CartesianCoordinate(-0.0, -0.0, -0.0);
		assertTrue(firstCartesianCoordinate.isEqual(secondCartesianCoordinate));
	}

}
