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
	public CartesianCoordinate asCartesianCoordinate() {
		CartesianCoordinate coordinate = doAsCartesianCoordinate();
		assertNotNull(coordinate);
		return coordinate;
	}

	protected abstract CartesianCoordinate doAsCartesianCoordinate();
	
	@Override
	public double getCartesianDistance(Coordinate coordinate) {
		assertNotNull(coordinate);
		double distance = doGetCartesianDistance(coordinate);
		assertNotNull(distance);
		return distance;
	}
	
	protected abstract double doGetCartesianDistance(Coordinate coordinate);
	
	@Override
	public SphericCoordinate asSphericCoordinate() {
		SphericCoordinate coordinate = doAsSphericCoordinate();
		assertNotNull(coordinate);
		return coordinate;
	}
	
	protected abstract SphericCoordinate doAsSphericCoordinate();
	
	@Override
	public double getSphericDistance(Coordinate coordinate) {
		assertNotNull(coordinate);
		double distance = doGetSphericDistance(coordinate);
		assertNotNull(distance);
		return distance;
	}
	
	protected abstract double doGetSphericDistance(Coordinate coordinate);
	
	@Override
	public double getDistance(Coordinate coordinate) {
		return 0;
		
	}
	 
	@Override
	public boolean isEqual(Coordinate coordinate) {
		assertNotNull(coordinate);
		
		if(this == coordinate) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		assertNotNull(obj);
		
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Coordinate)) {
			return false;
		}
		
		return isEqual((Coordinate)obj);
	}
	
	protected void assertNotNull(Object object) {
		if (object == null) {
			throw new IllegalArgumentException("The object should not be null!");
		}
	}
}
