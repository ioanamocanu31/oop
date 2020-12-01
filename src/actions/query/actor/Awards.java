package actions.query.actor;

import fileio.ActionInputData;
import fileio.ActorInputData;
import fileio.Input;

import java.util.HashMap;
import java.util.Map;

import static common.Constants.THREE;
import static utils.Utils.stringToAwards;

public final class Awards {
    private Map<String, Integer> actorAwards;

    /**
     * @param input
     * @param action
     */
    public void awards(final Input input, final ActionInputData action) {
        actorAwards = new HashMap<String, Integer>();
        for (ActorInputData actor : input.getActors()
        ) {
            int contains = 1;
            for (String award : action.getFilters().get(THREE)
            ) {
                if (!actor.getAwards().containsKey(stringToAwards(award))) {
                    contains = 0;
                    break;
                }
            }
            if (contains == 1) {
                Integer awards = actor.getTotalAwards();
                actorAwards.put(actor.getName(), awards);
            }
        }
    }

    public Map<String, Integer> getActorAwards() {
        return actorAwards;
    }
}
