package uk.ac.aber.movies.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import uk.ac.aber.movies.Movie;
import uk.ac.aber.movies.MovieVersion;
import uk.ac.aber.movies.Transaction;
import uk.ac.aber.movies.TransactionType;

/**
 * Tests for the Transaction class.
 *
 * @author Neil Taylor (nst@aber.ac.uk)
 */
public class TestTransaction {

	@Test
	public void shouldBeInitialisedWithMovieAndTransactionValues() {
		
		Movie movie = new Movie("Blade Runner", 
               MovieVersion.SD); 
		
		Transaction item = new Transaction(movie, TransactionType.PURCHASE);
		
		assertSame("Incorrect movie", movie, item.getMovie());
		assertEquals("Incorrect transaction", TransactionType.PURCHASE, item.getType());
	}

}
