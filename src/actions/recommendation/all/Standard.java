package actions.recommendation.all;

import fileio.Input;
import fileio.MovieInputData;
import fileio.SerialInputData;
import fileio.UserInputData;

public final class Standard {
    /**
     * Message to be parsed to fileWriter.writeFile
     */
    private final StringBuilder message = new StringBuilder("StandardRecommendation result: ");

    /**
     * @param user
     * @param input
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
