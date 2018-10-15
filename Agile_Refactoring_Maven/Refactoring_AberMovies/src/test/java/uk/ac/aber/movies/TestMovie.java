package uk.ac.aber.movies;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Movie class.
 *
 * @author Neil Taylor (nst@aber.ac.uk)
 */
public class TestMovie {

    @Test
	public void shouldBeInitialisedWithCorrectTitleAndPriceCode() {
		Movie movie = new Movie("Blade Runner (The Final Cut)", 
                MovieVersion.HD);
		
		
		assertEquals("Blade Runner (The Final Cut)", movie.getTitle(), "Incorrect title");
		assertEquals(MovieVersion.HD, movie.getVersion(), "Incorrect version");
	}
	
	@Test 
	public void shouldSetAndGetTitle() { 
		Movie movie = new Movie("Blade Runner (The Final Cut)", 
		        MovieVersion.HD);
		movie.setTitle("Blade Runner 2049");
		assertEquals("Blade Runner 2049", movie.getTitle(), "Incorrect title");
	}
	
	@Test 
	public void shouldSetAndGetVersion() { 
		Movie movie = new Movie("Blade Runner (The Final Cut)", 
	            MovieVersion.HD);
		movie.setVersion(MovieVersion.SD);
		assertEquals(MovieVersion.SD, movie.getVersion(), "Incorrect movie version");
	}

}
