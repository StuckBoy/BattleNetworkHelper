package systems.lookups;

import org.apache.commons.lang3.StringUtils;
import pojos.Chip;
import systems.utility.FileReader;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static systems.utility.Helpers.prettyPrint;
import static systems.utility.Helpers.print;

public class ChipLookup {

    private FileReader reader;

    public ChipLookup() {
        bootSequence();
    }

    /**
     * Prepares the {@link FileReader} to parse the data necessary for searches.
     */
    private void bootSequence() {
        try {
            reader = new FileReader();
            print("Chip lookup booted.");
        } catch (IOException ex) {
            print("Error encountered while booting Chip Lookup.");
            print(ex.getMessage());
        }
    }

    /**
     * Prints the list of available options to the user.
     */
    public void printOptions() {
        print("""
        \nPlease select an option \n
        1) Search by number
        2) Search by name
        3) Search by damage
        4) Search by code
        5) Search by memory size
        6) Return to main menu
        """);
    }

    /**
     * Process the input from the user, and chooses the appropriate search to
     * begin using.
     *
     * @param input The number inputted by the user.
     * @param keyboard The {@link Scanner} that is reading the user's input.
     * @see #beginNumberSearch(Scanner)
     * @see #beginNameSearch(Scanner)
     * @see #beginDamageSearch(Scanner)
     * @see #beginCodeSearch(Scanner)
     * @see #beginMemorySizeSearch(Scanner)
     */
    public void processInput(int input, Scanner keyboard) {
        switch (input) {
            case 1 -> beginNumberSearch(keyboard);
            case 2 -> beginNameSearch(keyboard);
            case 3 -> beginDamageSearch(keyboard);
            case 4 -> beginCodeSearch(keyboard);
            case 5 -> beginMemorySizeSearch(keyboard);
            case 6 -> print("Returning to main menu...\n");
            default -> {
                print("Unusable input, please try again.");
            }
        }
    }

    /**
     * Performs a search for chip(s) that have the matching number as inputted
     * by the user. The appropriate result is then printed out to the user.
     *
     * @param keyboard The {@link Scanner} that is reading the user's input.
     */
    private void beginNumberSearch(Scanner keyboard) {
        print("Please enter the number of the chip you wish to find.");
        int input = keyboard.nextInt();
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
            print(failedSearchString());
        }
    }

    /**
     * Prints the given {@link List} in a format that should be easily read by
     * the user.
     *
     * @param foundChips The {@link List} of {@link Chip} to be printed.
     * @see systems.utility.Helpers#prettyPrint(Chip)
     */
    private void printSuccessStrings(List<Chip> foundChips) {
        print("Here's your chip(s)!");
        for (Chip chip : foundChips) {
            prettyPrint(chip);
        }
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
        print("Please enter the name of the chip as it appears in-game.");
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
        print("Please enter the damage dealt by the desired chip.");
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
        print("Please enter the letter you wish the desired chip to be, or *.");
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
     */
    private void printCodeOutcome(List<Chip> foundChips, String input) {
        if (StringUtils.equals(input, "*")) {
            print("Here's the chips that can be a * code!");
        } else {
            print("Here's the chips that can have that code!");
        }
        for (Chip chip : foundChips) {
            prettyPrint(chip);
        }
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
        print("Please enter the memory size of the desired chip.");
        int input = keyboard.nextInt();
        List<Chip> foundChip = reader.searchChipsByMemorySize(input);
        printMemoryOutcome(foundChip);
    }

    /**
     * Prints the results from a search on memory size.
     *
     * @param foundChips The resulting {@link List} of {@link Chip} entries that
     *                   matched the search criteria, if any were found.
     */
    private void printMemoryOutcome(List<Chip> foundChips) {
        if (!foundChips.isEmpty()) {
            print("Here are the chips that match that memory size!");
            for (Chip chip : foundChips) {
                prettyPrint(chip);
            }
        } else {
            print(failedSearchString());
        }
    }

}