package actions.query.video;

import fileio.ActionInputData;
import fileio.Input;
import fileio.MovieInputData;
import fileio.SerialInputData;
import fileio.UserInputData;

import java.util.ArrayList;

/**
 * Class for the MostViewed Video Query
 */
public final class MostViewed {
    private final ArrayList<String> mostViewed = new ArrayList<String>();

    /**
     * Method that calculates views for the shows
     *
     * @param input - the database
     */
    public void calculateViews(final Input input) {
        for (MovieInputData movie : input.getMovies()
        ) {
            for (UserInputData user : input.getUsers()
            ) {
                if (user.getHistory().containsKey(movie.getTitle())) {
                    movie.setViews(movie.getViews() + 1);
                }
            }
        }
        for (SerialInputData serial : input.getSerials()
        ) {
            for (UserInputData user : input.getUsers()
            ) {
                if (user.getHistory().containsKey(serial.getTitle())) {
                    serial.setViews(serial.getViews() + 1);
                }
            }
        }
    }

    /**
     * Method that set the MostViewed Shows with the certain filters
     *
     * @param input  - database
     * @param action - current action
     */
    public void setMostViewed(final Input input, final ActionInputData action) {
        for (MovieInputData movie : input.getMovies()
        ) {
            /* checking for the action filters */
            if ((movie.getYear().toString()).equals(action.getFilters().get(0).get(0))
                    && movie.getGenres().contains(action.getFilters().get(1).get(0))
                    && movie.getViews() != 0) {
                mostViewed.add(movie.getTitle());
            }
        }
        for (SerialInputData serial : input.getSerials()
        ) {
            /* checking for the action filters */
            if ((serial.getYear().toString()).equals(action.getFilters().get(0).get(0))
                    && serial.getGenres().contains(action.getFilters().get(1).get(0))
                    && serial.getViews() != 0) {
                mostViewed.add(serial.getTitle());
            }
        }
    }

    public ArrayList<String> getMostViewed() {
        return mostViewed;
    }
}
