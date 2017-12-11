/*
 * SphericCoordinate.java
 * 
 * adap-cw06
 * 
 * 17.11.2017 
 * 
 */

package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {
	
	private double latitude;
	private double longitude;
	private double radius;
	
	public static final double MAX_LATITUDE = 90;
	public static final double MIN_LATITUDE = -90;
	public static final double MAX_LONGITUDE = 180;
	public static final double MIN_LONGITUDE= -180;
	
	/*
	 * @methodtype constructor
	 */
	public SphericCoordinate() {
		latitude = 0;
		longitude = 0;
		radius = 0;
	}
	
	/*
	 * @methodtype constructor
	 */
	public SphericCoordinate ( double latitude, double longitude, double radius) {
		assertClassInvariants();
		
		this.setLatitude(latitude);
		this.setLongitude(longitude);
		this.setRadius(radius);
		
		assertClassInvariants();
	}
	
	/*
	 * @methodtype get
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/*
	 * @methodtype get
	 */
	public double getLongitude() {
		return longitude;
	}
	
	/*
	 * @methodtype get
	 */
	public double getRadius() {
		return radius;
	}
	
	/*
	 * @methodtype set
	 */
	public void setLatitude(double latitude){
		checkLatitude(latitude);
		this.latitude = latitude;
	}
	
	/*
	 * @methodtype set
	 */
	public void setLongitude(double longitude){
		checkLongitude(longitude);
		this.longitude = longitude;
	}
	
	/*
	 * @methodtype set
	 */
	public void setRadius(double radius){
		checkRadius(radius);
		this.radius = radius;
	}

	@Override
	protected CartesianCoordinate doAsCartesianCoordinate() {
		double x = this.radius * Math.sin(Math.toRadians(this.longitude)) * Math.cos(Math.toRadians(this.latitude));
		double y = this.radius * Math.sin(Math.toRadians(this.longitude)) * Math.sin(Math.toRadians(this.latitude));
		double z = this.radius * Math.cos(Math.toRadians(this.longitude));	
		return new CartesianCoordinate(x,y,z);
	}

	@Override
	protected double doGetCartesianDistance(Coordinate coordinate){
		return this.asCartesianCoordinate().getCartesianDistance(coordinate);
	}

	@Override
	protected SphericCoordinate doAsSphericCoordinate(){		
		return this;
	}

	@Override
	protected double doGetSphericDistance(Coordinate coordinate) {
		if (this.isEqual(coordinate)) {
			return 0.0;
		}
		
		SphericCoordinate sphericCoord = coordinate.asSphericCoordinate();
		
		double sum1 = this.radius * this.radius;
		double sum2 = sphericCoord.radius * sphericCoord.radius;
		double sum3 = 2 * this.radius * sphericCoord.radius * (Math.sin(Math.toRadians(this.longitude)) * 
						Math.sin(Math.toRadians(sphericCoord.longitude)) * Math.cos(Math.toRadians(this.latitude - sphericCoord.latitude)) +
						Math.cos(Math.toRadians(this.longitude)) * Math.cos(Math.toRadians(sphericCoord.longitude)));				
		
		return Math.sqrt(sum1 + sum2 + sum3);
	}

	@Override
	public double getDistance(Coordinate coordinate) throws IllegalArgumentException{
		assertNotNull(coordinate);
		return getSphericDistance(coordinate);	
	}
	
	
	private void checkLatitude(double latitude) throws IllegalArgumentException{
		if(latitude < SphericCoordinate.MIN_LATITUDE || 
				latitude > SphericCoordinate.MAX_LATITUDE) {
			throw new IllegalArgumentException("The latitude is not between -90 and 90 degrees!");
		}
	}
	
	private void checkLongitude(double longitude) throws IllegalArgumentException{
		if(longitude < SphericCoordinate.MIN_LONGITUDE || 
				longitude > SphericCoordinate.MAX_LONGITUDE) {
			throw new IllegalArgumentException("The longitude is not between -180 and 180 degrees!");
		}
	}
	
	private void checkRadius(double radius) throws IllegalArgumentException{
		if(radius < 0) {
			throw new IllegalArgumentException("The radius is not greater zero!");
		}
	}
	
	@Override
	protected void assertClassInvariants() {
		checkLatitude(this.getLatitude());
		checkLongitude(this.getLongitude());
		checkRadius(this.getRadius());
	}

	@Override
	public boolean isEqual(Coordinate coordinate) {
		if(super.isEqual(coordinate) == false) {
			return false;
		}
		
		SphericCoordinate sphericCoord = coordinate.asSphericCoordinate();
		
		if(Math.abs(this.radius - sphericCoord.getRadius())<= Coordinate.EPSILON
				&& Math.abs(this.longitude - sphericCoord.getLongitude()) <= Coordinate.EPSILON
				&& Math.abs(this.latitude - sphericCoord.getLatitude()) <= Coordinate.EPSILON){
			return true;
		}
			
		return false;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 41;
		int res = 1;
		res = prime*res + Double.hashCode(this.radius);
		res = prime*res + Double.hashCode(this.longitude);
		res = prime*res + Double.hashCode(this.latitude);
		
		return res;
	}

}
