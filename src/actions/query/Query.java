package actions.query;

import actions.query.actor.Awards;
import actions.query.video.Favorite;
import actions.query.video.Longest;
import actions.query.video.MostViewed;
import actions.query.video.Rating;
import fileio.ActionInputData;
import fileio.Input;

import static common.Constants.AWARDS;
import static common.Constants.FAVORITE;
import static common.Constants.LONGEST;
import static common.Constants.MOSTVIEWED;
import static common.Constants.MOVIES;
import static common.Constants.QRESULT;
import static common.Constants.RATINGS;
import static common.Constants.SHOWS;

/**
 * Class for all queries
 */
public final class Query {
    /**
     * Message to be parsed to fileWriter.writeFile
     */
    private String message;

    /**
     * Method that applies all types of queries in Main
     *
     * @param action - current action
     * @param input  - the database
     */
    public void query(final ActionInputData action, final Input input) {

        // Applying the Longest Query
        if (action.getCriteria().equals(LONGEST)) {
            Longest longest = new Longest();
            if (action.getObjectType().equals(MOVIES)) {
                longest.durationMovies(input, action);
                longest.sortedMovies();
                message = QRESULT + longest.getSortedMovieTitles();
            }
            if (action.getObjectType().equals(SHOWS)) {
                longest.durationSerials(input, action);
                longest.sortedSerials();
                message = QRESULT + longest.getSortedSerialTitles();
            }
        }

        // Applying the Awards Query
        if (action.getCriteria().equals(AWARDS)) {
            Awards awards = new Awards();
            awards.awards(input, action);
            message = QRESULT + awards.getActorAwards().values();
        }
        // Applying the MostViewed Query
        if (action.getCriteria().equals(MOSTVIEWED)) {
            MostViewed mostViewed = new MostViewed();
            mostViewed.calculateViews(input);
            mostViewed.setMostViewed(input, action);
            message = QRESULT + mostViewed.getMostViewed();
        }

        // Applying the Rating Query
        if (action.getCriteria().equals(RATINGS)) {
            Rating rating = new Rating();
            rating.setMostRated(input, action);
            message = QRESULT + rating.getMostRated();
        }

        // Applying the Favorite Query
        if (action.getCriteria().equals(FAVORITE)) {
            if (action.getObjectType().equals(MOVIES)) {
                Favorite favorite = new Favorite();
                favorite.calculateOccurrence(input);
                message = QRESULT + favorite.getFavoriteMovies().keySet();
            }
            if (action.getObjectType().equals(SHOWS)) {
                Favorite favorite = new Favorite();
                favorite.calculateOccurrence(input);
                message = QRESULT + favorite.getFavoriteSerials().keySet();
            }
        }
    }

    public String getMessage() {
        return message;
    }
}
