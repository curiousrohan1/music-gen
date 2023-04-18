package musicgen;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class to generate music.
 *
 * @author Rohan Tamhankar
 */
public class MusicGenerator {
    /**
     * The list of notes in number form.
     */
    static final List<Integer> nums = new ArrayList<>();

    /**
     * Reads in the list of notes, the desired algorithm, and the desired number of notes to generate. It then
     * calculates the next notes and prints them out.
     */
    public static void main(String[] args) throws IOException {
        Algorithm alg = new Algorithm(Util.ask("Add command."));
        int[] input = Util.askIntArr("Please input some notes in their number form.");
        int numNotes = Util.askInt("How many notes do you want to generate?");
        for (int note : input) {
            nums.add(note);
        }
        generateNotes(alg, numNotes);
        printNotes();
        nums.clear();
        System.out.println();
    }

    /**
     * Generates notes based off of the inputted algorithm.
     *
     * @param alg      The algorithm used to generate each subsequent note.
     * @param numNotes The number of notes the user wants the program to generate. It does not include the number of
     *                 notes the user inputted.
     */
    private static void generateNotes(Algorithm alg, int numNotes) {
        for (int i = 0; i < numNotes; i++) {
            int num = alg.run(nums);
            // There are 36 notes that we can handle, based on the notes one can play on a guitar without reaching
            // the 12th fret, so we limit the algorithm results to that range (e.g. 0-35).
            while (num < 0) {
                num += 36;
            }
            num %= 36;
            nums.add(num);
        }
    }

    /**
     * Generates notes that correspond to the Fibonacci sequence.
     */
    public static void fibonacci() throws IOException {
        Algorithm alg = new Algorithm("+1");
        // The Pisano period (the periods in which the Fibonacci sequence mod n repeats) of 36 is 24, and we've already
        // entered 2 numbers, leaving 22 more that we want to generate. If we generate any more numbers, it will repeat
        // the sequence.
        int numNotes = 22;
        nums.add(0);
        nums.add(1);
        generateNotes(alg, numNotes);
        printNotes();
        nums.clear();
        System.out.println();
    }

    /**
     * Prints all the notes (inputted and generated). The notes are grouped into four-note measures which are each
     * separated by an extra carriage return.
     */
    private static void printNotes() {
        for (int j = 0; j < nums.size(); j++) {
            Note note = new Note(nums.get(j));
            System.out.println(note);
            if (j % 4 == 3) {
                System.out.println();
            }
        }
    }
}
