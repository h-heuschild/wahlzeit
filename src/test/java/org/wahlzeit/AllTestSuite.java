/*
 *AllTestSuite.java
 *
 * adap-cw04
 * 
 * 05.11.2017
 * 
 * Copyright 2017
 */

package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.handlers.HandlerTestSuite;
import org.wahlzeit.model.ModelTestSuite;
import org.wahlzeit.model.persistence.PersistenceTestSuite;
import org.wahlzeit.services.ServicesTestSuite;
import org.wahlzeit.services.mailing.MailingTestSuite;
import org.wahlzeit.testEnvironmentProvider.EnvironmentProviderTestSuite;
import org.wahlzeit.utils.UtilsTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	HandlerTestSuite.class,
	ModelTestSuite.class,
	PersistenceTestSuite.class,
	ServicesTestSuite.class,
	MailingTestSuite.class,
	EnvironmentProviderTestSuite.class,
	UtilsTestSuite.class
})

public class AllTestSuite {	
	/*
	 * do nothing
	 */
}
