package systems.lookups;

import constants.Game;
import exceptions.UnsupportedGameException;
import interfaces.Subsystem;
import pojos.ProgramAdvance;
import systems.utility.Helpers;
import systems.utility.readers.ProgramAdvanceFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static systems.utility.Helpers.simplePrint;

public class ProgramAdvanceLookup implements Subsystem {

    private ProgramAdvanceFileReader reader;
    private final Game currentGame;

    public ProgramAdvanceLookup(Game currentGame) throws UnsupportedGameException, IOException {
        this.currentGame = currentGame;
        bootSequence();
    }

    private void bootSequence() throws UnsupportedGameException, IOException {
        try {
            reader = new ProgramAdvanceFileReader(currentGame);
            simplePrint("P.A. Lookup booted." + System.lineSeparator());
        } catch (IOException | UnsupportedGameException ex) {
            simplePrint("Error encountered while booting P.A. Lookup");
            simplePrint(ex.getMessage() + System.lineSeparator());
            throw ex;
        }
    }

    @Override
    public void printOptions() {
        List<String> options = new ArrayList<>();
        options.add("Search by name");
        options.add("Search by damage");
        options.add("Search by chip used");
        options.add("Return to main menu");
        Helpers.printOptions(options);
    }

    @Override
    public void processInput(int input, Scanner keyboard) {
        switch(input) {
            case 1 -> beginNameSearch(keyboard);
            case 2 -> beginDamageSearch(keyboard);
            case 3 -> beginChipUseSearch(keyboard);
            case 4 -> simplePrint("Returning to main menu...\n");
            default -> simplePrint("Unusable input, please try again.");
        }
    }

    private void beginNameSearch(Scanner keyboard) {
        simplePrint("Please enter the name of the Program Advance.");
        String input = keyboard.next();
        List<ProgramAdvance> matchingPAs = reader.searchPAsByName(input);
        printOutcome(matchingPAs);
    }

    private void printOutcome(List<ProgramAdvance> matchingPAs) {
        if (!matchingPAs.isEmpty()) {
            printSuccessString(matchingPAs);
        } else {
            simplePrint(failedSearchString());
        }
    }

    private void printSuccessString(List<ProgramAdvance> matchingPAs) {
        simplePrint("Here's your P.A.(s)!");
        matchingPAs.forEach(ProgramAdvance::print);
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
        simplePrint("Please input the damage of the Program Advance.");
        int input = keyboard.nextInt();
        List<ProgramAdvance> foundPAs = reader.searchPAsByDamage(input);
        printOutcome(foundPAs);
    }

    private void beginChipUseSearch(Scanner keyboard) {
        simplePrint("Please input the name of the chip used.");
        String input = keyboard.next();
        List<ProgramAdvance> foundPAs = reader.searchPAsByChipUsed(input);
        printOutcome(foundPAs);
    }
}