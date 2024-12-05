public class TestFromJunit {
    public static void main(String[] args) {
        Cinema cinema = new ConcreteCinema();

        cinema.addMovieHall(10);
        cinema.addMovieHall(15);
        cinema.addMovieHall(4);

        cinema.addMovie("Da Vinci Code", 120, 1, 50.4, 0, new Time(1, 15));
        cinema.addMovie("She diao ying xiong zhuan", 125, 1, 60, 0, new Time(6, 25));
        cinema.addMovie("Hong jian", 125, 3, 58.5, 1, new Time(16, 15));
        cinema.addMovie("Nian shou da zuo zhan", 120, 1, 35.5, 1, new Time(3, 40));
        cinema.addMovie("Bu xiu", 180, 1, 60.5, 1, new Time(3, 35));
        cinema.addMovie("Da mo zu shi", 100, 1, 45, 1, new Time(5, 39));
        cinema.addMovie("Ling de jiao dian", 100, 1, 45, 1, new Time(5, 49));
        cinema.getAllMovies().forEach(System.out::println);
    }
}
