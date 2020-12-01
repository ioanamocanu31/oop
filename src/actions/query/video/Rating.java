package actions.query.video;

import fileio.ActionInputData;
import fileio.Input;
import fileio.MovieInputData;
import fileio.SerialInputData;

import java.util.ArrayList;

/**
 * Class for the Rating Query
 */
public final class Rating {
    private final ArrayList<String> mostRated = new ArrayList<String>();

    /**
     * Method that set the MostRated Videos with the certain filters
     *
     * @param input  - the database
     * @param action - current action
     */
    public void setMostRated(final Input input, final ActionInputData action) {
        for (MovieInputData movie : input.getMovies()
        ) {
            /* checking for the action filters */
            if ((movie.getYear().toString()).equals(action.getFilters().get(0).get(0))
                    && movie.getGenres().contains(action.getFilters().get(1).get(0))) {
                mostRated.add(movie.getTitle());
            }
        }
        for (SerialInputData serial : input.getSerials()
        ) {
            /* checking for the action filters */
            if ((serial.getYear().toString()).equals(action.getFilters().get(0).get(0))
                    && serial.getGenres().contains(action.getFilters().get(1).get(0))) {
                mostRated.add(serial.getTitle());
            }
        }
    }

    public ArrayList<String> getMostRated() {
        return mostRated;
    }
}
