import java.util.ArrayList;
import java.util.List;

public class MovieDatabase {
    private List<Movie> movies;

    public MovieDatabase() {
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        try {
            if (!movies.contains(movie)) {
                movies.add(movie);
                System.out.println("Movie is added to database: " + movie.getTitle());
            } else {
                System.out.println("Movie is already existing in the database: " + movie.getTitle());
            }
        } catch (Exception e) {
            System.out.println("An error occurred while adding the movie: " + e.getMessage());
        }
    }

    public void removeMovie(Movie movie) {
        try {
            if (movies.contains(movie)) {
                movies.remove(movie);
                System.out.println("Movie is removed from the database: " + movie.getTitle());
            } else {
                System.out.println("Movie is not found in the database: " + movie.getTitle());
            }
        } catch (Exception e) {
            System.out.println("An error occurred while removing the movie: " + e.getMessage());
        }
    }

    public Movie retrieveMovie(String title) {
        try {
            for (Movie movie : movies) {
                if (movie.getTitle().equals(title)) {
                    return movie;
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred while retrieving the movie: " + e.getMessage());
        }
        return null;
    }
}
