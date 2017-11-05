/*
 * Coordinate.java
 * 
 * adap-cw04
 * 
 * 05.11.2017 
 * 
 */

package org.wahlzeit.model;

public class Coordinate {

	private double x;
	private double y;
	private double z;
	
	public Coordinate() {
		x = 0;
		y = 0;
		z = 0;		
	}
	
	public Coordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setZ(double z) {
		this.z = z;
	}
	
	public double getDistance(Coordinate dist) {
		double xDistance = dist.getX() - this.getX();
		double yDistance = dist.getY() - this.getY();
		double zDistance = dist.getZ() - this.getZ();
		
		double distance = Math.pow(xDistance, 2.0)+
				Math.pow(yDistance, 2.0)+
				Math.pow(zDistance, 2.0);
		
		return Math.sqrt(distance);
	}
	
	public boolean isEqual(Coordinate second) {
		
		if(second == null) {
			return false;
		}
		if(this == second) {
			return true;
		}
		if(this.getX() == second.getX() && this.getY() == second.getY() && this.getZ() == second.getZ()) {
			return true;
		}
		
		return false;
	}
	
	public boolean equals(Object object) {
		if(object == null) {
			return false;
		}
		
		if(!(object instanceof Coordinate)) {
			return false;
		}
		
		return isEqual((Coordinate)object);
	}
}
