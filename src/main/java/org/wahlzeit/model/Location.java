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

	private CartesianCoordinate coordinate;
	
	public Location() {
		this.coordinate = new CartesianCoordinate();		
	}
	
	public Location(CartesianCoordinate coordinate){
		this.coordinate = coordinate;
	}
	
	public CartesianCoordinate getCoordinates() {
		return coordinate;
	}
	
	public void setCoordinates(CartesianCoordinate coordinate) {
		this.coordinate = coordinate;
	}
}
