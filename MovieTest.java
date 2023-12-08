public class MovieTest {

    public static void testAdd(MovieDatabase mBase) {
        // Manually add movies and print results
        System.out.println("Testing addMovie() method:");
        mBase.addMovie(new Movie("Inception", "Christopher Nolan", 2010, 148));
        mBase.addMovie(new Movie("Tutek sesi", "Rasim Ocagov", 1975, 82));
        mBase.addMovie(new Movie("Ogey Ana", "Habib İsmailov", 1958, 81));
        // Print some confirmation or details here
    }

    public static void testRemove(MovieDatabase mBase) {
        // Manually remove a movie and print results
        System.out.println("\nTesting removeMovie() method:");
        Movie m = new Movie(null, null, 0, 0);
        mBase.removeMovie(m);
        // Print some confirmation or details here

    }

    public static void testRetrieve(MovieTest mBase) {
        // Manually retrieve a movie and print results
        System.out.println("\nTesting retrieveMovie() method:");
        Movie retrievedMovie = mBase.retrieveMovie("Tutek sesi");
        if (retrievedMovie != null) {
            System.out.println("Retrieved Movie: " + retrievedMovie);
        } else {
            System.out.println("Movie not found.");
}
    }