import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieDatabase {
    private List<Movie> movies;

    public MovieDatabase() {
        this.movies = new ArrayList<>();
    }
     private static final String CSV_FILE_PATH = "movies.csv";

    public void addMovie(Movie movie) {
        try {
            if (!movies.contains(movie)) {
                movies.add(movie);
                writeMovieToCSV(movie);

                System.out.println("Movie is added to database: " + movie.getTitle());
            } else {
                System.out.println("Movie is already existing in the database: " + movie.getTitle());
            }
        } catch (Exception e) {
            System.out.println("An error occurred while adding the movie: " + e.getMessage());
        }
    }

    private void writeMovieToCSV(Movie movie) {
        try (FileWriter writer = new FileWriter("data/movies.csv", true)) {
            writer.append(String.format("%s,%s,%d,%d%n",
                    movie.getTitle(),
                    movie.getDirector(),
                    movie.getReleaseYear(),
                    movie.getRunningTime()));
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }

      public void removeMovie(Movie movie) {
       
            if (movies.contains(movie)) {
                try {
                    movies.remove(movie);
                } catch (Exception e) {
                    System.out.println(e);
                }
              
                System.out.println("Movie is removed from the database: " + movie.getTitle());
            } else {
                System.out.println("Movie is not found in the database: " + movie.getTitle());
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

   

    public List<Movie> getMoviesSortedByTitle() {
        return movies.stream()
                .sorted(Comparator.comparing(Movie::getTitle))
                .collect(Collectors.toList());
    }

    public List<Movie> getMoviesReleasedAfterYear(int year) {
        return movies.stream()
                .filter(movie -> movie.getReleaseYear() > year)
                .collect(Collectors.toList());
    }

    public int getTotalWatchTime() {
        return movies.stream()
                .mapToInt(Movie::getRunningTime)
                .sum();
    }

    public String getMovies() {
        return null;
    }
}
