public class MovieDatabaseTest extends MovieTest {
    public static void main(String[] args) {
        // Create an instance of MovieTest for testing
        MovieTest movieTest = new MovieTest();

        // Test addMovie method
        testAdd(movieTest);

        // Test removeMovie method
        testRemove(movieTest);

        // Test retrieveMovie method
        testRetrieve(movieTest);
    }
}
