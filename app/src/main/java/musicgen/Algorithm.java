package musicgen;

import java.util.ArrayList;
import java.util.List;

/**
 * The command inputted, turned into a list of actions to be executed.
 *
 * @author Rohan Tamhankar
 */
public class Algorithm {
    /**
     * The list of actions to be executed.
     */
    private final List<Action> actions;

    /**
     * Reads in the command and then converts it into the aforementioned list of actions.
     */
    public Algorithm(String response) {
        actions = new ArrayList<>();
        for (int i = 0; i < response.length(); i += 2) {
            actions.add(new Action(response.substring(i, i + 2)));
        }
    }

    /**
     * Sequentially runs each action on the last note in the sequence of notes given.
     *
     * @param text The list of notes inputted by the user in number format.
     * @return the newly generated note.
     */
    public int run(List<Integer> text) {
        int running = text.get(text.size() - 1);
        for (Action act : actions) {
            running = act.execute(running, text);
        }
        return running;
    }
}
