package fileio;

import entertainment.Season;

import java.util.ArrayList;

/**
 * Information about a tv show, retrieved from parsing the input test files
 * <p>
 * DO NOT MODIFY
 */
public final class SerialInputData extends ShowInput {
    /**
     * Number of seasons
     */
    private final int numberOfSeasons;
    /**
     * Season list
     */
    private final ArrayList<Season> seasons;
    /**
     * Serial Rating
     */
    private Double serialRating;
    /**
     * Duration in minutes of a season
     */
    private Integer duration = 0;

    public SerialInputData(final String title, final ArrayList<String> cast,
                           final ArrayList<String> genres,
                           final int numberOfSeasons, final ArrayList<Season> seasons,
                           final int year) {
        super(title, year, cast, genres);
        this.numberOfSeasons = numberOfSeasons;
        this.seasons = seasons;
    }

    /**
     *
     */
    public void calculateRating() {
        Double sum = 0.00;
        for (Season season : seasons
        ) {
            sum = season.getSeasonRating();
        }
        serialRating = sum / numberOfSeasons;
    }

    /**
     *
     */
    public void calculateDuration() {
        for (Season season : seasons
        ) {
            duration += season.getDuration();
        }
    }

    public int getNumberSeason() {
        return numberOfSeasons;
    }

    public ArrayList<Season> getSeasons() {
        return seasons;
    }

    public Integer getDuration() {
        return duration;
    }

    public Double getSerialRating() {
        return serialRating;
    }

    @Override
    public String toString() {
        return "SerialInputData{" + " title= "
                + super.getTitle() + " " + " year= "
                + super.getYear() + " cast {"
                + super.getCast() + " }\n" + " genres {"
                + super.getGenres() + " }\n "
                + " numberSeason= " + numberOfSeasons
                + ", seasons=" + seasons + "\n\n" + '}';
    }
}
