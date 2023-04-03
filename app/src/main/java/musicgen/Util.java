package musicgen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A class of utility methods for reading in the input.
 *
 * @author Rohan Tamhankar
 */
public class Util {
    private Util() {}

    /**
     * A BufferedReader object to read in the standard input.
     */
    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Asks a question, then reads in the response (which must be an integer).
     *
     * @param question The question posed to the user.
     * @return The user's response to the question.
     */
    public static int askInt(String question) throws IOException {
        System.out.println(question);
        return Integer.parseInt(input.readLine());
    }

    /**
     * Asks a question, then reads in the response (which must be an array of integers).
     *
     * @param question The question posed to the user.
     * @return The user's response to the question, an array of integers inputted in separate lines.
     */
    public static int[] askIntArr(String question) throws IOException {
        int size = askInt("How many numbers are you inputting?");
        int[] responses = new int[size];
        System.out.println(question);
        for (int i = 0; i < size; i++) {
            responses[i] = Integer.parseInt(input.readLine());
        }
        return responses;
    }

    /**
     * Asks a question, then reads in the response (which must be a String).
     *
     * @param question The question posed to the user.
     * @return The user's response to the question.
     */
    public static String ask(String question) throws IOException {
        System.out.println(question);
        return input.readLine();
    }
}