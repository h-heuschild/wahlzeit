/*
 *PersistenceTestSuite.java
 *
 * adap-cw04
 * 
 * 05.11.2017
 * 
 * Copyright 2017
 */

package org.wahlzeit.model.persistence;
import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	AbstractAdapterTest.class,
	DatastoreAdapterTest.class
})

public class PersistenceTestSuite {
	/*
	 * do nothing
	 */
}
