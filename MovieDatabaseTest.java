public class MovieDatabaseTest {
    public static void main(String[] args) {
        // Create an instance of MovieDatabase for testing
        MovieDatabase movieDatabase = new MovieDatabase();

        // Test addMovie method
        testAddMovie(movieDatabase);

        // Test removeMovie method
        testRemoveMovie(movieDatabase);

        // Test retrieveMovie method
        testRetrieveMovie(movieDatabase);

        // Test other methods as needed

        // Add more test cases as needed
    }

    private static void testAddMovie(MovieDatabase movieDatabase) {
        System.out.println("Testing addMovie() method:");
        movieDatabase.addMovie(new Movie("Inception", "Christopher Nolan", 2010, 148));
        movieDatabase.addMovie(new Movie("Tutek sesi", "Rasim Ocagov", 1975, 82));
        movieDatabase.addMovie(new Movie("Ogey Ana", "Habib İsmailov", 1958, 81));
        // Add assertions or print statements for verification
    }

    private static void testRemoveMovie(MovieDatabase movieDatabase) {
        System.out.println("\nTesting removeMovie() method:");
        // Manually add movies
        movieDatabase.addMovie(new Movie("Inception", "Christopher Nolan", 2010, 148));
        movieDatabase.addMovie(new Movie("Tutek sesi", "Rasim Ocagov", 1975, 82));
        movieDatabase.addMovie(new Movie("Ogey Ana", "Habib İsmailov", 1958, 81));

        // Manually remove a movie and print results
        Movie movieToRemove = new Movie("Inception", "Christopher Nolan", 2010, 148);
        movieDatabase.removeMovie(movieToRemove);
        // Add assertions or print statements for verification
    }

    private static void testRetrieveMovie(MovieDatabase movieDatabase) {
        System.out.println("\nTesting retrieveMovie() method:");
        // Manually add movies
        movieDatabase.addMovie(new Movie("Inception", "Christopher Nolan", 2010, 148));
        movieDatabase.addMovie(new Movie("Tutek sesi", "Rasim Ocagov", 1975, 82));
        movieDatabase.addMovie(new Movie("Ogey Ana", "Habib İsmailov", 1958, 81));

        // Manually retrieve a movie and print results
        Movie retrievedMovie = movieDatabase.retrieveMovie("Tutek sesi");
        if (retrievedMovie != null) {
            System.out.println("Retrieved Movie: " + retrievedMovie);
        } else {
            System.out.println("Movie not found.");
        }
        // Add assertions or print statements for verification
    }

    // Add more test methods as needed
}
