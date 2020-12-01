package actions.recommendation;

import actions.recommendation.all.Standard;
import actions.recommendation.premium.Favorite;
import actions.recommendation.premium.Search;
import fileio.ActionInputData;
import fileio.Input;
import fileio.UserInputData;

import static common.Constants.PREMIUM;
import static common.Constants.SEARCH;
import static common.Constants.STANDARD;

/**
 * Class for all recommendations
 */
public final class Recommendation {
    /**
     * Message to be parsed to fileWriter.writeFile
     */
    private String message;

    /**
     * Method that applies all types of recommendations in Main
     *
     * @param action - current action
     * @param user - for whom the recommendation is made
     * @param input - the database
     */
    public void recommendation(final ActionInputData action, final UserInputData user,
                               final Input input) {

        // Applying the Standard Recommendation for all types of users
        if (action.getType().equals(STANDARD)) {
            Standard standard = new Standard();
            standard.getUnseen(user, input);
            message = standard.getMessage();
        }

        // Applying the Search Recommendation just for the premium users
        if (action.getType().equals(SEARCH)) {
            if (user.getSubscriptionType().equals(PREMIUM)) {
                Search search = new Search();
                search.search(user, input, action.getGenre());
                search.sort();
                if (search.getVideos().isEmpty()) {
                    message = "SearchRecommendation cannot be applied!";
                } else {
                    message = "SearchRecommendation result: " + search.getVideos();
                }
            } else {
                message = "SearchRecommendation cannot be applied!";
            }
        }

        // Applying the Popular Recommendation to the basic users
        if (action.getType().equals("popular")
                && !user.getSubscriptionType().equals(PREMIUM)) {
            message = "PopularRecommendation cannot be applied!";
        }

        // Applying the Favorite Recommendation just for the premium users
        if (action.getType().equals("favorite")) {
            if (!user.getSubscriptionType().equals(PREMIUM)) {
                message = "FavoriteRecommendation cannot be applied!";
            } else {
                Favorite favorite = new Favorite();
                String favoriteVideo = favorite.getFavorite(input, user);
                message = "FavoriteRecommendation result: " + favoriteVideo;
            }
        }

    }

    public String getMessage() {
        return message;
    }
}
