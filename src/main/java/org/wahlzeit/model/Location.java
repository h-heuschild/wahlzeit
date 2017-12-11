/*
 * Location.java
 * 
 * adap-cw02
 * 
 * 05.11.2017 
 * 
 */

package org.wahlzeit.model;

public class Location {

	private Coordinate coordinate;
	
	public Location() {
		this.coordinate = new CartesianCoordinate();		
	}
	
	public Location(Coordinate coordinate){
		assertNotNull(coordinate);
		this.coordinate = coordinate;
	}
	
	public Coordinate getCoordinates() {
		return coordinate;
	}
	
	public void setCoordinates(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	private void assertNotNull(Object object) {
		if (object == null) {
			throw new IllegalArgumentException("The object should not be null!");
		}
	}
}
