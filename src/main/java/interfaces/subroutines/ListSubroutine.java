package interfaces.subroutines;

public interface ListSubroutine extends Subroutine {

    /**
     * Accepts input from the user and performs the appropriate function,
     * typically a list of some type.
     * @param input
     */
    void processInput(int input);
}