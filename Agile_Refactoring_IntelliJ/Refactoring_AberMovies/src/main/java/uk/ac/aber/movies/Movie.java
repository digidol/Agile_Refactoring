package uk.ac.aber.movies;

/**
 * A Movie is available for Rent or to be Purchased. This 
 * class holds that information together with the title 
 * for the movie. 
 * 
 * This class is similar to version of the example code in
 * <code>Refactoring, Improving the Design of Existing Code</code> 
 * by Martin Fowler. The main difference is that instead of movie classes, 
 * this version uses High Definition (HD) and Standard Definition (SD)
 * movie versions. 
 * 
 * @author Neil Taylor (nst@aber.ac.uk)
 *
 */
public class Movie {
    
    /** The title of the movie */
    private String title; 

    /** The version, e.g. HD for a High Definition version. */ 
    private MovieVersion version;
        
    /**
     * Initialises a new movie with the specified Title and Version.
     * 
     * @param movieTitle The title for the movie.
     * @param movieVersion The version for the movie.
     */
    public Movie(String movieTitle, MovieVersion movieVersion) { 
        this.title = movieTitle;
        this.version = movieVersion; 
    }
    
    /**
     * Sets the title for the movie. 
     * 
     * @param movieTitle The new title.
     */
    public void setTitle(String movieTitle) { 
        this.title = movieTitle; 
    }
    
    /**
     * Gets the title for the movie. 
     * 
     * @return the title.
     */
    public String getTitle() { 
        return this.title; 
    }
    
    /**
     * Sets the version for this movie. 
     * 
     * @param movieVersion The new movie version.
     */
    public void setVersion(MovieVersion movieVersion) { 
        this.version = movieVersion; 
    }
    
    /**
     * Gets the version. 
     * 
     * @return The version, which is one of HD or SD.
     */
    public MovieVersion getVersion() { 
        return this.version; 
    }
    
}
