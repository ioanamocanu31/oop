package actions.query.video;

import fileio.Input;
import fileio.MovieInputData;
import fileio.SerialInputData;
import fileio.UserInputData;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for the Favorite Video Query
 */
public final class Favorite {
    private Map<String, Integer> favoriteMovies;
    private Map<String, Integer> favoriteSerials;

    /**
     * Method for calculating how many times a movie/ serial appears in the favorite users' lists
     *
     * @param input - the database
     */
    public void calculateOccurrence(final Input input) {
        for (MovieInputData movie : input.getMovies()
        ) {
            favoriteMovies = new HashMap<String, Integer>();
            int occurrence = 0;
            for (UserInputData user : input.getUsers()
            ) {
                if (user.getFavoriteMovies().contains(movie.getTitle())) {
                    occurrence++;
                }
            }
            favoriteMovies.put(movie.getTitle(), occurrence);
        }
        for (SerialInputData serial : input.getSerials()
        ) {
            favoriteSerials = new HashMap<String, Integer>();
            int occurrence = 0;
            for (UserInputData user : input.getUsers()
            ) {
                if (user.getFavoriteMovies().contains(serial.getTitle())) {
                    occurrence++;
                }
            }
            favoriteSerials.put(serial.getTitle(), occurrence);

        }
    }

    /**
     * @return favoriteMovies
     */
    public Map<String, Integer> getFavoriteMovies() {
        return favoriteMovies;
    }

    /**
     * @return favoriteSerials
     */
    public Map<String, Integer> getFavoriteSerials() {
        return favoriteSerials;
    }
}
