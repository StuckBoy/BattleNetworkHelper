package interfaces;

import java.util.Scanner;

/**
 * Represents a system that performs a wide range of ways to perform a specific
 * task, such as searching for chips or looking up Program Advances.
 */
public interface Subsystem {

    /**
     * Prints the list of available options to the user.
     */
    void printOptions();

    /**
     * Process the input from the user, and chooses the appropriate search to
     * begin using.
     *
     * @param input The number inputted by the user.
     * @param keyboard The {@link Scanner} that is reading the user's input.
     */
    void processInput(int input, Scanner keyboard);
}