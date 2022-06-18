package interfaces.subroutines;

import java.util.Scanner;

public interface SearchSubroutine extends Subroutine {

    /**
     * Accepts input from the user and performs the appropriate function. For
     * functions requiring additional input, a {@link Scanner} is included.
     *
     * @param input The input given from the user.
     * @param keyboard The {@link Scanner} given in case additional input is
     *                 required.
     */
    void processInput(int input, Scanner keyboard);
}