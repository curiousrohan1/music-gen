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
        Algorithm alg = new Algorithm();
        int[] input = Util.askIntArr("Please input some notes in their number form.");
        int numNotes = Util.askInt("How many notes do you want to generate?");
        for (int note : input) {
            nums.add(note);
        }
        for (int i = 0; i < numNotes; i++) {
            int num = alg.run(nums);
            // There are 37 notes that we can handle, based on the notes one can play on a guitar without surpassing
            // the 12th fret, so we limit the algorithm results to that range (e.g. 0-36).
            num %= 37;
            while (num < 0) {
                num += 37;
            }
            nums.add(num);
        }
        for (int j = 0; j < nums.size(); j++) {
            Note note = new Note(nums.get(j));
            System.out.println(note);
            if (j % 4 == 3) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
