package systems.lookups;

import interfaces.Subsystem;
import pojos.ProgramAdvance;
import systems.utility.Helpers;
import systems.utility.readers.ProgramAdvanceFileReader;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static systems.utility.Helpers.print;

public class ProgramAdvanceLookup implements Subsystem {

    private ProgramAdvanceFileReader reader;

    public ProgramAdvanceLookup() {
        bootSequence();
    }

    private void bootSequence() {
        try {
            reader = new ProgramAdvanceFileReader();
            print("P.A. Lookup booted.");
        } catch (IOException ex) {
            print("Error encountered while booting P.A. Lookup");
            print(ex.getMessage());
        }
    }

    @Override
    public void printOptions() {
        print(System.lineSeparator());
        print("""
        Please select an option
        1) Search by name
        2) Search by damage
        3) Search by chip used
        4) Return to main menu
        """);
    }

    @Override
    public void processInput(int input, Scanner keyboard) {
        switch(input) {
            case 1 -> beginNameSearch(keyboard);
            case 2 -> beginDamageSearch(keyboard);
            case 3 -> beginChipUseSearch(keyboard);
            case 4 -> print("Returning to main menu...\n");
            default -> print("Unusable input, please try again.");
        }
    }

    private void beginNameSearch(Scanner keyboard) {
        print("Please enter the name of the Program Advance.");
        String input = keyboard.next();
        List<ProgramAdvance> matchingPAs = reader.searchPAsByName(input);
        printOutcome(matchingPAs);
    }

    private void printOutcome(List<ProgramAdvance> matchingPAs) {
        if (!matchingPAs.isEmpty()) {
            printSuccessString(matchingPAs);
        } else {
            print(failedSearchString());
        }
    }

    private void printSuccessString(List<ProgramAdvance> matchingPAs) {
        print("Here's your P.A.(s)!");
        Helpers.prettyPrintProgramAdvanceList(matchingPAs);
    }

    /**
     * Returns a generalized failure string for searches.
     *
     * @return A {@link String} indicating the search failed to find anything.
     */
    private String failedSearchString() {
        return "Sorry, couldn't find any Program Advance with that criteria. :(";
    }

    private void beginDamageSearch(Scanner keyboard) {

    }

    private void beginChipUseSearch(Scanner keyboard) {

    }
}