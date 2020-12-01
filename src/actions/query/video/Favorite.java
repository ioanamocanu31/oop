package actions.query.video;

import fileio.Input;
import fileio.MovieInputData;
import fileio.SerialInputData;
import fileio.UserInputData;

import java.util.HashMap;
import java.util.Map;

public final class Favorite {
    private Map<String, Integer> favoriteMovies;
    private Map<String, Integer> favoriteSerials;

    /**
     * @param input
     */
    public void calculateOccurrence(final Input input) {
        for (MovieInputData movie : input.getMovies()
        ) {
            favoriteMovies = new HashMap<String, Integer>();
            Integer occurrence = 0;
            for (UserInputData user : input.getUsers()
            ) {
                if (user.getFavoriteMovies().contains(movie.getTitle())) {
                    occurrence++;
                }
            }
            if (occurrence != 0) {
                favoriteMovies.put(movie.getTitle(), occurrence);
            }
        }
        for (SerialInputData serial : input.getSerials()
        ) {
            favoriteSerials = new HashMap<String, Integer>();
            Integer occurrence = 0;
            for (UserInputData user : input.getUsers()
            ) {
                if (user.getFavoriteMovies().contains(serial.getTitle())) {
                    occurrence++;
                }
            }
            if (occurrence != 0) {
                favoriteSerials.put(serial.getTitle(), occurrence);
            }
        }
    }

    public Map<String, Integer> getFavoriteMovies() {
        return favoriteMovies;
    }

    public Map<String, Integer> getFavoriteSerials() {
        return favoriteSerials;
    }
}
