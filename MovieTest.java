import java.util.List;

public class MovieTest extends MovieDatabase {

    public static void testAdd(MovieDatabase mBase) {
        // Manually add movies and print results
        System.out.println("Testing addMovie() method:");
        mBase.addMovie(new Movie("Inception", "Christopher Nolan", 2010, 148));
        mBase.addMovie(new Movie("Tutek sesi", "Rasim Ocagov", 1975, 82));
        mBase.addMovie(new Movie("Ogey Ana", "Habib Ismailov", 1958, 81));
        // Print some confirmation or details here
    }

    public static void testRemove(MovieDatabase mBase) {
        // Manually adding movies
        mBase.addMovie(new Movie("Inception", "Christopher Nolan", 2010, 148));
        mBase.addMovie(new Movie("Tutek sesi", "Rasim Ocagov", 1975, 82));
        mBase.addMovie(new Movie("Ogey Ana", "Habib Ismailov", 1958, 81));
        // Manually remove a movie and print results
        System.out.println("\nTesting removeMovie() method:");

        Movie m = new Movie(null, null, 0, 0);
        mBase.removeMovie(m);
        // Print some confirmation or details here

    }

    public static void testRetrieve(MovieDatabase mBase) {
        // Manually adding movies
        mBase.addMovie(new Movie("Inception", "Christopher Nolan", 2010, 148));
        mBase.addMovie(new Movie("Tutek sesi", "Rasim Ocagov", 1975, 82));
        mBase.addMovie(new Movie("Ogey Ana", "Habib Ismailov", 1958, 81));
        // Manually retrieve a movie and print results
        System.out.println("\nTesting retrieveMovie() method:");
        Movie retrievedMovie = mBase.retrieveMovie("Tutek sesi");
        if (retrievedMovie != null) {
            System.out.println("Retrieved Movie: " + retrievedMovie);
        } else {
            System.out.println("Movie not found.");
        }
    }

     public void testGetMoviesSortedByReleaseYear(MovieDatabase movieDatabase, boolean ascending) {
        // Test getMoviesSortedByReleaseYear method
        List<Movie> sortedMovies = movieDatabase.getMoviesSortedByReleaseYear(ascending);

        // Print sorted movies
        System.out.println("Sorted Movies by Release Year (" + (ascending ? "Ascending" : "Descending") + "):");
        sortedMovies.forEach(movie -> System.out.println(movie.getTitle() + " - " + movie.getReleaseYear()));
    }

    public void testGetMoviesSortedByTitle(MovieDatabase movieDatabase) {
        // Test getMoviesSortedByTitle method
        List<Movie> sortedMovies = movieDatabase.getMoviesSortedByTitle();

        // Print sorted movies
        System.out.println("Sorted Movies by Title:");
        sortedMovies.forEach(movie -> System.out.println(movie.getTitle()));
    }
}