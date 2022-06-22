import pojos.UserConfig;
import systems.lookups.ChipLookup;
import systems.lookups.CodeLookup;
import systems.lookups.ProgramAdvanceLookup;
import systems.utility.Helpers;

import java.util.InputMismatchException;
import java.util.Scanner;

import static systems.utility.Helpers.simplePrint;

public class OS {

    private static UserConfig config;

    /**
     * The {@link Scanner} to allow input from the user.
     */
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
     * @see #bootPALookup()
     * @see #bootFolderBuilder()
     * @see #bootCodeLookup()
     * @see #exitHelper()
     */
    public static void main(String[] args) {
        bootSequence();
        keyboard = new Scanner(System.in);
        boolean programInUse = true;
        while(programInUse) {
            simplePrint(listCommands());
            int input;
            try {
                input = keyboard.nextInt();
            } catch (InputMismatchException ex) {
                //TODO Implement specific error message.
                simplePrint("Input not valid, please try again.");
                input = -1;
            }
            switch (input) {
                case 1 -> bootChipLookup();
                case 2 -> bootPALookup();
                case 3 -> bootFolderBuilder();
                case 4 -> bootCodeLookup();
                case 5 -> bootConfiguration();
                case 6 -> programInUse = false;
                default -> keyboard.next(); //Resets scanner for next input
            }
        }
        exitHelper();
    }

    /**
     * Prints initial text on first launch.
     * @see Helpers#simplePrint(String)
     * @see #startupLogo()
     */
    private static void bootSequence() {
        simplePrint(System.lineSeparator());
        simplePrint(startupLogo());
        simplePrint("Greetings! What do you need?" + System.lineSeparator());
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
        5) Edit Config
        6) Exit
        
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
     * Initializes the {@link ProgramAdvanceLookup}
     */
    private static void bootPALookup() {
        ProgramAdvanceLookup lookup = new ProgramAdvanceLookup();
        boolean continueProcess = true;
        while (continueProcess) {
            lookup.printOptions();
            try {
                int input = keyboard.nextInt();
                lookup.processInput(input, keyboard);
                if (input == 4) {
                    continueProcess = false;
                }
            } catch (InputMismatchException ex) {
                keyboard.next();
            }
        }
    }

    /**
     * TODO
     */
    private static void bootFolderBuilder() {
        //TODO Implement
    }

    /**
     * Initializes the {@link CodeLookup}
     */
    private static void bootCodeLookup() {
        CodeLookup lookup = new CodeLookup();
        boolean continueProcess = true;
        while (continueProcess) {
            lookup.printOptions();
            try {
                int input = keyboard.nextInt();
                lookup.processInput(input, keyboard);
                if (input == 7) {
                    continueProcess = false;
                }
            } catch (InputMismatchException ex) {
                keyboard.next();
            }
        }
    }

    /**
     * Initializes the configuration menu to edit settings such as which game's
     * data to load.
     */
    private static void bootConfiguration() {

    }

    /**
     * Prints a goodbye and returns 0 to the system.
     */
    private static void exitHelper() {
        simplePrint("See you later!");
        System.exit(0);
    }
}