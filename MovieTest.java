public class MovieTest {
    public static void main(String[] args) {
        Movie m1 = new Movie("Inception", "Christopher Nolan", 2010, 148);
        System.out.println(m1);

        Movie m2 = new Movie("Tutek sesi", "Rasim Ocagov", 1975, 82);
        System.out.println(m2);

        Movie m3 = new Movie("Ogey Ana", "Habib İsmailov", 1958, 81);
        System.out.println(m3);

        MovieDatabase mBase1 = new MovieDatabase();

        adding(mBase1, m1, m2, m3);

        removing(mBase1, m2);

        retrievedMovie(mBase1, "Tutek sesi");
    }

    public static void adding(MovieDatabase mBase1, Movie m1, Movie m2, Movie m3) {
        mBase1.addMovie(m1);
        mBase1.addMovie(m2);
        mBase1.addMovie(m3);

        mBase1.addMovie(m1);
    }

    public static void removing(MovieDatabase mBase1, Movie m) {
        System.out.println("Removing an existing movie:");
        mBase1.removeMovie(m);
    }

    public static void retrievedMovie(MovieDatabase mBase1, String title) {
        Movie retrievedMovie = mBase1.retrieveMovie(title);

        if (retrievedMovie != null) {
            System.out.println("\nRetrieved Movie Details:");
            System.out.println(retrievedMovie);
        } else {
            System.out.println("\nMovie not found in the database.");
        }
    }
}
