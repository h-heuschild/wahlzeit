/*
 * DogPhotoFactory.java
 * 
 * adap-cw05
 * 
 * 09.11.2017 
 * 
 */

package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

public class DogPhotoFactory extends PhotoFactory{
	
	private static final Logger log = Logger.getLogger(DogPhotoFactory.class.getName());

	/**
	* Hidden singleton instance; needs to be initialized from the outside.
	*/
	private static DogPhotoFactory instance = null;
	
	/*
	 * @methodtype constructor
	 */
	protected DogPhotoFactory(){
		super();
	}
	
	public static void initialize() {
		getInstance();
	}
	
	/**
	 * Public singleton access method.
	 */
	public static synchronized DogPhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic DogPhotoFactory").toString());
			setInstance(new DogPhotoFactory());
		}

		return instance;
	}

	/**
	 * Method to set the singleton instance of PhotoFactory.
	 */
	protected static synchronized void setInstance(DogPhotoFactory dogPhotoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize DogPhotoFactory twice");
		}

		instance = dogPhotoFactory;
	}

	/**
	 * @methodtype factory
	 */
	public DogPhoto createDogPhoto() {
		return new DogPhoto();
	}

	/**
	 * Creates a new photo with the specified id
	 */
	public Photo createPhoto(PhotoId id) {
		return new DogPhoto(id);
	}
}
