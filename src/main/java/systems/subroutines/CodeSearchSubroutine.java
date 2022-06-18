package systems.subroutines;

import interfaces.subroutines.SearchSubroutine;
import pojos.CompressionCode;
import pojos.ErrorCode;
import pojos.ExCode;
import systems.utility.readers.CodeFileReader;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static systems.utility.Helpers.*;

public class CodeSearchSubroutine implements SearchSubroutine {

    private final CodeFileReader reader;

    public CodeSearchSubroutine(CodeFileReader reader) {
        this.reader = reader;
    }

    @Override
    public void printOptions() {
        print(System.lineSeparator());
        print("""
        1) Search Extra Codes (ExCodes)
        2) Search Error Codes
        3) Search Compression Codes
        4) Switch to list mode
        5) Return to previous menu
        """);
    }

    @Override
    public void processInput(int input, Scanner keyboard) {
        switch (input) {
            case 1 -> searchExtraCodes(keyboard);
            case 2 -> searchErrorCodes(keyboard);
            case 3 -> searchCompressionCodes(keyboard);
        }
    }

    private void searchExtraCodes(Scanner keyboard) {
        //TODO Implement additional options and search
        boolean continueSearch = true;
        while (continueSearch) {
            printExtraCodeSearchOptions();
            try {
                int input = keyboard.nextInt();
                processExtraCodeSearchInput(input, keyboard);
                if (input == 3) {
                    continueSearch = false;
                }
            } catch (InputMismatchException ex) {
                keyboard.next();
            }
        }
    }

    private void printExtraCodeSearchOptions() {
        print(System.lineSeparator());
        print("""
        Please select an option.
        1) Search by effect
        2) Search by glitch
        3) Return to previous menu
        """);
    }

    private void processExtraCodeSearchInput(int input, Scanner keyboard) {
        switch (input) {
            case 1 -> beginEffectSearch(keyboard);
            case 2 -> beginGlitchSearch(keyboard);
            case 3 -> print("Returning to previous menu...");
        }
    }

    private void beginEffectSearch(Scanner keyboard) {
        print("Please enter the desired effect.");
        String input = keyboard.next();
        List<ExCode> foundExCodes = reader.searchExCodesByEffect(input);
        printExOutcome(foundExCodes);
    }

    private void printExOutcome(List<ExCode> foundExCodes) {
        if (!foundExCodes.isEmpty()) {
            print("Here's your ExCodes:");
            printExtraCodes(foundExCodes);
        } else {
            print("Sorry, couldn't find any ExCodes that match your input.");
        }
    }

    private void beginGlitchSearch(Scanner keyboard) {
        print("Please input the glitch associated with the ExCode.");
        String input = keyboard.next();
        List<ExCode> foundExCodes = reader.searchExCodesByGlitch(input);
        printExOutcome(foundExCodes);
    }

    private void searchErrorCodes(Scanner keyboard) {
        boolean continueSearch = true;
        while (continueSearch) {
            printErrorCodeSearchOptions();
            try {
                int input = keyboard.nextInt();
                processErrorCodeSearchInput(input, keyboard);
                if (input == 4) {
                    continueSearch = false;
                }
            } catch (InputMismatchException ex) {
                keyboard.next();
            }
        }
        printErrorCodeSearchOptions();
    }

    private void printErrorCodeSearchOptions() {
        print(System.lineSeparator());
        print("""
        Please select an option.
        1) Search by Program causing the error
        2) Search by Style associated with the error
        3) Search by Error Number
        4) Return to previous menu
        """);
    }

    private void processErrorCodeSearchInput(int input, Scanner keyboard) {
        switch (input) {
            case 1 -> beginProgramSearch(keyboard);
            case 2 -> beginStyleSearch(keyboard);
            case 3 -> beginErrorNumberSearch(keyboard);
            case 4 -> print("Returning to previous menu...");
        }
    }

    private void beginProgramSearch(Scanner keyboard) {
        print("Please enter the Program associated with the Error Code.");
        String input = keyboard.next();
        List<ErrorCode> foundErrorCodes = reader.searchErrorCodesByProgram(input);
        printErrorOutcome(foundErrorCodes);
    }

    private void printErrorOutcome(List<ErrorCode> foundErrorCodes) {
        if (!foundErrorCodes.isEmpty()) {
            print("Here's your Error Codes:");
            printErrorCodes(foundErrorCodes);
        } else {
            print("Sorry, couldn't find any Error Codes that match your input.");
        }
    }

    private void beginStyleSearch(Scanner keyboard) {
        print("Please enter the Style associated with the Error Code.");
        String input = keyboard.next();
        List<ErrorCode> foundErrorCodes = reader.searchErrorCodesByStyle(input);
        printErrorOutcome(foundErrorCodes);
    }

    private void beginErrorNumberSearch(Scanner keyboard) {
        print("Please enter the Error Number associated with the Error Code.");
        String input = keyboard.next();
        List<ErrorCode> foundErrorCodes = reader.searchErrorCodesByErrorNumber(input);
        printErrorOutcome(foundErrorCodes);
    }

    private void searchCompressionCodes(Scanner keyboard) {
        //TODO Implement additional options and search
        boolean continueSearch = true;
        while (continueSearch) {
            printCompressionCodeSearchOptions();
            try {
                int input = keyboard.nextInt();
                processCompressionCodeSearchInput(input, keyboard);
                if (input == 2) {
                    continueSearch = false;
                }
            } catch (InputMismatchException ex) {
                keyboard.next();
            }
        }
    }

    private void printCompressionCodeSearchOptions() {
        print(System.lineSeparator());
        print("""
        Please select an option.
        1) Search by Program being compressed
        2) Return to previous menu
        """);
    }

    private void processCompressionCodeSearchInput(int input, Scanner keyboard) {
        switch (input) {
            case 1 -> beginCompressionProgramSearch(keyboard);
            case 2 -> print("Returning to main menu.");
        }
    }

    private void beginCompressionProgramSearch(Scanner keyboard) {
        print("Please enter the name of the Program to be compressed.");
        String input = keyboard.next();
        List<CompressionCode> foundCompressionCodes = reader.searchCompressionCodesByProgram(input);
        printCompressionOutcome(foundCompressionCodes);
    }

    private void printCompressionOutcome(List<CompressionCode> foundCompressionCodes) {
        if (!foundCompressionCodes.isEmpty()) {
            print("Here's your Compression Codes:");
            printCompressionCodes(foundCompressionCodes);
        } else {
            print("Sorry, couldn't find any Compression Codes that match your input.");
        }
    }
}