package systems.subroutines;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import constants.Game;
import interfaces.subroutines.Subroutine;
import pojos.UserConfig;
import systems.utility.Helpers;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static systems.utility.Helpers.errorPrint;
import static systems.utility.Helpers.getAbsoluteConfigPath;
import static systems.utility.Helpers.simplePrint;

public class ConfigEditSubroutine implements Subroutine {

    private UserConfig config;
    private final Scanner keyboard;

    public ConfigEditSubroutine(Scanner keyboard, UserConfig config) {
        this.keyboard = keyboard;
        this.config = config;
    }

    @Override
    public void printOptions() {
        List<String> options = new ArrayList<>();
        options.add("Change username");
        options.add("Change current game");
        options.add("Exit Config editing");
        Helpers.printOptions(options);
    }

    public void processInput(int input) {
        switch (input) {
            case 1 -> beginNameChange();
            case 2 -> beginGameChange();
            case 3 -> simplePrint("Returning to main menu...");
            default -> simplePrint("Unrecognized input, please try again.");
        }
    }

    private void beginNameChange() {
        simplePrint("Please input the username you wish to go by.");
        String input = keyboard.next();
        simplePrint("Got it, you're now " + input);
        config.setUsername(input);
        outputChangeToFile();
    }

    private void outputChangeToFile() {
        String absoluteConfigPath = getAbsoluteConfigPath();
        Gson gson = new Gson();
        try {
            FileWriter writer = new FileWriter(absoluteConfigPath);
            gson.toJson(config, writer);
            writer.close();
        } catch (IOException e) {
            errorPrint("An error occurred while trying to update the user config. Please check it was properly created.");
        }
        //Reload the config to ensure it's up-to-date.
        try {
            Path configPath = Paths.get(absoluteConfigPath);
            InputStream inputStream = Files.newInputStream(configPath);
            Reader reader = new InputStreamReader(inputStream);
            config = gson.fromJson(reader, new TypeToken<UserConfig>() {}.getType());
        } catch (IOException ex) {
            errorPrint("An error occurred while trying to read the user config.");
        }
    }

    private void beginGameChange() {
        int input = -1;
        while (input == -1) {
            simplePrint("Please input the number of the game.");
            try {
                input = keyboard.nextInt();
                if (input < 1 || input > 6) {
                    input = -1;
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException ex) {
                simplePrint("Please only input a number.");
                keyboard.next();
            }
        }
        Game newGame = null;
        switch (input) {
            case 1 -> newGame = Game.BN1;
            case 2 -> newGame = Game.BN2;
            case 3 -> newGame = Game.BN3;
            case 4 -> newGame = Game.BN4;
            case 5 -> newGame = Game.BN5;
            case 6 -> newGame = Game.BN6;
        }
        simplePrint("Switching game to " + newGame);
        config.setCurrentGame(newGame);
        outputChangeToFile();
    }
}