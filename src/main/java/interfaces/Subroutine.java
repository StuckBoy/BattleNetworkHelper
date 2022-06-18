package interfaces;

public interface Subroutine {

    /**
     * Prints the list of available options to the user.
     */
    void printOptions();

    /**
     * Process the input from the user, and call the appropriate fuction.
     * @param input The input received from the user.
     */
    void processInput(int input);
}