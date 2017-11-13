/*
 * DogPhotoManager.java
 * 
 * adap-cw05
 * 
 * 09.11.2017 
 * 
 */

package org.wahlzeit.model;

public class DogPhotoManager extends PhotoManager {

	protected static DogPhotoManager instance = new DogPhotoManager();
	
	/*
	 * @methodtype constructor
	 */
	public DogPhotoManager() {
		photoTagCollector = DogPhotoFactory.getInstance().createPhotoTagCollector();
	}
	
	public static DogPhotoManager getInstance() {
		return instance;
	}
}
