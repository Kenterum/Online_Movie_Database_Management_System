import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class MovieDatabase {
    private List<Movie> movies;
    private static final String CSV_FILE_PATH = "data/movies.csv";

    public MovieDatabase() {
        this.movies = new ArrayList<>();
        loadMoviesFromCSV(); // Load existing movies from CSV
    }

    private void loadMoviesFromCSV() {
        File csvFile = new File(CSV_FILE_PATH);
        if (csvFile.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] movieDetails = line.split(",");
                    if (movieDetails.length == 4) {
                        try {
                            String title = movieDetails[0];
                            String director = movieDetails[1];
                            int year = Integer.parseInt(movieDetails[2]);
                            int runningTime = Integer.parseInt(movieDetails[3]);
                            Movie movie = new Movie(title, director, year, runningTime);
                            movies.add(movie);
                        } catch (NumberFormatException e) {
                            System.out.println("Error parsing movie data: " + line);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading movies from CSV: " + e.getMessage());
            }
        } else {
            System.out.println("No existing movie database found. Starting new.");
        }
    }

    public void addMovie(Movie movie) {
        if (!movies.contains(movie)) {
            movies.add(movie);
            writeMovieToCSV(movie);
            System.out.println("Movie added to database: " + movie.getTitle());
        } else {
            System.out.println("Movie already exists in the database: " + movie.getTitle());
        }
    }

    private void writeMovieToCSV(Movie movie) {
        try (FileWriter writer = new FileWriter(CSV_FILE_PATH, true)) {
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
        if (movies.remove(movie)) {
            rewriteCSV();
            System.out.println("Movie removed from database: " + movie.getTitle());
        } else {
            System.out.println("Movie not found in database: " + movie.getTitle());
        }
    }

    // Rewrite the entire CSV after a movie has been removed to keep it updated.
    private void rewriteCSV() {
        try (FileWriter writer = new FileWriter(CSV_FILE_PATH, false)) {
            for (Movie movie : movies) {
                writer.append(String.format("%s,%s,%d,%d%n",
                        movie.getTitle(),
                        movie.getDirector(),
                        movie.getReleaseYear(),
                        movie.getRunningTime()));
            }
        } catch (IOException e) {
            System.out.println("Error rewriting CSV file: " + e.getMessage());
        }
    }

    public Movie retrieveMovie(String title) {
        return movies.stream()
                .filter(movie -> movie.getTitle().equals(title))
                .findFirst()
                .orElse(null);
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
}