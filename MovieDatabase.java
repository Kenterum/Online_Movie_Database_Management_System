import java.util.ArrayList;
import java.util.List;

public class MovieDatabase {
    private List<Movie> movies;

    public MovieDatabase() {
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        if (movies.contains(movie)==false) {
            movies.add(movie);
        }
    }

    public void removeMovie(Movie movie) {
        if (movies.contains(movie)) {
            movies.remove(movie);
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
