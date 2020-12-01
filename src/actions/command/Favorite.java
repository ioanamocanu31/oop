package actions.command;

import fileio.UserInputData;

import static common.Constants.ERROR;
import static common.Constants.SUCCESS;

/**
 * Class for the Favorite command
 */
public final class Favorite {
    /**
     * Message to be parsed to fileWriter.writeFile
     */
    private final StringBuilder message = new StringBuilder();

    /**
     * Method for the Favorite Command
     *
     * @param user  - the one that is setting the favorite
     * @param title - favorite show name
     */
    public void favorite(final UserInputData user, final String title) {
        if (user.getFavoriteMovies().contains(title)) {
            message.append(ERROR);
            message.append(title);
            message.append(" is already in favourite list");
        } else {
            if (user.getHistory().containsKey(title)) {
                user.getFavoriteMovies().add(title);
                message.append(SUCCESS);
                message.append(title);
                message.append(" was added as favourite");
            } else {
                message.append(ERROR);
                message.append(title);
                message.append(" is not seen");
            }
        }
    }

    public String getMessage() {
        return message.toString();
    }
}
