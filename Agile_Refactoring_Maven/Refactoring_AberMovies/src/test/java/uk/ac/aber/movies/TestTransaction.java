package uk.ac.aber.movies;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
		
		assertSame(movie, item.getMovie(), "Incorrect movie");
		assertEquals(TransactionType.PURCHASE, item.getType(), "Incorrect transaction");
	}

}
