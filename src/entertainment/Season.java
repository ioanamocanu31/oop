package entertainment;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about a season of a tv show
 * <p>
 * DO NOT MODIFY
 */
public final class Season {
    /**
     * Number of current season
     */
    private final int currentSeason;
    /**
     * Duration in minutes of a season
     */
    private Integer duration;
    /**
     * List of ratings for each season
     */
    private List<Double> ratings;
    /**
     * Season rating as average of all ratings above
     */
    private Double seasonRating;

    public Season(final int currentSeason, final int duration) {
        this.currentSeason = currentSeason;
        this.duration = duration;
        this.ratings = new ArrayList<>();
    }

    /**
     * Method for calculating the seasonRating
     */
    public void calculateRating() {
        if (ratings == null) {
            seasonRating = 0.00;
            return;
        }
        Double sum = 0.00;
        for (Double rating : ratings
        ) {
            sum += rating;
        }
        seasonRating = sum / ratings.size();
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(final int duration) {
        this.duration = duration;
    }

    public List<Double> getRatings() {
        return ratings;
    }

    public void setRatings(final List<Double> ratings) {
        this.ratings = ratings;
    }

    public Double getSeasonRating() {
        return seasonRating;
    }

    @Override
    public String toString() {
        return "Episode{"
                + "currentSeason="
                + currentSeason
                + ", duration="
                + duration
                + '}';
    }

}

