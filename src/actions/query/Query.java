package actions.query;

import actions.query.actor.Awards;
import actions.query.video.Favorite;
import actions.query.video.Longest;
import actions.query.video.MostViewed;
import actions.query.video.Rating;
import fileio.ActionInputData;
import fileio.Input;

public final class Query {
    /**
     * Message to be parsed to fileWriter.writeFile
     */
    private String message;

    /**
     * @param action
     * @param input
     */
    public void query(final ActionInputData action, final Input input) {
        if (action.getCriteria().equals("longest")) {
            Longest longest = new Longest();
            if (action.getObjectType().equals("movies")) {
                longest.durationMovies(input, action);
                longest.sortedMovies();
                message = "Query result: " + longest.getSortedMovieTitles();
            }
            if (action.getObjectType().equals("shows")) {
                longest.durationSerials(input, action);
                longest.sortedSerials();
                message = "Query result: " + longest.getSortedSerialTitles();
            }
        }

        if (action.getCriteria().equals("awards")) {
            Awards awards = new Awards();
            awards.awards(input, action);
            message = "Query result: " + awards.getActorAwards().values();
        }

        if (action.getCriteria().equals("most_viewed")) {
            MostViewed mostViewed = new MostViewed();
            mostViewed.calculateViews(input);
            mostViewed.setMostViewed(input, action);
            message = "Query result: " + mostViewed.getMostViewed();
        }

        if (action.getCriteria().equals("ratings")) {
            Rating rating = new Rating();
            rating.setMostRated(input, action);
            message = "Query result: " + rating.getMostRated();
        }

        if (action.getCriteria().equals("favorite")) {
            if (action.getObjectType().equals("movies")) {
                Favorite favorite = new Favorite();
                favorite.calculateOccurrence(input);
                message = "Query result: " + favorite.getFavoriteMovies().keySet();
            }
            if (action.getObjectType().equals("shows")) {
                Favorite favorite = new Favorite();
                favorite.calculateOccurrence(input);
                message = "Query result: " + favorite.getFavoriteSerials().keySet();
            }
        }
    }

    public String getMessage() {
        return message;
    }
}
