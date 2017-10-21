package uk.ac.aber.movies;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer. The customer has a name and can have a list of 
 * transactions. Each transaction records a purchase or rental that is made
 * by the customer. 
 * 
 * The <code>getStatement</code> method provides an invoice as a string. This 
 * might be used in a text email to the customer.
 * 
 * The main code in this class is in the <code>getStatement</code> method. You 
 * will apply your refactoring steps to that code and transform the code ready 
 * for the introduction of a similar method that returns an HTML fragment rather
 * than the text version. The HTML fragment can be used in a HTML email to the 
 * customer. 
 * 
 * For the avoidance of doubt, this application code does not need to send emails. 
 * Think of this code as a fragment of a larger system that has yet to be written. 
 * 
 * This class is a reworked version of the example code in
 * <code>Refactoring, Improving the Design of Existing Code</code> by Martin
 * Fowler. For information about the book, see
 * https://martinfowler.com/books/refactoring.html.
 * 
 * @author Neil Taylor (nst@aber.ac.uk)
 *
 */
public class Customer {

    /** The given, or first, name. */
    private String givenName;

    /** The family name or surname. */
    private String familyName;

    /** List that contains the transactions for the user */
    private List<Transaction> transactions;

    /**
     * Initialises the Customer with the specified information.
     * 
     * @param givenName
     *            The given name (first name) for the customer.
     * @param familyName
     *            The family name (surname) for the customer.
     */
    public Customer(String givenName, String familyName) {
        this.givenName = givenName;
        this.familyName = familyName;

        transactions = new ArrayList<>();
    }

    /**
     * Sets the given name for the customer.
     * 
     * @param givenName
     *            The new given name.
     */
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    /**
     * Retrieves the given name for the customer.
     * 
     * @return A name if it has been set. This might be null.
     */
    public String getGivenName() {
        return givenName;
    }

    /**
     * Sets the family name for the customer.
     * 
     * @param familyName
     *            The new family name.
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /**
     * Retrieves the family name for the customer.
     * 
     * @return The family name if has been set. This might be null.
     */
    public String getFamilyName() {
        return familyName;
    }

    /** 
     * Retrieves the name, which is the given name and family name
     * separated by a single space.
     * @return The given name, a space and then the family name.
     */
    public String getName() {
        return givenName + " " + familyName;
    }

    /**
     * Adds a transaction to the list of transactions for this customer. 
     * 
     * @param transaction The transaction that lists the movie and the 
     * type of transaction (i.e. purchase or rental).
     */
    public void addMovieTransaction(Transaction transaction) {

        transactions.add(transaction);
    }

    /** 
     * This method will generate an invoice for the transactions that
     * have been added for this Customer. The invoice will include the 
     * customer name, a list of transactions and the value of that transaction. 
     * The invoice will also include the number of bonus points that are
     * earned for the transactions.  
     * 
     * An example of the format of the result is shown below. The customer, 
     * Sam Jones, has three transactions, which have a total value of 
     * 20.47 and will earn the customer 4 bonus points. 
     * 
     * <pre>
     * {@code
     * Invoice from AberMovies
     * 
     * Customer: Sam Jones
     * 
     *  	The Force Awakens 	9.99 
	 *  	Frozen 	4.49
	 *  	Skyfall	5.99
     * Amount owed: 20.47
     * You have earned 4 bonus points
     * }
     * </pre>
     * 
     * @returns The message is returned as a string. 
     */
    public String getStatement() {

        String statement = "Invoice from AberMovies\n\n";
        statement += "Customer: " + getName() + "\n\n";

        if(transactions.size() == 0) {
        	statement += "\tNo items purchased or rented\n";
        }
        else { 
            for (Transaction item : transactions) {
                statement += "\t" + item.getMovie().getTitle() + "\t" + item.getCharge() + "\n";
            }
        }

        statement += "Amount owed: " + getTotalAmount() + "\n";
        statement += "You earned " + getTotalBonusPoints() + " bonus points";

        return statement.toString();
    }
    
    /** 
     * This method will generate an invoice for the transactions that
     * have been added for this Customer. The invoice will include the 
     * customer name, a list of transactions and the value of that transaction. 
     * The invoice will also include the number of bonus points that are
     * earned for the transactions.  
     * 
     * This version was written following the refactoring of the getStatement()
     * method.
     * 
     * An example of the format of the result is shown below. The customer, 
     * Sam Jones, has three transactions, which have a total value of 
     * 20.47 and will earn the customer 4 bonus points.  Note, the following display 
     * might imply that there are \n characters in the returned code. There aren't. 
     * The display is shown over several lines to make it easier to see.
     * 
     * <pre>
     * {@code
     * <h1>Invoice from AberMovies</h1>
     * <p>Customer: Sam Jones</p>
     * <ul>
     *  	<li>The Force Awakens - 9.99</li> 
	 *  	<li>Frozen 	4.49</li>
	 *  	<li>Skyfall	5.99</li>
     * </ul>
     * <p>Amount owed: 20.47</p>
     * <p>You have earned 4 bonus points</p>
     * }
     * </pre>
     * 
     * @returns The message is returned as a string. 
     */
    public String getHtmlStatement() {

        String statement = "<h1>Invoice from AberMovies</h1>";
        statement += "<p>Customer: " + getName() + "</p>";
        
        if(transactions.size() == 0) {
        	statement += "<p>No items purchased or rented</p>";
        }
        else {
        	statement += "<ul>";
        
            for (Transaction item : transactions) {
                statement += "<li>" + item.getMovie().getTitle() + " - " + item.getCharge() + "</li>";
            }
            statement += "</ul>";
        }
        
        statement += "<p>Amount owed: " + getTotalAmount() + "</p>";
        statement += "<p>You earned " + getTotalBonusPoints() + " bonus points</p>";

        return statement.toString();
    }
    
    /**
     * Calculates the total amount for the transactions. 
     * 
     * @return The sum of the charge for all transactions.
     */
    private double getTotalAmount() { 
    	
    	double totalAmount = 0.0; 
    	for(Transaction item: transactions) { 
    		totalAmount += item.getCharge();
    	}
    	return totalAmount;
    }
    
    /**
     * Calculates the total number of bonus points for the 
     * transactions. 
     * 
     * @return The sum of the bonus points.
     */
    private int getTotalBonusPoints() { 
    	
    	int bonusPoints = 0; 
    	for(Transaction item: transactions) { 
    		bonusPoints += item.getBonusPoints();
    	}
    	return bonusPoints;
    }
    
}
