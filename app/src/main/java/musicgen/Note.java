package musicgen;

/**
 * A note with a designated string, fret, and numerical designation.
 *
 * @author Rohan Tamhankar
 */
public class Note {
    /**
     * A static array of strings used to find the specific guitar string of a note corresponding to a certain numerical
     * designation.
     */
    static final String[] strings = {"E", "E", "E", "E", "E", "A", "A", "A", "A", "A", "D", "D", "D", "D", "D", "G", "G", "G", "G", "B", "B", "B", "B", "B", "HighE", "HighE", "HighE", "HighE", "HighE", "HighE", "HighE", "HighE", "HighE", "HighE", "HighE", "HighE"};
    /**
     * A static array of frets used to find the specific fret of a note corresponding to a certain numerical designation.
     */
    static final int[] frets = {0, 1, 2, 3, 4, 0, 1, 2, 3, 4, 0, 1, 2, 3, 4, 0, 1, 2, 3, 0, 1, 2, 3, 4, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    /**
     * The name of the string that the note is on.
     */
    private final String string;
    /**
     * The name of the fret the note is on.
     */
    private final int fret;
    /**
     * The numerical designation of the note.
     */
    private final int numDes;


    /**
     * Creates the note.
     *
     * @param num The numerical designation of the note; used to find the other attributes of the note.
     */
    public Note(int num) {
        string = strings[num];
        fret = frets[num];
        numDes = num;
    }

    /**
     * The toString() method for notes, formatting them into the following notation: S[F]{N} where S is the name of the
     * string, F is the fret number, and N is the numerical designation of the note.
     *
     * @return A string that contains the string name, fret number, and numerical designation in a concise but readable
     * (by both the code and the user) way.
     */
    public String toString() {
        return string + "[" + fret + "]{" + numDes + "}";
    }
}