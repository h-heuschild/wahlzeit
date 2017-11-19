/*
 * Coordinate.java
 * 
 * adap-cw06
 * 
 * 17.11.2017 
 * 
 */

package org.wahlzeit.model;

public interface Coordinate {
	static final double EPSILON = 0.00000001;
	
	public CartesianCoordinate asCartesianCoordinate();
	public double getCartesianDistance(Coordinate coordinate);
	public SphericCoordinate asSphericCoordinate();
	public double getSphericDistance(Coordinate coordinate);
	public double getDistance(Coordinate coordinate);
	public boolean isEqual(Coordinate coordinate);
	
}
