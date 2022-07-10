package systems.lookups;

import constants.Game;
import exceptions.UnsupportedGameException;
import interfaces.Subsystem;
import org.apache.commons.lang3.StringUtils;
import pojos.Chip;
import systems.utility.Helpers;
import systems.utility.readers.ChipFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static systems.utility.Helpers.errorPrint;
import static systems.utility.Helpers.simplePrint;

public class ChipLookup implements Subsystem {

    private ChipFileReader reader;
    private final Game currentGame;

    /**
     * Prepares the necessary files to search for specific a {@link Chip}.
     *
     * @param currentGame The {@link Game} currently selected from the user
     *                    config.
     * @throws IOException If one or more of the files fail to load.
     * @throws UnsupportedGameException If the currently selected {@link Game}
     * is not yet supported.
     */
    public ChipLookup(Game currentGame) throws IOException, UnsupportedGameException {
        this.currentGame = currentGame;
        bootSequence();
    }

    /**
     * Prepares the {@link ChipFileReader} to parse the data necessary for searches.
     */
    private void bootSequence() throws IOException, UnsupportedGameException {
        try {
            reader = new ChipFileReader(currentGame);
            simplePrint("Chip lookup booted.");
        } catch (IOException | UnsupportedGameException ex) {
            simplePrint("Error encountered while booting Chip Lookup.");
            simplePrint(ex.getMessage());
            throw ex;
        }
    }

    @Override
    public void printOptions() {
        simplePrint(System.lineSeparator());
        List<String> options = new ArrayList<>();
        options.add("Search by number");
        options.add("Search by name");
        options.add("Search by damage");
        options.add("Search by code");
        options.add("Search by memory size");
        options.add("Return to main menu");
        Helpers.printOptions(options);
    }

    /**
     * @inheritDoc
     *
     * @see #beginNumberSearch(Scanner)
     * @see #beginNameSearch(Scanner)
     * @see #beginDamageSearch(Scanner)
     * @see #beginCodeSearch(Scanner)
     * @see #beginMemorySizeSearch(Scanner)
     */
    @Override
    public void processInput(int input, Scanner keyboard) {
        switch (input) {
            case 1 -> beginNumberSearch(keyboard);
            case 2 -> beginNameSearch(keyboard);
            case 3 -> beginDamageSearch(keyboard);
            case 4 -> beginCodeSearch(keyboard);
            case 5 -> beginMemorySizeSearch(keyboard);
            case 6 -> simplePrint("Returning to main menu...\n");
            default -> simplePrint("Unusable input, please try again.");
        }
    }

    /**
     * Performs a search for chip(s) that have the matching number as inputted
     * by the user. The appropriate result is then printed out to the user.
     *
     * @param keyboard The {@link Scanner} that is reading the user's input.
     */
    private void beginNumberSearch(Scanner keyboard) {
        int input = -1;
        while (input == -1) {
            simplePrint("Please enter the number of the chip you wish to find.");
            try {
                input = keyboard.nextInt();
            } catch (InputMismatchException ex) {
                errorPrint("Invalid input, please only provide a number.");
                keyboard.next();
            }
        }
        List<Chip> foundChips = reader.searchChipsByNumber(String.valueOf(input));
        printOutcome(foundChips);
    }

    /**
     * Calls the appropriate print message based on whether the {@link List} of
     * {@link Chip} contains any entries. If it does not, a failure message is
     * shown. Otherwise, the chips are printed in a formatted manner for
     * readability.
     *
     * @param foundChips The {@link List} of {@link Chip} from a search.
     */
    private void printOutcome(List<Chip> foundChips) {
        if (!foundChips.isEmpty()) {
            printSuccessStrings(foundChips);
        } else {
            simplePrint(failedSearchString());
        }
    }

