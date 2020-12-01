package actions.recommendation.premium;

import fileio.Input;
import fileio.MovieInputData;
import fileio.SerialInputData;
import fileio.ShowInput;
import fileio.UserInputData;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class for the Search Recommendation
 */
public final class Search {
    private final ArrayList<String> videos = new ArrayList<String>();

    /**
     * Method that is searching all unseen shows that have the specific genre passed as filter
     *
     * @param user - for whom the recommendation is made
     * @param show - movie/serial
     * @param genre - filter
     */
    public void searchShow(final UserInputData user, final ShowInput show, final String genre) {
        String title = show.getTitle();
        if (!user.getHistory().containsKey(title)
                && show.getGenres().contains(genre)) {
            videos.add(title);
        }
    }

    /**
     * Method that applies searchShow for each type of show
     *
     * @param user - for whom the recommendation is made
     * @param input - the database
     * @param genre - filter
     */
    public void search(final UserInputData user, final Input input, final String genre) {
        for (MovieInputData movie : input.getMovies()
        ) {
            searchShow(user, movie, genre);
        }
        for (SerialInputData serial : input.getSerials()
        ) {
            searchShow(user, serial, genre);
        }
    }

    /**
     * Method that sorts the videos already found
     */
    public void sort() {
        Collections.sort(videos);
    }

    public ArrayList<String> getVideos() {
        return videos;
    }

}
