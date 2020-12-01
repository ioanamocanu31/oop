package actions.query.video;

import fileio.ActionInputData;
import fileio.Input;
import fileio.MovieInputData;
import fileio.SerialInputData;
import fileio.UserInputData;

import java.util.ArrayList;


public final class MostViewed {
    private ArrayList<String> mostViewed = new ArrayList<String>();

    /**
     * @param input
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
     * @param input
     * @param action
     */
    public void setMostViewed(final Input input, final ActionInputData action) {
        for (MovieInputData movie : input.getMovies()
        ) {
            if ((movie.getYear().toString()).equals(action.getFilters().get(0).get(0))
                    && movie.getGenres().contains(action.getFilters().get(1).get(0))
                    && movie.getViews() != 0) {
                mostViewed.add(movie.getTitle());
            }
        }
        for (SerialInputData serial : input.getSerials()
        ) {
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