    /**
     * Prints the given {@link List} in a format that should be easily read by
     * the user.
     *
     * @param foundChips The {@link List} of {@link Chip} to be printed.
     * @see Chip#print()
     */
    private void printSuccessStrings(List<Chip> foundChips) {
        simplePrint("Here's your chip(s)!");
        foundChips.forEach(Chip::print);
    }

    /**
     * Returns a generalized failure string for searches.
     *
     * @return A {@link String} indicating the search failed to find anything.
     */
    private String failedSearchString() {
        return "Sorry, couldn't find a chip like that. :(";
    }

    /**
     * Performs a search using word given by the user. The word should match the
     * name of the chip that they wish to view exactly. The resulting chip is 
     * then printed out to the user from the resulting list.
     *
     * @param keyboard The {@link Scanner} that is reading the user's input.
     * @see #printOutcome(List)
     */
    private void beginNameSearch(Scanner keyboard) {
        simplePrint("Please enter the name of the chip as it appears in-game.");
        String input = keyboard.next();
        List<Chip> foundChips = reader.searchChipsByName(input);
        printOutcome(foundChips);
    }

    /**
     * Performs a search using the number given by the user that indicates the 
     * damage the resulting chips should deal. If a chip lists a damage value 
     * that matches the input, it will appear within the resulting list. The 
     * list is then presented to the user.
     *
     * @param keyboard The {@link Scanner} that is reading the user's input.
     * @see #printOutcome(List) 
     */
    private void beginDamageSearch(Scanner keyboard) {
        simplePrint("Please enter the damage dealt by the desired chip.");
        int input = keyboard.nextInt();
        List<Chip> foundChip = reader.searchChipsByDamage(input);
        printOutcome(foundChip);
    }

    /**
     * Performs a search using the letter given by the user against the codes 
     * available for each chip. If a chip can have that letter, it will appear 
     * within the resulting list. The list is then presented to the user.
     *
     * @param keyboard The {@link Scanner} that is reading the user's input.
     * @see #printCodeOutcome(List, String) 
     */
    private void beginCodeSearch(Scanner keyboard) {
        simplePrint("Please enter the letter you wish the desired chip to be, or *.");
        String input = keyboard.next();
        List<Chip> foundChips = reader.searchChipsByCode(input);
        printCodeOutcome(foundChips, input);
    }

    /**
     * Prints the results from a search on codes available for their chip. If 
     * any of the codes available for the chip include the input, it will appear
     * within the resulting list.
     *
     * @param foundChips The resulting {@link List} of {@link Chip} entries that
     *                   matched the search criteria, if any were found.
     * @param input The {@link String} inputted by the user.
     * @see Chip#print()
     */
    private void printCodeOutcome(List<Chip> foundChips, String input) {
        if (StringUtils.equals(input, "*")) {
            simplePrint("Here's the chips that can be a * code!");
        } else {
            simplePrint("Here's the chips that can have that code!");
        }
        foundChips.forEach(Chip::print);
    }

    /**
     * Performs a search using the number given by the user against the memory 
     * sizes as they're listed on their respective chip. The results are printed
     * out to the user.
     *
     * @param keyboard The {@link Scanner} that is reading the user's input.
     * @see #printMemoryOutcome(List) 
     */
    private void beginMemorySizeSearch(Scanner keyboard) {
        simplePrint("Please enter the memory size of the desired chip.");
        int input = keyboard.nextInt();
        List<Chip> foundChip = reader.searchChipsByMemorySize(input);
        printMemoryOutcome(foundChip);
    }

    /**
     * Prints the results from a search on memory size.
     *
     * @param foundChips The resulting {@link List} of {@link Chip} entries that
     *                   matched the search criteria, if any were found.
     * @see Chip#print()
     */
    private void printMemoryOutcome(List<Chip> foundChips) {
        if (!foundChips.isEmpty()) {
            simplePrint("Here are the chips that match that memory size!");
            foundChips.forEach(Chip::print);
        } else {
            simplePrint(failedSearchString());
        }
    }

}