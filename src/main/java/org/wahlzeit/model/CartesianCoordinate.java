/*
 * CartesianCoordinate.java
 * 
 * adap-cw06
 * 
 * 17.11.2017 
 * 
 */

package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {

	private double x;
	private double y;
	private double z;
	
	/*
	 * @methodtype constructor
	 */
	public CartesianCoordinate() {
		x = 0.0;
		y = 0.0;
		z = 0.0;		
	}
	
	/*
	 * @methodtype constructor
	 */
	public CartesianCoordinate(double x, double y, double z) throws IllegalArgumentException{
		assertClassInvariants();
		
		this.x = x;
		this.y = y;
		this.z = z;
		
		assertClassInvariants();
	}
	
	/*
	 * @methodtype get
	 */
	public double getX() {
		return x;
	}
	
	/*
	 * @methodtype get
	 */
	public double getY() {
		return y;
	}
	
	/*
	 * @methodtype get
	 */
	public double getZ() {
		return z;
	}
	
	/*
	 * @methodtype set
	 */
	public void setX(double x) throws IllegalArgumentException{
		assertIsDoubleValid(x);
		this.x = x;
	}
	
	/*
	 * @methodtype set
	 */
	public void setY(double y) throws IllegalArgumentException{
		assertIsDoubleValid(y);
		this.y = y;
	}
	
	/*
	 * @methodtype set
	 */
	public void setZ(double z) throws IllegalArgumentException{
		assertIsDoubleValid(z);
		this.z = z;
	}

	@Override
	protected CartesianCoordinate doAsCartesianCoordinate() {		
		return this;
	}

	@Override
	protected double doGetCartesianDistance(Coordinate coordinate) {
				
		CartesianCoordinate cartCoordinate = coordinate.asCartesianCoordinate();
		
		double xDistance = cartCoordinate.getX() - this.getX();
		double yDistance = cartCoordinate.getY() - this.getY();
		double zDistance = cartCoordinate.getZ() - this.getZ();
		
		double distance = Math.pow(xDistance, 2.0)+
				Math.pow(yDistance, 2.0)+
				Math.pow(zDistance, 2.0);
		
		return Math.sqrt(distance);
	}

	@Override
	protected SphericCoordinate doAsSphericCoordinate() {
		double radius = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
		double latitude = Math.toDegrees(Math.acos(this.z / radius));
		double longitude = Math.toDegrees(Math.atan2(y, x));
		return new SphericCoordinate(latitude, longitude, radius);
	}

	@Override
	protected double doGetSphericDistance(Coordinate coordinate) {
		return this.asSphericCoordinate().getSphericDistance(coordinate);
	}
	
	@Override
	protected void assertClassInvariants() {
		assertIsDoubleValid(this.getX());
		assertIsDoubleValid(this.getY());
		assertIsDoubleValid(this.getZ());
	}
	
	@Override
	public boolean isEqual(Coordinate coordinate) {
		
		if(super.isEqual(coordinate) == false) {
			return false;
		}
		
		CartesianCoordinate cartCoordinate = coordinate.asCartesianCoordinate();
		
		if(Math.abs(this.x - cartCoordinate.getX()) <= Coordinate.EPSILON 
				&& Math.abs(this.y - cartCoordinate.getY()) <= Coordinate.EPSILON 
				&& Math.abs(this.z - cartCoordinate.getZ()) <= Coordinate.EPSILON) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 41;
		int res = 1;
		res = prime*res + Double.hashCode(this.x);
		res = prime*res + Double.hashCode(this.y);
		res = prime*res + Double.hashCode(this.z);
		
		return res;
	}

}
