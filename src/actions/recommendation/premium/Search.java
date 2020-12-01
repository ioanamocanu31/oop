package actions.recommendation.premium;

import fileio.Input;
import fileio.MovieInputData;
import fileio.SerialInputData;
import fileio.ShowInput;
import fileio.UserInputData;

import java.util.ArrayList;
import java.util.Collections;

public final class Search {
    private ArrayList<String> videos = new ArrayList<String>();

    /**
     * @param user
     * @param show
     * @param genre
     */
    public void searchShow(final UserInputData user, final ShowInput show, final String genre) {
        String title = show.getTitle();
        if (!user.getHistory().containsKey(title)
                && show.getGenres().contains(genre)) {
            videos.add(title);
        }
    }

    /**
     * @param user
     * @param input
     * @param genre
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
     *
     */
    public void sort() {
        Collections.sort(videos);
    }

    public ArrayList<String> getVideos() {
        return videos;
    }

}
