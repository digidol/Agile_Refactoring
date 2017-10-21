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
    
    /**
     * Retrieves the charge for this transaction. There is a 
     * difference between prices for purchased items and rental 
     * items. Also, the movie version (HD or SD) also affects
     * the price.
     * 
     * @return The charge for the movie.
     */
    public double getCharge() { 
    	double transactionCharge = 0.0;
    	switch (getType()) {

        case PURCHASE:
            transactionCharge += 5.99;
            if (getMovie().getVersion() == MovieVersion.HD) {
                transactionCharge += 4.00;
            }
            break;

        case RENTAL:
            transactionCharge += 3.00;
            if (getMovie().getVersion() == MovieVersion.HD) {
                transactionCharge += 1.49;
            }
            break;
        }
    	return transactionCharge; 
    }
    
    /**
     * Gets the number of bonus points for this transaction.
     * 
     * @return The number of bonus points.
     */
    public int getBonusPoints() { 
    	
    	int bonusPoints = 1;
        if (getType() == TransactionType.PURCHASE && 
            getMovie().getVersion() == MovieVersion.HD) {
            bonusPoints += 1;
        }
        return bonusPoints;
    }
    
}
