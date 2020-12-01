package actions.recommendation;

import actions.recommendation.all.Standard;
import actions.recommendation.premium.Favorite;
import actions.recommendation.premium.Search;
import fileio.ActionInputData;
import fileio.Input;
import fileio.UserInputData;

public final class Recommendation {
    /**
     * Message to be parsed to fileWriter.writeFile
     */
    private String message;

    /**
     * @param action
     * @param user
     * @param input
     */
    public void recommendation(final ActionInputData action, final UserInputData user,
                               final Input input) {
        if (action.getType().equals("standard")) {
            Standard standard = new Standard();
            standard.getUnseen(user, input);
            message = standard.getMessage();
        }
        if (action.getType().equals("search")) {
            if (user.getSubscriptionType().equals("PREMIUM")) {
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
        if (action.getType().equals("popular")
                && user.getSubscriptionType().equals("BASIC")) {
            message = "PopularRecommendation cannot be applied!";
        }

        if (action.getType().equals("favorite")) {
            if (user.getSubscriptionType().equals("BASIC")) {
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
