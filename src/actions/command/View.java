package actions.command;

import fileio.UserInputData;

import static common.Constants.SUCCESS;

/**
 * Class for the View command
 */
public final class View {
    /**
     * Message to be parsed to fileWriter.writeFile
     */
    private final StringBuilder message = new StringBuilder();

    /**
     * Method for the View Command
     *
     * @param user  - the one that is viewing the show
     * @param title - show name
     */
    public void view(final UserInputData user, final String title) {
        if (user.getHistory().containsKey(title)) {
            int oldValue = user.getHistory().get(title);
            user.getHistory().replace(title, oldValue + 1);
        } else {
            user.getHistory().put(title, 1);
        }
        message.append(SUCCESS);
        message.append(title);
        message.append(" was viewed with total views of ");
        message.append(user.getHistory().get(title));
    }

    public String getMessage() {
        return message.toString();
    }

}
