package uk.ac.aber.movies.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * This class can be used to run all of the other tests. 
 * 
 * @author Neil Taylor
 *
 */
@RunWith(org.junit.runners.Suite.class)
@Suite.SuiteClasses({TestCustomer.class, TestMovie.class, TestTransaction.class}) 
public class TestCustomerMovieTransactions {

}
