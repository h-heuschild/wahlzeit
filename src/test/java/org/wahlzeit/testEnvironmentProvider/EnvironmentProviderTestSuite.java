/*
 *EnvirnonmentProviderTestSuite.java
 *
 * adap-cw04
 * 
 * 05.11.2017
 * 
 * Copyright 2017
 */

package org.wahlzeit.testEnvironmentProvider;
import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	LocalDatastoreServiceTestConfigProvider.class,
	RegisteredOfyEnvironmentProvider.class,
	SysConfigProvider.class,
	UserServiceProvider.class,
	UserSessionProvider.class,
	WebFormHandlerProvider.class
})

public class EnvironmentProviderTestSuite {
	/*
	 * do nothing
	 */
}
