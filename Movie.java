import java.io.Serializable;

public class Movie implements Serializable {
    private String title;
    private String director;
    private int releaseYear;
    private int runningTime;

    public Movie(String title, String director, int releaseYear, int runningTime) {
        this.title = title;

        this.director = director;

        if (releaseYear > 0) {
            this.releaseYear = releaseYear;
        } else {
            System.out.println("Invalid release year. Release year must be greater than 0");
        }

        if (runningTime > 0) {
            this.runningTime = runningTime;
        } else {
            System.out.println("Invalid running time. Running time must be positive.");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    @Override
    public String toString() {
        return "Movie [title=" + title + ", director=" + director + ", releaseYear=" + releaseYear + ", runningTime="
                + runningTime + "]\n";
    }

}