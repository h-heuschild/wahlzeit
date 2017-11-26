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
		this.setLatitude(latitude);
		this.setLongitude(longitude);
		this.setRadius(radius);
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
	public void setLatitude(double latitude) {
		checkLatitude(latitude);
		this.latitude = latitude;
	}
	
	/*
	 * @methodtype set
	 */
	public void setLongitude(double longitude) {
		checkLongitude(longitude);
		this.longitude = longitude;
	}
	
	/*
	 * @methodtype set
	 */
	public void setRadius(double radius) {
		checkRadius(radius);
		this.radius = radius;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		double x = this.radius * Math.sin(Math.toRadians(this.longitude)) * Math.cos(Math.toRadians(this.latitude));
		double y = this.radius * Math.sin(Math.toRadians(this.longitude)) * Math.sin(Math.toRadians(this.latitude));
		double z = this.radius * Math.cos(Math.toRadians(this.longitude));	
		return new CartesianCoordinate(x,y,z);
	}

	@Override
	public double getCartesianDistance(Coordinate coordinate) {
		return this.asCartesianCoordinate().getDistance(coordinate);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {		
		return this;
	}

	@Override
	public double getSphericDistance(Coordinate coordinate) {
		return this.getDistance(coordinate);
	}

	@Override
	public double getDistance(Coordinate coordinate) {
		if (null == coordinate) {
			throw new IllegalArgumentException("passed target parameter must not be null");
		}
		
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
	
	private void checkLatitude(double latitude) {
		if(latitude < SphericCoordinate.MIN_LATITUDE || 
				latitude > SphericCoordinate.MAX_LATITUDE) {
			throw new IllegalArgumentException("The latitude is not between -90 and 90 degrees!");
		}
	}
	
	private void checkLongitude(double longitude) {
		if(longitude < SphericCoordinate.MIN_LONGITUDE || 
				longitude > SphericCoordinate.MAX_LONGITUDE) {
			throw new IllegalArgumentException("The longitude is not between -180 and 180 degrees!");
		}
	}
	
	private void checkRadius(double radius) {
		if(radius < 0) {
			throw new IllegalArgumentException("The radius is not greater zero!");
		}
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
