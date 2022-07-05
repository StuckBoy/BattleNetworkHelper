package interfaces;

import java.util.List;
import java.util.Scanner;

import systems.utility.Helpers;

/**
 * Represents a system that performs a wide range of ways to perform a specific
 * task, such as searching for chips or looking up Program Advances.
 */
public interface Subsystem {

    /**
     * Prints the list of available options to the user.
     * @see Helpers#printOptions(List)
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