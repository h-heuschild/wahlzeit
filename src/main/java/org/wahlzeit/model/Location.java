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
		this.coordinate = new Coordinate();		
	}
	
	public Location(Coordinate coordinate){
		this.coordinate = coordinate;
	}
	
	public Coordinate getCoordinates() {
		return coordinate;
	}
	
	public void setCoordinates(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
}
