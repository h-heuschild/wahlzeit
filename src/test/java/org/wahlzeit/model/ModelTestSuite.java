/*
 *ModelTestSuite.java
 *
 * adap-cw04
 * 
 * 05.11.2017
 * 
 * Copyright 2017
 */

package org.wahlzeit.model;
import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	AccessRightsTest.class,
	CoordinateTest.class,
	FlagReasonTest.class,
	GenderTest.class,
	GuestTest.class,
	LocationTest.class,
	ModelTestSuite.class,
	PhotoFilterTest.class,
	TagsTest.class,
	UserStatusTest.class,
	ValueTest.class
	
})

public class ModelTestSuite {
	/*
	 * do nothing
	 */
}
