/*
 * DogPhotoManagerTest.java
 * 
 * adap-cw05
 * 
 * 12.11.2017 
 * 
 */

package org.wahlzeit.model;

import static org.junit.Assert.*;
import org.junit.Test;

public class DogPhotoManagerTest {

	@Test
	public void testInstance() {
		PhotoManager man = DogPhotoManager.getInstance();
		assertNotNull(man.photoTagCollector);
	}
}
