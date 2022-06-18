package systems.lookups;

import interfaces.Subsystem;
import systems.subroutines.CodeListSubroutine;
import systems.utility.readers.CodeFileReader;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static systems.utility.Helpers.print;

public class CodeLookup implements Subsystem {

    private CodeFileReader reader;

    public CodeLookup() {
        bootSequence();
    }

    private void bootSequence() {
        try {
            reader = new CodeFileReader();
            print("Code lookup booted.");
        } catch (IOException ex) {
            print("Error encountered while booting Code Lookup.");
            print(ex.getMessage());
        }
    }

    @Override
    public void printOptions() {
        print(System.lineSeparator());
        print("""
        Please select an option
        1) List Codes
        2) Search Codes
        3) Return to main menu
        """);
    }

    @Override
    public void processInput(int input, Scanner keyboard) {
        switch(input) {
            case 1 -> beginListingSubroutine(keyboard);
            case 2 -> beginSearchSubroutine(keyboard);
            case 3 -> print("Returning to main menu...\n");
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
        printSearchOptions();
        boolean continueSubRoutine = true;
        while (continueSubRoutine) {
            try {
                int input = keyboard.nextInt();
                //TODO Implement changeover to list subroutine
                if (input == 5) {
                    continueSubRoutine = false;
                    print("Returning to previous menu");
                }
            } catch (InputMismatchException ex) {
                keyboard.next();
            }
        }
    }

    private void printSearchOptions() {
        print(System.lineSeparator());
        print("""
        1) Search Extra Codes (ExCodes)
        2) Search Error Codes
        3) Search Compression Codes
        4) Switch to list mode
        5) Return to previous menu
        """);
    }

    private void beginExtraCodeSearch(Scanner keyboard) {
        //TODO Implement additional options and search
    }

    private void beginErrorCodeSearch(Scanner keyboard) {
        //TODO Implement additional options and search
    }

    private void beginCompressionCodeSearch(Scanner keyboard) {
        //TODO Implement additional options and search
    }

}