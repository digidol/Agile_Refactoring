package uk.ac.aber.movies.tests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("JUnit 4 Suite to Run JUnit 5 tests")
@SelectPackages("uk.ac.aber.movies.tests")
public class AberMoviesTestSuite {

}
