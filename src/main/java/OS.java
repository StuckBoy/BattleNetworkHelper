import systems.lookups.ChipLookup;
import systems.utility.Helpers;

import java.util.Scanner;

import static systems.utility.Helpers.print;

public class OS {
    private static Scanner keyboard;

    /**
     * The main process for the application. Input is read as simply as
     * possible.
     *
     * @param args An array of {@link String} arguments to provide. In its
     * current state, any arguments, if provided, will not be used.
     * @see Helpers#print(String)
     * @see #startupLogo()
     * @see #listCommands()
     * @see #bootChipLookup()
     * @see #exitHelper()
     */
    public static void main(String[] args) {
        print(System.lineSeparator());
        print(startupLogo());
        print("Greetings! What do you need?" + System.lineSeparator());
        keyboard = new Scanner(System.in);
        boolean programInUse = true;
        while(programInUse) {
            print(listCommands());
            int input = keyboard.nextInt();
            switch (input) {
                case 1:
                    bootChipLookup();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    programInUse = false;
                    break;
                default:
            }
        }
        exitHelper();
    }

    /**
     * Provides a logo in ASCII.
     *
     * @return a formatted {@link String} containing the program logo as ASCII.
     */
    private static String startupLogo() {
        return """
██████╗ ███╗   ██╗    ██╗  ██╗███████╗██╗     ██████╗ ███████╗██████╗ 
██╔══██╗████╗  ██║    ██║  ██║██╔════╝██║     ██╔══██╗██╔════╝██╔══██╗
██████╔╝██╔██╗ ██║    ███████║█████╗  ██║     ██████╔╝█████╗  ██████╔╝
██╔══██╗██║╚██╗██║    ██╔══██║██╔══╝  ██║     ██╔═══╝ ██╔══╝  ██╔══██╗
██████╔╝██║ ╚████║    ██║  ██║███████╗███████╗██║     ███████╗██║  ██║
╚═════╝ ╚═╝  ╚═══╝    ╚═╝  ╚═╝╚══════╝╚══════╝╚═╝     ╚══════╝╚═╝  ╚═╝
        """;
    }

    /**
     * The main options offered for the BNH.
     * @return A string of the top-most menu's options.
     */
    private static String listCommands() {
        return """
        =========
        Main Menu
        =========
        1) Chip Lookup
        2) P.A. Lookup
        3) Folder Builder
        4) Code Lookup
        5) Exit
        
        Please select an option...
        """;
    }

    private static void bootChipLookup() {
        ChipLookup lookup = new ChipLookup();
        while (true) {
            lookup.printOptions();
            int input = keyboard.nextInt();
            lookup.processInput(input, keyboard);
            if (input == 6) {
                return;
            }
        }
    }

    private static void exitHelper() {
        print("See you later!");
        System.exit(0);
    }

    public static Scanner getKeyboard() {
        return keyboard;
    }
}