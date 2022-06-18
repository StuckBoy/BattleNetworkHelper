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
     * Method overload to allow multiple {@link Chip} to be printed at a time.
     *
     * @param chips The {@link List} of {@link Chip} to be printed.
     * @see #prettyPrintProgramAdvanceList(Chip)
     */
    public static void prettyPrintChipList(List<Chip> chips) {
        chips.forEach(Helpers::prettyPrintProgramAdvanceList);
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
     */
    public static void prettyPrintProgramAdvanceList(Chip chip) {
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

    public static void prettyPrintProgramAdvanceList(List<ProgramAdvance> programAdvances) {
        programAdvances.forEach(Helpers::prettyPrintProgramAdvanceList);
    }

    public static void prettyPrintProgramAdvanceList(ProgramAdvance programAdvance) {
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

    public static void prettyPrintExtraCode(ExCode exCode) {
        System.out.println();
        print("Extra Code:  " + exCode.getCode());
        print("Effect:      " + exCode.getEffect());
        print("Glitch:      " + exCode.getGlitch());
    }

    public static void prettyPrintErrorCodes(List<ErrorCode> errorCodes) {
        errorCodes.forEach(Helpers::prettyPrintErrorCode);
    }

    public static void prettyPrintErrorCode(ErrorCode errorCode) {
        System.out.println();
        print("Error Code:    " + errorCode.getCode());
        print("Program:       " + errorCode.getProgram());
        print("Obtained From: " + errorCode.getObtainedFrom());
        print("Error Number:  " + errorCode.getErrorNumber());
    }

    public static void prettyPrintCompressionCodes(List<CompressionCode> compressionCodes) {
        compressionCodes.forEach(Helpers::prettyPrintCompressionCode);
    }

    public static void prettyPrintCompressionCode(CompressionCode compressionCode) {
        System.out.println();
        print("Program:        " + compressionCode.getProgramName());
        print("Input Sequence: " + compressionCode.getInputSequence());
    }
}