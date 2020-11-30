package actions.command;

import fileio.MovieInputData;
import fileio.SerialInputData;
import fileio.UserInputData;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for the Rating command
 */
public final class Rating {
    /**
     * Message to be parsed to fileWriter.writeFile
     */
    private final StringBuilder message = new StringBuilder();

    /**
     * @param user
     * @param movie
     * @param rating
     */
    public void rateMovie(UserInputData user, MovieInputData movie, Double rating) {
        String title = movie.getTitle();
        if (user.getHistory().containsKey(title)) {
            if (user.getRatedShows().containsKey(title)) {
                message.append("error -> ");
                message.append(title);
                message.append(" has been already rated");
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(0);
                user.getRatedShows().put(title, list);
                movie.getRatings().add(rating);
                movie.calculateRating();
                message.append("success -> ");
                message.append(title);
                message.append(" was rated with ");
                message.append(rating.toString());
                message.append(" by ");
                message.append(user.getUsername());
            }
        } else {
            message.append("error -> ");
            message.append(title);
            message.append(" is not seen");
        }
    }

    /**
     * @param user
     * @param serial
     * @param rating
     * @param season
     */
    public void rateSerial(UserInputData user, SerialInputData serial, Double rating, int season) {
        String title = serial.getTitle();
        if (user.getHistory().containsKey(title)) {
            if (user.getRatedShows().containsKey(title)
                /*&& user.getRatedShows().get(title).contains(season)*/) {
                message.append("error -> ");
                message.append(title);
                message.append(" has been already rated");
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(season);
                user.getRatedShows().put(title, list);
                // add to season ratings
                message.append("success -> ");
                message.append(title);
                message.append(" was rated with ");
                message.append(rating.toString());
                message.append(" by ");
                message.append(user.getUsername());
            }
        } else {
            message.append("error -> ");
            message.append(title);
            message.append(" is not seen");
        }
    }

    public String getMessage() {
        return message.toString();
    }
}
