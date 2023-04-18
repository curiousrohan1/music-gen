package musicgen;

import java.util.List;

/**
 * An operation to be completed, based on the operator and index given.
 */
public class Action {
    /**
     * An operator (addition, subtraction, multiplication, division, or exponents).
     */
    private final Operator operator;
    /**
     * The number of elements away from the last note the desired note is. Used to
     * select the desired note.
     */
    private final int idx;

    /**
     * A constructor to create an Action.
     *
     * @param operator An operator from the Operator enum.
     * @param idx      The number of elements away from the last note the desired note is.
     */
    public Action(Operator operator, int idx) {
        this.operator = operator;
        this.idx = idx;
    }

    /**
     * Runs the desired action.
     *
     * @param running The last note of the sequence of notes so far or an
     *                intermediate result for a new note being
     *                generated.
     * @param past    A list of all notes so far; used to select the desired note to
     *                operate on.
     * @return The next note in the sequence after calculation.
     */
    public int execute(int running, List<Integer> past) {
        int operand = past.get(past.size() - 1 - idx);
        switch (operator) {
            case ADD:
                return running + operand;
            case SUBTRACT:
                return running - operand;
            case MULTIPLY:
                return running * operand;
            case DIVIDE:
                if (operand != 0) {
                    return running / operand;
                } else {
                    throw new ArithmeticException();
                }
            case EXPONENT:
                return (int) Math.pow(running, operand);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
