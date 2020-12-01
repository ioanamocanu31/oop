package fileio;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about a movie, retrieved from parsing the input test files
 * <p>
 * DO NOT MODIFY
 */
public final class MovieInputData extends ShowInput {
    /**
     * Duration in minutes of a season
     */
    private final Integer duration;
    /**
     * List of ratings for the movie
     */
    private final List<Double> ratings = new ArrayList<Double>();
    /**
     * Movie Rating
     */
    private Double movieRating;


    public MovieInputData(final String title, final ArrayList<String> cast,
                          final ArrayList<String> genres, final int year,
                          final int duration) {
        super(title, year, cast, genres);
        this.duration = duration;
    }

    /**
     *
     */
    public void calculateRating() {
        Double sum = 0.00;
        for (Double rating : ratings
        ) {
            sum += rating;
        }
        movieRating = sum / ratings.size();
    }

    public List<Double> getRatings() {
        return ratings;
    }

    public Integer getDuration() {
        return duration;
    }

    public Double getMovieRating() {
        return movieRating;
    }

    @Override
    public String toString() {
        return "MovieInputData{" + "title= "
                + super.getTitle() + "year= "
                + super.getYear() + "duration= "
                + duration + "cast {"
                + super.getCast() + " }\n"
                + "genres {" + super.getGenres() + " }\n ";
    }
}
