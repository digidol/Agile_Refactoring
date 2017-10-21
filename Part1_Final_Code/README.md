# Refactoring AberMovies
This code represents the intended solution at the end of the refactoring for Part 1 in the workshop. The following refactorings have been applied to the `getStatement()` method in the `Customer` class.

* `Extract Method` - see the discussion at [refactoring.com](https://refactoring.com/catalog/extractMethod.html)
* `Move Method` - see the discussion at [refactoring.com](https://refactoring.com/catalog/moveMethod.html)
* `Replace Temp with Query` - see the discussion at [refactoring.com](https://refactoring.com/catalog/replaceTempWithQuery.html)

The result of these refactorings is that the `getStatement()` method is reduced to a shorter method. The code that calculates the charge is moved from `Customer` to `Transaction`, on the basis that the code to create the charge is not dependent on any information in `Customer`.  Similarly, the code to calculate the bonus points for a transaction is also moved from `Customer` to `Transaction`.

Applying the `Replace Temp with Query` refactoring step, we see that we add two new methods in `Customer` to calculate the total charge for the customer and the total number of bonus points.

The result is that we can then add the extra `getHtmlStatement()` into the `Customer`.  We also add tests to `TestCustomer` to check that the HTML is being generated correctly.

The code in `getStatement()` and `getHtmlStatement()` is also modified to include a message when there are no transactions. Tests for these changes are also added to `TestCustomer`.

The code in this directory is not exported for any particular IDE.
