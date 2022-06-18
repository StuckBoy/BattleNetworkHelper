package systems.utility;

import pojos.*;

import java.util.List;

public class Helpers {

    /**
     * Allows for errors to be printed using a single call, while not disrupting
     * the spacing of messages from the console. I.E. it prints the message,
     * then a System-dependent line separator.
     *
     * @param s The {@link String} we wish to print.
     * @see #print(String)
     * @see System#lineSeparator()
     */
    public static void errorPrint(String s) {
        print(s);
        print(System.lineSeparator());
    }

    /**
     * Simplifies calls to {@link System} for printing.
     * @param s The complete {@link String} to be printed.
     */
    public static void print(String s) {
        System.out.println(s);
    }

    /**
     * Method to allow multiple {@link Chip} to be printed at a time.
     *
     * @param chips The {@link List} of {@link Chip} to be printed.
     * @see #prettyPrintChip(Chip)
     */
    public static void prettyPrintChipList(List<Chip> chips) {
        chips.forEach(Helpers::prettyPrintChip);
    }

    /**
     * Prints the {@link Chip} provided in a way that is easy for users to
     * parse.
     * <p>
     * The outputted message will be formatted as such:
     * <p>
     * <pre>
     * Number:      ###
     * Name:        Chip Name
     * Damage:      ### / -
     * Code(s):     A,B,C,D,E,*
     * Memory Size: ## MB
     * Description: Chip Description
     * Location(s): Where to find the chip in-game.
     * </pre>
     * @param chip The {@link Chip} whose information we wish to print.
     * @see #print(String)
     */
    public static void prettyPrintChip(Chip chip) {
        System.out.println();
        print("Number:      " + chip.getNumber());
        print("Name:        " + chip.getName());
        if (chip.getDamage() != null) {
            print("Damage:      " + chip.getDamage());
        } else {
            print("Damage:      -");
        }
        print("Code(s):     " + chip.getPossibleCodes());
        print("Memory Size: " + chip.getMemory() + " MB");
        print("Description: " + chip.getDescription());
        print("Location(s): " + chip.getLocations());
    }

    /**
     * Method to allows multiple {@link ProgramAdvance} to be printed at a time.
     * @param programAdvances The {@link List} of {@link ProgramAdvance} to be
     *                        printed.
     * @see #prettyPrintProgramAdvance(ProgramAdvance)
     */
    public static void prettyPrintProgramAdvanceList(List<ProgramAdvance> programAdvances) {
        programAdvances.forEach(Helpers::prettyPrintProgramAdvance);
    }

    /**
     * Prints the {@link ProgramAdvance} provided in a way that is easy for
     * users to parse.
     * <p>
     * The outputted message will be formatted as such:
     * </p>
     * <pre>
     * Name:        Chip Name
     * Damage:      ### / -
     * Chips Used:  Chip 1 + Chip 2...
     * Description: Program Advance Description
     * </pre>
     * @param programAdvance The {@link ProgramAdvance} whose information we
     *                       wish to print.
     * @see #print(String)
     */
    public static void prettyPrintProgramAdvance(ProgramAdvance programAdvance) {
        System.out.println();
        print("Name:      " + programAdvance.getName());
        if (programAdvance.getDamage() != null) {
            print("Damage:      " + programAdvance.getDamage());
        } else {
            print("Damage:      -");
        }
        //TODO Implement pretty print for chips used in Program Advance.
        //print("Chips used:");
        print("Description: " + programAdvance.getDescription());
    }

    public static void prettyPrintExtraCodes(List<ExCode> exCodes) {
        exCodes.forEach(Helpers::prettyPrintExtraCode);
    }

    /**
     * Prints the {@link ExCode} provided in a way that is easy for users to
     * parse.
     * <p>
     * The outputted message will be formatted as such:
     * </p>
     * <pre>
     * Extra Code:  The sequence to be inputted
     * Effect:      Description of the effect.
     * Glitch:      Side effects of using the code.
     * </pre>
     * @param exCode The {@link ExCode} whose information we wish to print.
     * @see #print(String)
     */
    public static void prettyPrintExtraCode(ExCode exCode) {
        System.out.println();
        print("Extra Code:  " + exCode.getCode());
        print("Effect:      " + exCode.getEffect());
        print("Glitch:      " + exCode.getGlitch());
    }

    /**
     * Method to allow multiple {@link ErrorCode} to be printed at a time.
     * @param errorCodes The {@link List} of {@link ErrorCode} to be printed.
     * @see #prettyPrintErrorCode(ErrorCode)
     */
    public static void prettyPrintErrorCodes(List<ErrorCode> errorCodes) {
        errorCodes.forEach(Helpers::prettyPrintErrorCode);
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
     * @param errorCode The {@link ErrorCode} whose information we wish to
     *                  print.
     * @see #print(String)
     */
    public static void prettyPrintErrorCode(ErrorCode errorCode) {
        System.out.println();
        print("Error Code:    " + errorCode.getCode());
        print("Program:       " + errorCode.getProgram());
        print("Obtained From: " + errorCode.getObtainedFrom());
        print("Error Number:  " + errorCode.getErrorNumber());
    }

    /**
     * Method to allow multiple {@link CompressionCode} to be printed at a time.
     * @param compressionCodes The {@link List} of {@link CompressionCode} to be
     *                         printed.
     * @see #prettyPrintCompressionCode(CompressionCode)
     */
    public static void prettyPrintCompressionCodes(List<CompressionCode> compressionCodes) {
        compressionCodes.forEach(Helpers::prettyPrintCompressionCode);
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
     * @param compressionCode The {@link CompressionCode} whose information we
     *                        wish to print.
     * @see #print(String)
     */
    public static void prettyPrintCompressionCode(CompressionCode compressionCode) {
        System.out.println();
        print("Program:        " + compressionCode.getProgramName());
        print("Input Sequence: " + compressionCode.getInputSequence());
    }
}