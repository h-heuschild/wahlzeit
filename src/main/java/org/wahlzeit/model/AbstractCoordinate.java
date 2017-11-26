/*
 * AbstractCoordinate.java
 * 
 * adap-cw07
 * 
 * 24.11.2017 
 * 
 */

package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate{

	@Override
	public abstract CartesianCoordinate asCartesianCoordinate();
	
	@Override
	public abstract double getCartesianDistance(Coordinate coordinate);
	
	@Override
	public abstract SphericCoordinate asSphericCoordinate();
	
	@Override
	public abstract double getSphericDistance(Coordinate coordinate);
	
	@Override
	public double getDistance(Coordinate coordinate) {
		return 0;
		
	}
	 
	@Override
	public boolean isEqual(Coordinate coordinate) {
		if(coordinate == null) {
			return false;
		}
		if(this == coordinate) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(null == obj) {
			return false;
		}
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Coordinate)) {
			return false;
		}
		
		return isEqual((Coordinate)obj);
	}
}
