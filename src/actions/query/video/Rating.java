package actions.query.video;

import fileio.ActionInputData;
import fileio.Input;
import fileio.MovieInputData;
import fileio.SerialInputData;

import java.util.ArrayList;

public final class Rating {
    private ArrayList<String> mostRated = new ArrayList<String>();

    /**
     * @param input
     * @param action
     */
    public void setMostRated(final Input input, final ActionInputData action) {
        for (MovieInputData movie : input.getMovies()
        ) {
            if ((movie.getYear().toString()).equals(action.getFilters().get(0).get(0))
                    && movie.getGenres().contains(action.getFilters().get(1).get(0))) {
                mostRated.add(movie.getTitle());
            }
        }
        for (SerialInputData serial : input.getSerials()
        ) {
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
