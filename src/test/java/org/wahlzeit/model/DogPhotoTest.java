/*
 * DogPhotoTest.java
 * 
 * adap-cw05
 * 
 * 12.11.2017 
 * 
 */

package org.wahlzeit.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DogPhotoTest {

	DogPhoto dogPhoto;
	
	@Before
	public void setUp() {
		dogPhoto = new DogPhoto();
	}
	
	@Test
	public void testGetSet() {		
		assertEquals(dogPhoto.getDog(),null);
		Dog dog2 = new Dog(1, "black", "brown", "labrador", 55, "female");
		dogPhoto.setDog(dog2);
		assertEquals(dog2, dogPhoto.getDog());
	}
}
