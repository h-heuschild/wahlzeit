/*
 * DogTest.java
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

public class DogTest {
	
	Dog dog;
	int age;
	String furColor;
	String eyeColor;
	String dogBreed;
	int height;
	String gender;
	
	@Before
	public void setUp() {
		age = 1;
		furColor = "black";
		eyeColor = "brown";
		dogBreed = "labrador";
		height = 55;
		gender = "female";
		dog = new Dog(age, furColor, eyeColor, dogBreed, height, gender);
	}

	@Test
	public void testConstructor() {
		assertNotNull(dog);
	}
	
	@Test 
	public void testGetter(){
		assertEquals(dog.getAge(),age);
		assertEquals(dog.getFurColor(),furColor);
		assertEquals(dog.getEyeColor(),eyeColor);
		assertEquals(dog.getDogBreed(),dogBreed);
		assertEquals(dog.getShoulderHeight(),height);
		assertEquals(dog.getGender(),gender);		
	}
}
