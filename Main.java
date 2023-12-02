public class Main {
    public static void main(String[] args) {
        Movie m1 = new Movie("Inception", "Christopher Nolan", 2010, 148);
        System.out.println(m1);

        Movie m2 = new Movie("Tutek sesi", "Rasim Ocagov", 1975, 82);
        System.out.println(m2);

        Movie m3 = new Movie("Ogey Ana", "Habib İsmailov", 1958, 81);
        System.out.println(m3);


        MovieDatabase mBase1 = new MovieDatabase();

        mBase1.addMovie(m1);
        mBase1.addMovie(m2);
        mBase1.addMovie(m3);

        Movie retrievedMovie = mBase1.retrieveMovie("Tutek sesi");

        if (retrievedMovie != null) {
            System.out.println("\nRetrieved Movie Details:");
            System.out.println(retrievedMovie);
        } else {
            System.out.println("\nMovie not found in the database.");
        }
    }
}
