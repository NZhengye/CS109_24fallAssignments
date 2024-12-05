import java.util.ArrayList;
import java.util.List;

public class ConcreteCinema implements Cinema{
    private List<Movie> movies;
    private List<MovieHall> moviehalls;

    public ConcreteCinema() {
        this.movies = new ArrayList<>();
        this.moviehalls = new ArrayList<>();
    }

    @Override
    public void addMovieHall(int capacity) {
        MovieHall newHall = new MovieHall(capacity);
        moviehalls.add(newHall);
    }

    @Override
    public List<String> getAllMovieHallsCapacity() {
        List<String> allMovieHallsCapacity = new ArrayList<>();
        for (MovieHall hall : moviehalls) {
            String hallInfo = hall.getId() + "-" + hall.getCapacity();
            allMovieHallsCapacity.add(hallInfo);
        }
        return allMovieHallsCapacity;
    }

    @Override
    public void addMovie(String name, int runtime, int hallNumber, double price, int type, Time startTime) {
        //0 for OrdinaryMovie, 1 for ThreeDMovie
        //Movie newMovie = new Movie(type, name, startTime, hallNumber, runtime, price);
        List<Movie> screenedMoviesForGivenHall = moviehalls.get(hallNumber - 1).getScreenedMovies();
        if (screenedMoviesForGivenHall == null){
            screenedMoviesForGivenHall = new ArrayList<>();
            Movie newMovie;
            if (type == 0){
                newMovie = new OrdinaryMovie(type, name, startTime, hallNumber, runtime, price);
            } else{
                newMovie = new ThreeDMovie(type, name, startTime, hallNumber, runtime, price);
            }
            newMovie.setTicketsLeft(moviehalls.get(hallNumber - 1).getCapacity());
            screenedMoviesForGivenHall.add(newMovie);
            moviehalls.get(hallNumber - 1).setScreenedMovies(screenedMoviesForGivenHall);
            movies.add(newMovie);
            return;
        }
        else{
            int index = 0;
            for (Movie movie : screenedMoviesForGivenHall){
                if (movie.getStartTime().compareTo(startTime) > 0){
                    break;
                }
                index++;
            }
            if(index == 0){
                if (startTime.timeInMinutes() + runtime + 20 <= screenedMoviesForGivenHall.get(index).getStartTimeInMinutes()){
                    Movie newMovie;
                    if (type == 0) {
                        newMovie = new OrdinaryMovie(type, name, startTime, hallNumber, runtime, price);
                    } else {
                        newMovie = new ThreeDMovie(type, name, startTime, hallNumber, runtime, price);
                    }
                    newMovie.setTicketsLeft(moviehalls.get(hallNumber - 1).getCapacity());
                    screenedMoviesForGivenHall.add(newMovie);
                    moviehalls.get(hallNumber - 1).setScreenedMovies(screenedMoviesForGivenHall);
                    movies.add(newMovie);
                }
                return;
            }else if (index == screenedMoviesForGivenHall.size()){
                if (screenedMoviesForGivenHall.get(index - 1).getEndTimeInMinutes() + 20 <= startTime.timeInMinutes()) {
                    Movie newMovie;
                    if (type == 0) {
                        newMovie = new OrdinaryMovie(type, name, startTime, hallNumber, runtime, price);
                    } else {
                        newMovie = new ThreeDMovie(type, name, startTime, hallNumber, runtime, price);
                    }
                    newMovie.setTicketsLeft(moviehalls.get(hallNumber - 1).getCapacity());
                    screenedMoviesForGivenHall.add(newMovie);
                    moviehalls.get(hallNumber - 1).setScreenedMovies(screenedMoviesForGivenHall);
                    movies.add(newMovie);
                    return;
                }
                return;
            } else if ((screenedMoviesForGivenHall.get(index - 1).getEndTimeInMinutes() + 20 <= startTime.timeInMinutes()) &&
                    (screenedMoviesForGivenHall.get(index).getStartTimeInMinutes() >= startTime.timeInMinutes() + runtime + 20)){
                Movie newMovie;
                if (type == 0) {
                    newMovie = new OrdinaryMovie(type, name, startTime, hallNumber, runtime, price);
                } else {
                    newMovie = new ThreeDMovie(type, name, startTime, hallNumber, runtime, price);
                }
                newMovie.setTicketsLeft(moviehalls.get(hallNumber - 1).getCapacity());
                screenedMoviesForGivenHall.add(newMovie);
                moviehalls.get(hallNumber - 1).setScreenedMovies(screenedMoviesForGivenHall);
                movies.add(newMovie);
                return;
            }else return;

        }

    }

    @Override
    public List<Movie> getAllMovies() {
        return this.movies;
    }

    @Override
    public List<Movie> getMoviesFromMovieHallOrderByStartTime(int hallNumber) {
        return this.moviehalls.get(hallNumber - 1).getScreenedMovies();
    }

    @Override
    public double reserveMovie(int movieId, int arg) {
        return this.movies.get(movieId - 1).purchase(arg);
    }

    @Override
    public Movie getMovieById(int movieId) {
        return this.movies.get(movieId - 1);
    }

    @Override
    public double getOneMovieIncome(int movieId) {
        //0 for OrdinaryMovie, 1 for ThreeDMovie
        switch (this.movies.get(movieId - 1).getType()) {
            case 0:
                return this.movies.get(movieId - 1).getPrice() *
                        ((OrdinaryMovie) this.movies.get(movieId - 1)).getTicket();
            case 1:
                return this.movies.get(movieId - 1).getPrice() *
                        (((ThreeDMovie) this.movies.get(movieId - 1)).getTicketWithoutGlass()) +
                        (this.movies.get(movieId - 1).getPrice() + ((ThreeDMovie) this.movies.get(movieId - 1)).getGLASS_PRICE()) *
                                (((ThreeDMovie) this.movies.get(movieId - 1)).getTicketWithGlass());
            default:
                return 0;
        }
    }

    @Override
    public double getTotalIncome() {
        double totalIncome = 0.;
        for (Movie movie : movies) {
            totalIncome += getOneMovieIncome(movie.getId());
        }
        return totalIncome;
    }

    @Override
    public List<Movie> getAvailableMoviesByName(Time currentTime, String name) {
        List<Movie> availableMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getName().equals(name) && movie.getStartTime().compareTo(currentTime) > 0 && movie.getTicketsLeft() > 0) {
                availableMovies.add(movie);
            }
        }
        availableMovies.sort((m1, m2) -> m1.getStartTime().compareTo(m2.getStartTime()));
        return availableMovies;
    }
}
