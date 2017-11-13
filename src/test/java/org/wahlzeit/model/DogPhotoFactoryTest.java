/*
 * DogPhotoFactoryTest.java
 * 
 * adap-cw05
 * 
 * 09.11.2017 
 * 
 */

package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DogPhotoFactoryTest {
	
	DogPhotoFactory instance;
	
	@Before
	public void setUp() {
		instance = DogPhotoFactory.getInstance();
	}
	
	@Test
	public void testGetInstance() {
		assertNotEquals(instance,null);
	}
	
	@Test
	public void testCreatePhoto() {
		assertNotNull(instance.createPhoto());
	}

	@Test
	public void testCreateAnotherPhoto() {
		PhotoId id = new PhotoId(2222);
		Photo dogPic = new DogPhoto(id);
		Photo pic = instance.createPhoto(id);
		assertEquals(dogPic.getId(), pic.getId());		
	}
}
