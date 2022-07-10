package systems.lookups;

import constants.Game;
import exceptions.UnsupportedGameException;
import interfaces.Subsystem;
import systems.subroutines.CodeListSubroutine;
import systems.subroutines.CodeSearchSubroutine;
import systems.utility.Helpers;
import systems.utility.readers.CodeFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static systems.utility.Helpers.simplePrint;

public class CodeLookup implements Subsystem {

    private CodeFileReader reader;
    private final Game currentGame;

    public CodeLookup(Game currentGame) throws UnsupportedGameException, IOException {
        this.currentGame = currentGame;
        bootSequence();
    }

    private void bootSequence() throws UnsupportedGameException, IOException {
        try {
            reader = new CodeFileReader(currentGame);
            simplePrint("Code lookup booted.");
        } catch (IOException | UnsupportedGameException ex) {
            simplePrint("Error encountered while booting Code Lookup.");
            simplePrint(ex.getMessage() + System.lineSeparator());
            throw ex;
        }
    }

    @Override
    public void printOptions() {
        List<String> options = new ArrayList<>();
        options.add("List Codes");
        options.add("Search Codes");
        options.add("Return to main menu");
        Helpers.printOptions(options);
    }

    @Override
    public void processInput(int input, Scanner keyboard) {
        switch(input) {
            case 1 -> beginListingSubroutine(keyboard);
            case 2 -> beginSearchSubroutine(keyboard);
            case 3 -> simplePrint("Returning to main menu...\n");
        }
    }

    private void beginListingSubroutine(Scanner keyboard) {
        CodeListSubroutine subroutine = new CodeListSubroutine(reader);
        boolean continueSubRoutine = true;
        while (continueSubRoutine) {
            subroutine.printOptions();
            try {
                int input = keyboard.nextInt();
                subroutine.processInput(input);
                //TODO Implement changeover to search subroutine
                if (input == 5) {
                    continueSubRoutine = false;
                }
            } catch (InputMismatchException ex) {
                keyboard.next();
            }
        }
    }

    private void beginSearchSubroutine(Scanner keyboard) {
        CodeSearchSubroutine subroutine = new CodeSearchSubroutine(reader);
        boolean continueSubRoutine = true;
        while (continueSubRoutine) {
            try {
                subroutine.printOptions();
                int input = keyboard.nextInt();
                subroutine.processInput(input, keyboard);
                //TODO Implement changeover to list subroutine
                if (input == 5) {
                    continueSubRoutine = false;
                    simplePrint("Returning to previous menu");
                }
            } catch (InputMismatchException ex) {
                keyboard.next();
            }
        }
    }

}