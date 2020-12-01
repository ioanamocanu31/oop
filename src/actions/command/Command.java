package actions.command;

import fileio.ActionInputData;
import fileio.Input;
import fileio.MovieInputData;
import fileio.SerialInputData;
import fileio.UserInputData;

import static common.Constants.FAVORITE;
import static common.Constants.RATING;
import static common.Constants.VIEW;

/**
 * Class for all commands
 */
public final class Command {
    /**
     * Message to be parsed to fileWriter.writeFile
     */
    private String message;

    /**
     * Method that applies all types of commands in Main
     *
     * @param user   - the one that does the commands
     * @param action - what does the user do
     * @param input  - the database
     */
    public void command(final UserInputData user, final ActionInputData action, final Input input) {
        String title = action.getTitle();

        // Applying the View Command
        if (action.getType().equals(VIEW)) {
            View view = new View();
            view.view(user, title);
            message = view.getMessage();
        }

        // Applying the Favorite Command
        if (action.getType().equals(FAVORITE)) {
            Favorite favorite = new Favorite();
            favorite.favorite(user, title);
            message = favorite.getMessage();
        }

        // Applying the Rating Command
        if (action.getType().equals(RATING)) {
            Double grade = action.getGrade();

            // Rating movies
            for (MovieInputData movie : input.getMovies()
            ) {
                if (movie.getTitle().equals(title)) {
                    Rating rating = new Rating();
                    rating.rateMovie(user, movie, grade);
                    message = rating.getMessage();
                }
            }

            // Rating serials
            for (SerialInputData serial : input.getSerials()
            ) {
                if (serial.getTitle().equals(title)) {
                    Rating rating = new Rating();
                    rating.rateSerial(user, serial, grade, action.getSeasonNumber());
                    message = rating.getMessage();
                }
            }
        }
    }

    public String getMessage() {
        return message;
    }
}
