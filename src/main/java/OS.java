import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import constants.Game;
import constants.PathConstants;
import pojos.UserConfig;
import systems.lookups.ChipLookup;
import systems.lookups.CodeLookup;
import systems.lookups.ProgramAdvanceLookup;
import systems.utility.Helpers;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static systems.utility.Helpers.printOptions;
import static systems.utility.Helpers.errorPrint;
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
     * @see #loadUserConfig()
     * @see #bootSequence()
     * @see #listCommands()
     * @see #bootChipLookup()
     * @see #bootPALookup()
     * @see #bootFolderBuilder()
     * @see #bootCodeLookup()
     * @see #exitHelper()
     */
    public static void main(String[] args) {
        config = loadUserConfig();
        bootSequence();
        keyboard = new Scanner(System.in);
        boolean programInUse = true;
        while(programInUse) {
            listCommands();
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
     * Loads the user config to reduce unnecessary loading in the app.
     * @return The {@link UserConfig} with previous settings, or default if one
     * did not already exist.
     */
    private static UserConfig loadUserConfig() {
        UserConfig config = new UserConfig(Game.BN1);
        String absolutePath = System.getProperty("user.dir");
        String absoluteConfigPath = absolutePath + PathConstants.userConfigPath;
        Path configPath = Paths.get(absoluteConfigPath);
        InputStream inputStream = null;
        try {
            inputStream = Files.newInputStream(configPath);
        } catch (IOException ex) {
            //We'll need to create the directory, file, or both, that comes next
        }
        Gson gson = new Gson();
        if (inputStream == null) {
            try {
                //Make sure the directory exists
                File file = new File(absoluteConfigPath);
                if (file.getParentFile().mkdir()) {
                    if (file.createNewFile()) {
                        //Make sure the default file exists.
                        FileWriter writer = new FileWriter(absoluteConfigPath);
                        //Set default data to JSON file.
                        gson.toJson(config, writer);
                        writer.close();
                        inputStream = Files.newInputStream(configPath);
                    } else {
                        throw new IOException("Unable to create config file.");
                    }
                } else {
                    throw new IOException("Unable to create directory for config file.");
                }
            } catch (SecurityException ex) {
                errorPrint("Permission to write to path denied.");
            } catch (FileAlreadyExistsException ex) {
                errorPrint("An error occurred while creating the default config, one was already present?");
            } catch (IOException ex) {
                errorPrint("An issue occurred while setting up the user config.");
            } catch (JsonIOException ex) {
                errorPrint("An error occurred while creating the default JSON file.");
            }
        }
        Reader reader = new InputStreamReader(inputStream);
        config = gson.fromJson(reader, new TypeToken<UserConfig>() {}.getType());
        return config;
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
     * Prints the main options offered for the BNH.
     */
    private static void listCommands() {
        List<String> commandList = new ArrayList<>();
        commandList.add("Chip Lookup");
        commandList.add("P.A. Lookup");
        commandList.add("Folder Builder");
        commandList.add("Code Lookup");
        commandList.add("Edit Config");
        commandList.add("Exit");
        printOptions(commandList);
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
