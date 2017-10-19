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

        double totalAmount = 0.0;
        int bonusPoints = 0;

        String statement = "Invoice from AberMovies\n\n";
        statement += "Customer: " + getName() + "\n\n";

        for (Transaction item : transactions) {
            double transactionCharge = 0.0;

            // determine amounts for each transaction item
            switch (item.getType()) {

            case PURCHASE:
                transactionCharge += 5.99;
                if (item.getMovie().getVersion() == MovieVersion.HD) {
                    transactionCharge += 4.00;
                }
                break;

            case RENTAL:
                transactionCharge += 3.00;
                if (item.getMovie().getVersion() == MovieVersion.HD) {
                    transactionCharge += 1.49;
                }
                break;
            }

            // add the bonus points for this transaction
            bonusPoints += 1;
            if (item.getType() == TransactionType.PURCHASE && 
                item.getMovie().getVersion() == MovieVersion.HD) {
                bonusPoints += 1;
            }

            // show the value for this transaction
            statement += "\t" + item.getMovie().getTitle() + "\t" + transactionCharge + "\n";

            totalAmount += transactionCharge;
        }

        statement += "Amount owed: " + totalAmount + "\n";
        statement += "You earned " + bonusPoints + " bonus points";

        return statement.toString();
    }
}
