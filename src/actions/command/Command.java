package actions.command;

import fileio.ActionInputData;
import fileio.Input;
import fileio.MovieInputData;
import fileio.SerialInputData;
import fileio.UserInputData;

public final class Command {
    /**
     * Message to be parsed to fileWriter.writeFile
     */
    private String message;

    /**
     * @param user
     * @param action
     * @param input
     */
    public void command(final UserInputData user, final ActionInputData action, final Input input) {
        String title = action.getTitle();
        int id = action.getActionId();
        if (action.getType().equals("view")) {
            View view = new View();
            view.view(user, title);
            message = view.getMessage();
        }

        if (action.getType().equals("favorite")) {
            Favorite favorite = new Favorite();
            favorite.favorite(user, title);
            message = favorite.getMessage();
        }

        if (action.getType().equals("rating")) {
            Double grade = action.getGrade();
            for (MovieInputData movie : input.getMovies()
            ) {
                if (movie.getTitle().equals(title)) {
                    Rating rating = new Rating();
                    rating.rateMovie(user, movie, grade);
                    message = rating.getMessage();
                }
            }
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
