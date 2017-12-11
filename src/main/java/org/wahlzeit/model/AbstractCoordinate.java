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
	public CartesianCoordinate asCartesianCoordinate() throws IllegalArgumentException{
		CartesianCoordinate coordinate = doAsCartesianCoordinate();
		assertNotNull(coordinate);
		return coordinate;
	}

	protected abstract CartesianCoordinate doAsCartesianCoordinate();
	
	@Override
	public double getCartesianDistance(Coordinate coordinate) throws IllegalArgumentException{
		assertNotNull(coordinate);
		double distance = doGetCartesianDistance(coordinate);
		assertNotNullDistance(distance);
		return distance;
	}
	
	protected abstract double doGetCartesianDistance(Coordinate coordinate);
	
	@Override
	public SphericCoordinate asSphericCoordinate() throws IllegalArgumentException{
		assertClassInvariants();
		
		SphericCoordinate coordinate = doAsSphericCoordinate();
		assertNotNull(coordinate);
		
		assertClassInvariants();
		return coordinate;
	}
	
	protected abstract SphericCoordinate doAsSphericCoordinate();
	
	@Override
	public double getSphericDistance(Coordinate coordinate) throws IllegalArgumentException{
		assertNotNull(coordinate);
		double distance = doGetSphericDistance(coordinate);
		assertNotNullDistance(distance);
		return distance;
	}
	
	protected abstract double doGetSphericDistance(Coordinate coordinate);
	
	@Override
	public double getDistance(Coordinate coordinate) throws IllegalArgumentException{
		assertNotNull(coordinate);
		return getCartesianDistance(coordinate);
		
	}
	 
	@Override
	public boolean isEqual(Coordinate coordinate) throws IllegalArgumentException{
		assertNotNull(coordinate);
		
		if(this == coordinate) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Coordinate)) {
			return false;
		}
		
		return isEqual((Coordinate)obj);
	}
	
	protected void assertNotNull(Coordinate coordinate) throws IllegalArgumentException{
		if (coordinate == null) {
			throw new IllegalArgumentException("The coordinate should not be null!");
		}
	}
	
	protected void assertNotNullDistance(double distance) throws IllegalArgumentException{
		if(distance == null) {
			throw new IllegalArgumentException("The distance should not be null!");
		}
	}
	
	protected void assertIsDoubleValid(double value) throws IllegalArgumentException{
		if (value == null || value == Double.NEGATIVE_INFITINY || value == Double.POSITIVE_INFITINY) {
			throw new IllegalArgumentException("The double value is invalid!");
		}
	}
	
	protected abstract void assertClassInvariants() throws IllegalArgumentException;
