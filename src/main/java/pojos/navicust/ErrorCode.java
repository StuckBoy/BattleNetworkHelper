package pojos.navicust;

import interfaces.Printable;

import static systems.utility.Helpers.simplePrint;

public class ErrorCode implements Printable {
    private String code;
    private String program;
    private String obtainedFrom;
    private String errorNumber;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getObtainedFrom() {
        return obtainedFrom;
    }

    public void setObtainedFrom(String obtainedFrom) {
        this.obtainedFrom = obtainedFrom;
    }

    public String getErrorNumber() {
        return errorNumber;
    }

    public void setErrorNumber(String errorNumber) {
        this.errorNumber = errorNumber;
    }

    /**
     * Prints the {@link ErrorCode} provided in a way that is easy for users to
     * parse.
     * <p>
     * The outputted message will be formatted as such:
     * </p>
     * <pre>
     * Error Code:    The sequence to be inputted
     * Program:       The program triggering the code
     * Obtained From: Which style the program originated from
     * Error Number:  The error code displayed in-game.
     * </pre>
     * @see systems.utility.Helpers#simplePrint(String)
     */
    @Override
    public void print() {
        System.out.println();
        simplePrint("Error Code:    " + getCode());
        simplePrint("Program:       " + getProgram());
        simplePrint("Obtained From: " + getObtainedFrom());
        simplePrint("Error Number:  " + getErrorNumber());
    }
}