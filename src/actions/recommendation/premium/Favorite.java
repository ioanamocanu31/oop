package actions.recommendation.premium;

import fileio.Input;
import fileio.MovieInputData;
import fileio.SerialInputData;
import fileio.UserInputData;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for the Favorite Recommendation
 */
public final class Favorite {
    private Map<String, Integer> favoriteNumber;

    /**
     * Method for calculating how many times a movie/ serial appears in the favorite users' lists
     *
     * @param input - the database
     */
    public void calculateOccurrence(final Input input) {
        favoriteNumber = new HashMap<String, Integer>();
        for (MovieInputData movie : input.getMovies()
        ) {
            int occurrence = 0;
            for (UserInputData user : input.getUsers()
            ) {
                if (user.getFavoriteMovies().contains(movie.getTitle())) {
                    occurrence++;
                }
            }
            favoriteNumber.put(movie.getTitle(), occurrence);
        }
        for (SerialInputData serial : input.getSerials()
        ) {
            int occurrence = 0;
            for (UserInputData user : input.getUsers()
            ) {
                if (user.getFavoriteMovies().contains(serial.getTitle())) {
                    occurrence++;
                }
            }
            favoriteNumber.put(serial.getTitle(), occurrence);
        }
    }

    /**
     * Method that returns show that is frequently in the favorite lists
     * and is not already seen by the user
     *
     * @param input - the database
     * @param user - for whom the recommendation is made
     * @return the most favorite show
     */
    public String getFavorite(final Input input, final UserInputData user) {
        calculateOccurrence(input);
        for (String key : favoriteNumber.keySet()) {
            if (!user.getHistory().containsKey(key)) {
                return key;
            }
        }
       return null;
    }

}
