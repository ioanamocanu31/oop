package actions.query.video;

import fileio.ActionInputData;
import fileio.Input;
import fileio.MovieInputData;
import fileio.SerialInputData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Class for the Longest Video Query
 */
public final class Longest {
    private Map<String, Integer> movies;
    private Map<String, Integer> serials;
    private ArrayList<String> sortedMovieTitles;
    private ArrayList<String> sortedSerialTitles;

    /**
     * Method for making HashMap with the movie title and this duration
     *
     * @param input  - the database
     * @param action - current action
     */
    public void durationMovies(final Input input, final ActionInputData action) {
        movies = new HashMap<String, Integer>();
        for (MovieInputData movie : input.getMovies()
        ) {
            /* checking for the action filters */
            if ((movie.getYear().toString()).equals(action.getFilters().get(0).get(0))
                    && movie.getGenres().contains(action.getFilters().get(1).get(0))) {
                movies.put(movie.getTitle(), movie.getDuration());
            }
        }
    }

    /**
     * Method for making HashMap with the serial title and this duration
     *
     * @param input  - the database
     * @param action - current action
     */
    public void durationSerials(final Input input, final ActionInputData action) {
        serials = new HashMap<String, Integer>();
        for (SerialInputData serial : input.getSerials()
        ) {
            serial.calculateDuration();
            /* checking for the action filters */
            if ((serial.getYear().toString()).equals(action.getFilters().get(0).get(0))
                    && serial.getGenres().contains(action.getFilters().get(1).get(0))) {
                serials.put(serial.getTitle(), serial.getDuration());
            }
        }
    }

    /**
     * Method for sorting the titles
     *
     * @param sorted Map
     * @return an arrayList of titles sorted
     */
    public ArrayList<String> sortedTitles(final SortedMap<String, Integer> sorted) {
        return new ArrayList<String>(sorted.keySet());
    }

    /**
     * Method that applies sortedTitles for the Movies
     */
    public void sortedMovies() {
        SortedMap<String, Integer> sortedMovies = new TreeMap<String, Integer>(movies);
        sortedMovieTitles = sortedTitles(sortedMovies);
    }

    /**
     * Method that applies sortedTitles for the Serials
     */
    public void sortedSerials() {
        SortedMap<String, Integer> sortedSerials = new TreeMap<String, Integer>(serials);
        sortedSerialTitles = sortedTitles(sortedSerials);
    }

    public ArrayList<String> getSortedMovieTitles() {
        return sortedMovieTitles;
    }

    public ArrayList<String> getSortedSerialTitles() {
        return sortedSerialTitles;
    }
}
