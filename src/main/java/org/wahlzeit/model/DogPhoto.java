/*
 * DogPhoto.java
 * 
 * adap-cw05
 * 
 * 09.11.2017 
 * 
 */

package org.wahlzeit.model;

public class DogPhoto extends Photo {

	private static final long serialVersionUID = 1L;
	
	private Dog dog;
	
	/*
	 *  @methodtype constructor
	 */
	public DogPhoto() {
		super();
	}
	
	/*
	 *  @methodtype constructor
	 */
	public DogPhoto(PhotoId id) {
		super(id);
	}
	
	/*
	 *  @methodtype constructor
	 */
	public DogPhoto(Dog dog) {
		this();
		this.dog = dog;
	}
	
	/*
	 *  @methodtype constructor
	 */
	public DogPhoto(PhotoId id, Dog dog) {
		this(id);
		this.dog = dog;
	}
	
	/*
	 * @methodtype getter
	 */
	public Dog getDog() {
		return dog;
	}
	
	/*
	 * @methodtype setter
	 */
	public void setDog(Dog dog) {
		this.dog = dog;
	}	

}
