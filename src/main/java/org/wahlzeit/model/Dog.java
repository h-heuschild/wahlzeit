package org.wahlzeit.model;

public class Dog {
	
	/*
	 * Age of the dog.
	 */
	private int age;
	
	/*
	 * Color of the dogs fur.
	 */
	private String furColor;
	
	/*
	 * Color of the dogs eyes.
	 */
	private String eyeColor;
	
	/*
	 * The breed of a dog.
	 */
	private String dogBreed;
	
	/*
	 * The height of the dogs shoulder in cm.
	 */
	private int shoulderHeight;
	
	/*
	 * The gender of the Dog.
	 */
	private String gender;
	
	/*
	 *  @methodtype constructor
	 */
	public Dog(int age, String furColor, String eyeColor, String dogBreed, int shoulderHeight, String gender) {
		this.age = age;
		this.furColor = furColor;
		this.eyeColor = eyeColor;
		this.dogBreed = dogBreed;
		this.shoulderHeight = shoulderHeight;
		this.gender = gender;
	}

	public Dog() {
		
	}
	
	/*
	 * @methodtype getter
	 */
	public int getAge() {
		return age;
	}
	
	/*
	 * @methodtype getter
	 */
	public String getFurColor() {
		return furColor;
	}
	
	/*
	 * @methodtype getter
	 */
	public String getEyeColor() {
		return eyeColor;
	}
	
	/*
	 * @methodtype getter
	 */
	public String getDogBreed() {
		return dogBreed;
	}
	
	/*
	 * @methodtype getter
	 */
	public int getShoulderHeight() {
		return shoulderHeight;
	}
	
	/*
	 * @methodtype getter
	 */
	public String getGender() {
		return gender;
	}
}
