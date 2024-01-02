package MDMS;

import MDMS.src.MovieDatabase;
import MDMS.test.MovieTest;

public class MovieDatabaseTest extends MovieTest {
    public static void main(String[] args) {
        // Create an instance of MovieDatabase for testing
        MovieDatabase movieDatabase = new MovieDatabase();

        // Create an instance of MovieDatabaseTest for testing
        MovieDatabaseTest movieDatabaseTest = new MovieDatabaseTest();

        // Test addMovie method
        MovieTest.testAdd(movieDatabase);

        // Test removeMovie method
        MovieTest.testRemove(movieDatabase);

        // Test retrieveMovie method
        MovieTest.testRetrieve(movieDatabase);

        // Test getMoviesSortedByReleaseYear method (Ascending)
        movieDatabaseTest.testGetMoviesSortedByReleaseYear(movieDatabase, true);

        // Test getMoviesSortedByReleaseYear method (Descending)
        movieDatabaseTest.testGetMoviesSortedByReleaseYear(movieDatabase, false);

        // Test getMoviesSortedByTitle method
        movieDatabaseTest.testGetMoviesSortedByTitle(movieDatabase);

        // Additional tests specific to MovieDatabase can be added here
    }
}
