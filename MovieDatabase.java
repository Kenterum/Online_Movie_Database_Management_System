import java.util.ArrayList;
import java.util.List;

public class MovieDatabase {
    private List<Movie> movies;

    public MovieDatabase() {
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        if (movies.contains(movie) == false) {
            movies.add(movie);
            System.out.println("Movie is added to database: "+movie.getTitle());
        } else {
            System.out.println("Movie is already existing in the database: "+movie.getTitle());
        }

    }

    

    public void removeMovie(Movie movie) {
        if (movies.contains(movie)) {
            movies.remove(movie);
            System.out.println("Movie is removed from database: "+movie.getTitle());
        } else {
            System.out.println("Movie is not found in the database: "+movie.getTitle());
        }
    }

    public Movie retrieveMovie(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                return movie;
            }
        }
        return null;
    }
}