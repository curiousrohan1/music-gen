package musicgen;

import java.util.List;

/**
 * An operation to be completed, based on the operator and index given.
 */
public class Action {
    /**
     * A character referring to an operation (addition, subtraction, multiplication, division, or exponents).
     */
    private final char operator;
    /**
     * The number of elements away from the last note the desired note is. Used to select the desired note.
     */
    private final int idx;

    /**
     * A constructor to create an Action.
     *
     * @param com A string containing the operator and index.
     */
    public Action(String com) {
        operator = com.charAt(0);
        idx = com.charAt(1) - '0';
    }

    /**
     * Runs the desired action.
     *
     * @param running The last note of the sequence of notes so far or an intermediate result for a new note being
     *                generated.
     * @param past    A list of all notes so far; used to select the desired note to operate on.
     * @return The next note in the sequence after calculation.
     */
    public int execute(int running, List<Integer> past) {
        int operand = past.get(past.size() - 1 - idx);
        switch (operator) {
            case '+' -> {
                running += operand;
            }
            case '-' -> {
                running -= operand;
            }
            case '*' -> {
                running *= operand;
            }
            case '/' -> {
                running /= operand;
            }
            case '^' -> {
                running = (int) (Math.pow(running, operand));
            }
            default -> {
                System.err.println("You entered " + operator + " as an operator, but it's not.");
            }
        }
        return running;
    }
}



