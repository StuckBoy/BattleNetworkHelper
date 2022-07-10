package interfaces.subroutines;

import java.util.List;

import systems.utility.Helpers;

public interface Subroutine {

    /**
     * Prints the list of available options to the user.
     * @see Helpers#printOptions(List)
     */
    void printOptions();
}