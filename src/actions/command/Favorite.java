package actions.command;

import fileio.UserInputData;

/**
 * Class for the Favorite command
 */
public final class Favorite {
    /**
     * Message to be parsed to fileWriter.writeFile
     */
    private final StringBuilder message = new StringBuilder();

    /**
     * @param user
     * @param title
     */
    public void favorite(final UserInputData user, final String title) {
        if (user.getFavoriteMovies().contains(title)) {
            message.append("error -> ");
            message.append(title);
            message.append(" is already in favourite list");
        } else {
            if (user.getHistory().containsKey(title)) {
                user.getFavoriteMovies().add(title);
                message.append("success -> ");
                message.append(title);
                message.append(" was added as favourite");
            } else {
                message.append("error -> ");
                message.append(title);
                message.append(" is not seen");
            }
        }
    }

    public String getMessage() {
        return message.toString();
    }
}
