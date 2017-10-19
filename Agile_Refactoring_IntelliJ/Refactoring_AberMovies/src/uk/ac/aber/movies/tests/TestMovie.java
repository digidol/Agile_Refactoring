package uk.ac.aber.movies.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import uk.ac.aber.movies.Movie;
import uk.ac.aber.movies.MovieVersion;

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
		
		
		assertEquals("Incorrect title", "Blade Runner (The Final Cut)", movie.getTitle());
		assertEquals("Incorrect version", MovieVersion.HD, movie.getVersion());
	}
	
	@Test 
	public void shouldSetAndGetTitle() { 
		Movie movie = new Movie("Blade Runner (The Final Cut)", 
		        MovieVersion.HD);
		movie.setTitle("Blade Runner 2049");
		assertEquals("Incorrect title", "Blade Runner 2049", movie.getTitle()); 
	}
	
	@Test 
	public void shouldSetAndGetVersion() { 
		Movie movie = new Movie("Blade Runner (The Final Cut)", 
	            MovieVersion.HD);
		movie.setVersion(MovieVersion.SD);
		assertEquals("Incorrect movie version", MovieVersion.SD, movie.getVersion()); 
	}

}
