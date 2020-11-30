package actions.command;

import fileio.UserInputData;

/**
 * Class for the View command
 */
public final class View {
    /**
     * Message to be parsed to fileWriter.writeFile
     */
    private final StringBuilder message = new StringBuilder();

    /**
     * @param user
     * @param title
     */
    public void view(UserInputData user, String title) {
        if (user.getHistory().containsKey(title)) {
            int oldValue = user.getHistory().get(title);
            user.getHistory().replace(title, oldValue + 1);
        } else {
            user.getHistory().put(title, 1);
        }
        message.append("success -> ");
        message.append(title);
        message.append(" was viewed with total views of ");
        message.append(user.getHistory().get(title));
    }

    public String getMessage() {
        return message.toString();
    }

}
