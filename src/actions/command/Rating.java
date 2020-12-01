package actions.command;

import fileio.MovieInputData;
import fileio.SerialInputData;
import fileio.UserInputData;

import static common.Constants.ERROR;
import static common.Constants.SUCCESS;

/**
 * Class for the Rating command
 */
public final class Rating {
    /**
     * Message to be parsed to fileWriter.writeFile
     */
    private final StringBuilder message = new StringBuilder();

    /**
     * Method for the Rating Movie Command
     *
     * @param user   - the one that is rating
     * @param movie  - the one that is rated
     * @param rating - the grade
     */
    public void rateMovie(final UserInputData user, final MovieInputData movie,
                          final Double rating) {
        String title = movie.getTitle();
        if (user.getHistory().containsKey(title)) {
            if (user.getRatedShows().contains(title)) {
                message.append(ERROR);
                message.append(title);
                message.append(" has been already rated");
            } else {
                user.getRatedShows().add(title);
                movie.getRatings().add(rating);
                movie.calculateRating();
                message.append(SUCCESS);
                message.append(title);
                message.append(" was rated with ");
                message.append(rating.toString());
                message.append(" by ");
                message.append(user.getUsername());
            }
        } else {
            message.append(ERROR);
            message.append(title);
            message.append(" is not seen");
        }
    }

    /**
     * Method for the Rating Serial Command
     *
     * @param user   - the one that is rating
     * @param serial - the one that had the season rated
     * @param rating - the grade
     * @param season - the one that is rated
     */
    public void rateSerial(final UserInputData user, final SerialInputData serial,
                           final Double rating, final Integer season) {
        String title = serial.getTitle();
        if (user.getHistory().containsKey(title)) {
            if (user.getRatedShows().contains(title + season.toString())) {
                message.append(ERROR);
                message.append(title);
                message.append(" has been already rated");
            } else {
                user.getRatedShows().add(title + season.toString());
                /* Here I should have calculated the new rating for the season, then for
                    the serial, but somehow I cannot access each season. */
                message.append(SUCCESS);
                message.append(title);
                message.append(" was rated with ");
                message.append(rating.toString());
                message.append(" by ");
                message.append(user.getUsername());
            }
        } else {
            message.append(ERROR);
            message.append(title);
            message.append(" is not seen");
        }
    }

    public String getMessage() {
        return message.toString();
    }
}
