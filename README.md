# MusicGen

## Summary

This program generates music based on what the user inputs.

## Input

### Command

The first thing the program asks you to input is a command. This command is used throughout the program to generate each
note. The command is a series of two-character segments. The first character in each segment is an arithmetic operation
(addition, subtraction, multiplication, division, and exponentiation), and the second character is a number. The
number (which I'll refer to as n) is used to select a note that is n notes prior to the last note. The notes are
inputted in number form (more on that later). To compute a new note following the current last note, we apply each
(operation, n) pair. For example, if the user inputted 4 notes in number form: [3,5,7,9] and the
command "+1-2", we would add 7 (which is 1 prior to the last note) to 9 and then subtract 5 (which is 2 prior to
the last note) to get 11. We would then add 11 to the end of the array of notes and apply the command once more to get
11+9-7 = 13.

### Seed Notes

Next, we prompt for the number of notes the user wants to input. After the number of notes is inputted, the program asks
for notes in their number form. The number each note corresponds to is the fret on the low E string of a guitar that
plays that note. For example, the number 3 corresponds to low sol, the note that you'd play if you played the low E
string with your finger on the third fret. There are 37 notes that this program accepts. The number of notes inputted
must be greater than the greatest number used in the command. Otherwise, the program will fail because the offset would
take us beyond the first note.

## Output

The output is a list of notes in a certain format: "S[F]{N}".This notation is an instruction for guitar players. S is
the name of the string (in order from lowest to highest: E, A, D, G, B, HighE). F is the fret on that string that the
note corresponds to. Finally, N is the number that the note corresponds to. For example, "A[1]{6}" refers to the note
played on the A string with a finger on the first fret. This note corresponds to the number 6.

## Future Directions

Integrate with a sound library to actually play the result tune.
