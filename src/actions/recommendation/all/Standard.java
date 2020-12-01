package actions.recommendation.all;

import fileio.Input;
import fileio.MovieInputData;
import fileio.SerialInputData;
import fileio.UserInputData;

import static common.Constants.STANDARDRESULT;

/**
 * Class for the Standard Recommendation
 */
public final class Standard {
    /**
     * Message to be parsed to fileWriter.writeFile
     */
    private final StringBuilder message = new StringBuilder(STANDARDRESULT);

    /**
     * Method that recommends to a user the first unseen show's title
     *
     * @param user  - for whom the recommendation is made
     * @param input - the database
     */
    public void getUnseen(final UserInputData user, final Input input) {
        for (MovieInputData movie : input.getMovies()
        ) {
            if (!user.getHistory().containsKey(movie.getTitle())) {
                message.append(movie.getTitle());
                return;
            }
        }
        for (SerialInputData serial : input.getSerials()
        ) {
            if (!user.getHistory().containsKey(serial.getTitle())) {
                message.append(serial.getTitle());
                return;
            }
        }
    }

    public String getMessage() {
        return message.toString();
    }
}
