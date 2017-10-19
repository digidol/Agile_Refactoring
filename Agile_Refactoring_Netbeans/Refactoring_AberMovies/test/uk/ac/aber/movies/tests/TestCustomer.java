package uk.ac.aber.movies.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uk.ac.aber.movies.Customer;
import uk.ac.aber.movies.Movie;
import uk.ac.aber.movies.MovieVersion;
import uk.ac.aber.movies.Transaction;
import uk.ac.aber.movies.TransactionType;

public class TestCustomer {

	/** Customer that is setup each time in Before action */
	private Customer customer; 
	
	/** HD version of a movie used in some of the tests */
	private Movie wonderWomanMovieHD = new Movie("Wonder Woman", MovieVersion.HD); 
	
	/** SD version of a movie used in some of the tests */ 
	private Movie bladeRunnerMovieSD = new Movie("Blade Runner", MovieVersion.SD); 
	
	/** HD version of a movie used in some of the tests */ 
	private Movie alienMovieHD = new Movie("Alien: Covenant", MovieVersion.HD); 
	
	
	@Before 
	public void setup() { 
		// Reset the customer details before each of the tests cases run
		customer = new Customer("Sam", "Jones"); 
	}
	
	@Test 
	public void shouldBeInitialisedWithSpecifiedName() { 
		assertEquals("Incorrect Name", "Sam Jones", customer.getName()); 
	}
		
	@Test
	public void shouldGenerateStatementForSDPurchase() { 
		
		Transaction item = new Transaction(bladeRunnerMovieSD, TransactionType.PURCHASE);
		customer.addMovieTransaction(item); 
		
		String statement = "Invoice from AberMovies\n\nCustomer: Sam Jones\n\n\tBlade Runner\t5.99\n" + 
		  "Amount owed: 5.99\nYou earned 1 bonus points";
		assertEquals("Incorrect statement", statement, customer.getStatement()); 
	}
	
	@Test
	public void shouldGenerateStatementForHDPurchase() { 
		
		Transaction item = new Transaction(wonderWomanMovieHD, TransactionType.PURCHASE);
		customer.addMovieTransaction(item); 
		
		String statement = "Invoice from AberMovies\n\nCustomer: Sam Jones\n\n\tWonder Woman\t9.99\n" + 
		  "Amount owed: 9.99\nYou earned 2 bonus points";
		assertEquals("Incorrect statement", statement, customer.getStatement()); 
	}
	
	@Test
	public void shouldGenerateStatementForSDRental() { 
		
		Transaction item = new Transaction(bladeRunnerMovieSD, TransactionType.RENTAL);
		customer.addMovieTransaction(item); 
		
		String statement = "Invoice from AberMovies\n\nCustomer: Sam Jones\n\n\tBlade Runner\t3.0\n" + 
		  "Amount owed: 3.0\nYou earned 1 bonus points";
		assertEquals("Incorrect statement", statement, customer.getStatement()); 
	}
	
	@Test
	public void shouldGenerateStatementForHDRental() { 
		
		Transaction item = new Transaction(wonderWomanMovieHD, TransactionType.RENTAL);
		customer.addMovieTransaction(item); 
		
		String statement = "Invoice from AberMovies\n\nCustomer: Sam Jones\n\n\tWonder Woman\t4.49\n" + 
		  "Amount owed: 4.49\nYou earned 1 bonus points";
		assertEquals("Incorrect statement", statement, customer.getStatement()); 
	}
	
	@Test
	public void shouldGenerateStatementForMultipleItems() { 
		
		Transaction item1 = new Transaction(wonderWomanMovieHD, TransactionType.PURCHASE);
		customer.addMovieTransaction(item1); 
		
		Transaction item2 = new Transaction(alienMovieHD, TransactionType.RENTAL);
		customer.addMovieTransaction(item2); 
		
		Transaction item3 = new Transaction(bladeRunnerMovieSD, TransactionType.PURCHASE);
		customer.addMovieTransaction(item3); 
		
		
		String statement = "Invoice from AberMovies\n\nCustomer: Sam Jones\n\n" + 
		  "\tWonder Woman\t9.99\n" + 
		  "\tAlien: Covenant\t4.49\n" +
		  "\tBlade Runner\t5.99\n" + 
		  "Amount owed: 20.47\nYou earned 4 bonus points";
		assertEquals("Incorrect statement", statement, customer.getStatement()); 
	}
	
}
