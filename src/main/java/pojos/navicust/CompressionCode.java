package pojos.navicust;

import interfaces.Printable;

import static systems.utility.Helpers.simplePrint;

public class CompressionCode implements Printable {
    private String programName;
    private String inputSequence;

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getInputSequence() {
        return inputSequence;
    }

    public void setInputSequence(String inputSequence) {
        this.inputSequence = inputSequence;
    }

    /**
     * Prints the {@link CompressionCode} provided in a way that is easy for
     * users to parse.
     * <p>
     * The outputted message will be formatted as such:
     * </p>
     * <pre>
     * Program:        The program to be compressed
     * Input Sequence: The inputs to compress the program
     * </pre>
     * @see systems.utility.Helpers#simplePrint(String)
     */
    @Override
    public void print() {
        System.out.println();
        simplePrint("Program:        " + getProgramName());
        simplePrint("Input Sequence: " + getInputSequence());
    }
}