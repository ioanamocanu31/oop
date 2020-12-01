package actions.recommendation.premium;

import fileio.Input;
import fileio.MovieInputData;
import fileio.SerialInputData;
import fileio.UserInputData;

import java.util.HashMap;
import java.util.Map;

public final class Favorite {
    private Map<String, Integer> favoriteNumber;

    /**
     * @param input
     */
    public void calculateOccurrence(final Input input) {
        favoriteNumber = new HashMap<String, Integer>();
        for (MovieInputData movie : input.getMovies()
        ) {
            Integer occurrence = 0;
            for (UserInputData user : input.getUsers()
            ) {
                if (user.getFavoriteMovies().contains(movie.getTitle())) {
                    occurrence++;
                }
            }
            if (occurrence != 0) {
                favoriteNumber.put(movie.getTitle(), occurrence);
            }
        }
        for (SerialInputData serial : input.getSerials()
        ) {
            Integer occurrence = 0;
            for (UserInputData user : input.getUsers()
            ) {
                if (user.getFavoriteMovies().contains(serial.getTitle())) {
                    occurrence++;
                }
            }
            if (occurrence != 0) {
                favoriteNumber.put(serial.getTitle(), occurrence);
            }
        }
    }

    /**
     * @param input
     * @param user
     * @return
     */
    public String getFavorite(final Input input, final UserInputData user) {
        calculateOccurrence(input);
        for (String key : favoriteNumber.keySet()) {
            if (!user.getFavoriteMovies().contains(key)) {
                return key;
            }
        }
        return null;
    }

}
