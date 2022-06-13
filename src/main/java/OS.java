import systems.lookups.ChipLookup;
import systems.utility.Helpers;

import java.util.InputMismatchException;
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
     * @see #bootSequence()
     * @see #listCommands()
     * @see #bootChipLookup()
     * @see #exitHelper()
     */
    public static void main(String[] args) {
        bootSequence();
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
                    //TODO Implement P.A. Lookup
                    break;
                case 3:
                    //TODO Implement Folder Building
                    break;
                case 4:
                    //TODO Implement Code Lookup
                    break;
                case 5:
                    programInUse = false;
                    break;
                default:
                    //Input not valid, reset the scanner for next attempt.
                    keyboard.next();
            }
        }
        exitHelper();
    }

    /**
     * Prints initial text on first launch.
     * @see Helpers#print(String)
     * @see #startupLogo()
     */
    private static void bootSequence() {
        print(System.lineSeparator());
        print(startupLogo());
        print("Greetings! What do you need?" + System.lineSeparator());
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
     * @return A {@link String} of the top-most menu's options.
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

    /**
     * Initializes the {@link ChipLookup}.
     */
    private static void bootChipLookup() {
        ChipLookup lookup = new ChipLookup();
        boolean continueProcess = true;
        while (continueProcess) {
            lookup.printOptions();
            try {
                int input = keyboard.nextInt();
                lookup.processInput(input, keyboard);
                if (input == 6) {
                    continueProcess = false;
                }
            } catch (InputMismatchException ex) {
                keyboard.next();
            }
        }
    }

    /**
     * Prints a goodbye and returns 0 to the system.
     */
    private static void exitHelper() {
        print("See you later!");
        System.exit(0);
    }

}