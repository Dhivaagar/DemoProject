package pratice;
import java.util.function.Predicate;
import java.util.*;

class Movie {
    String movieName;
    String actorName;
    int year;
    Movie(String m, String a, int y){
        this.movieName = m;
        this.actorName = a;
        this.year = y;
    }

    public static void getMovie(List<Movie> l, Predicate<Movie> p){
        for(Movie m:l) {
            if(p.test(m))
                System.out.println(m.movieName);
        }
    }

}

public class PredicateDemo {
    public static void main(String[] args) {
        Movie m1 = new Movie("LEO", "Vijay", 2023);
        Movie m2 = new Movie("DON", "SK", 2022);
        Movie m3 = new Movie("Vikram", "Kamal", 2022);

        List<Movie> movieList = Arrays.<Movie>asList(m1, m2, m3);
        Movie.getMovie(movieList, m -> m.year==2022);

    }
}