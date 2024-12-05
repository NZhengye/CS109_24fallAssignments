import java.util.List;

public class MovieHall {
    private static int count = 0;
    private int id;
    private int capacity;
    private List<Movie> screenedMovies;

    public MovieHall(int capacity) {
        this.capacity = capacity;
        this.id = ++count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Movie> getScreenedMovies() {
        return screenedMovies;
    }

    public void setScreenedMovies(List<Movie> screenedMovies) {
        this.screenedMovies = screenedMovies;
        sortMoviesByStartTime();
    }

    public List<Movie> sortMoviesByStartTime() {
        if (this.screenedMovies != null) {
            this.screenedMovies.sort((m1, m2) -> m1.getStartTime().compareTo(m2.getStartTime()));
        }
        return this.screenedMovies;
    }
}
