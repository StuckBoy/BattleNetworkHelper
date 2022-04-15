package systems.utility;

import pojos.Chip;

public class Helpers {

    /**
     * Simplifies calls to {@link System} for printing.
     * @param s The complete {@link String} to be printed.
     */
    public static void print(String s) {
        System.out.println(s);
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
    public static void prettyPrint(Chip chip) {
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
}