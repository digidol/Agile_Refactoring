package uk.ac.aber.movies;

/** 
 * A transaction holds information about a movie that has either
 * been rented or purchased in the online store. This includes holding 
 * information about which movie and also the transaction type.   
 * 
 * This class replaces the concept of Rental in the example code in
 * <code>Refactoring, Improving the Design of Existing Code</code> 
 * by Martin Fowler.  
 *
 * @author Neil Taylor (nst@aber.ac.uk)
 */
public class Transaction {

    /** The movie that has been rented or purchased. */ 
    private Movie movie; 
    
    /** The type of transaction: Rental or Purchase. */
    private TransactionType type; 
    
    /** 
     * Initialises the transaction with the specified details. 
     * 
     * @param movie The movie. 
     * @param type The type of the transaction. 
     */
    public Transaction(Movie movie, TransactionType type) { 
        this.movie = movie;
        this.type = type; 
    }
    
    /**
     * Retrieves the movie in this transaction. 
     * 
     * @return The movie.
     */
    public Movie getMovie() { 
        return movie; 
    }
    
    /**
     * Retrieves the type of the transaction. 
     * 
     * @return The type.
     */
    public TransactionType getType() { 
        return type; 
    }
    
}
