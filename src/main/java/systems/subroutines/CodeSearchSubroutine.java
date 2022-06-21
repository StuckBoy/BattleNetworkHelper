package systems.subroutines;

import interfaces.subroutines.SearchSubroutine;
import pojos.navicust.CompressionCode;
import pojos.navicust.ErrorCode;
import pojos.navicust.ExCode;
import systems.utility.readers.CodeFileReader;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static systems.utility.Helpers.simplePrint;

public class CodeSearchSubroutine implements SearchSubroutine {

    private final CodeFileReader reader;

    public CodeSearchSubroutine(CodeFileReader reader) {
        this.reader = reader;
    }

    @Override
    public void printOptions() {
        simplePrint(System.lineSeparator());
        simplePrint("""
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
        simplePrint(System.lineSeparator());
        simplePrint("""
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
            case 3 -> simplePrint("Returning to previous menu...");
        }
    }

    private void beginEffectSearch(Scanner keyboard) {
        simplePrint("Please enter the desired effect.");
        String input = keyboard.next();
        List<ExCode> foundExCodes = reader.searchExCodesByEffect(input);
        printExOutcome(foundExCodes);
    }

    private void printExOutcome(List<ExCode> foundExCodes) {
        if (!foundExCodes.isEmpty()) {
            simplePrint("Here's your ExCodes:");
            foundExCodes.forEach(ExCode::print);
        } else {
            simplePrint("Sorry, couldn't find any ExCodes that match your input.");
        }
    }

    private void beginGlitchSearch(Scanner keyboard) {
        simplePrint("Please input the glitch associated with the ExCode.");
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
        simplePrint(System.lineSeparator());
        simplePrint("""
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
            case 4 -> simplePrint("Returning to previous menu...");
        }
    }

    private void beginProgramSearch(Scanner keyboard) {
        simplePrint("Please enter the Program associated with the Error Code.");
        String input = keyboard.next();
        List<ErrorCode> foundErrorCodes = reader.searchErrorCodesByProgram(input);
        printErrorOutcome(foundErrorCodes);
    }

    private void printErrorOutcome(List<ErrorCode> foundErrorCodes) {
        if (!foundErrorCodes.isEmpty()) {
            simplePrint("Here's your Error Codes:");
            foundErrorCodes.forEach(ErrorCode::print);
        } else {
            simplePrint("Sorry, couldn't find any Error Codes that match your input.");
        }
    }

    private void beginStyleSearch(Scanner keyboard) {
        simplePrint("Please enter the Style associated with the Error Code.");
        String input = keyboard.next();
        List<ErrorCode> foundErrorCodes = reader.searchErrorCodesByStyle(input);
        printErrorOutcome(foundErrorCodes);
    }

    private void beginErrorNumberSearch(Scanner keyboard) {
        simplePrint("Please enter the Error Number associated with the Error Code.");
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
        simplePrint(System.lineSeparator());
        simplePrint("""
        Please select an option.
        1) Search by Program being compressed
        2) Return to previous menu
        """);
    }

    private void processCompressionCodeSearchInput(int input, Scanner keyboard) {
        switch (input) {
            case 1 -> beginCompressionProgramSearch(keyboard);
            case 2 -> simplePrint("Returning to main menu.");
        }
    }

    private void beginCompressionProgramSearch(Scanner keyboard) {
        simplePrint("Please enter the name of the Program to be compressed.");
        String input = keyboard.next();
        List<CompressionCode> foundCompressionCodes = reader.searchCompressionCodesByProgram(input);
        printCompressionOutcome(foundCompressionCodes);
    }

    private void printCompressionOutcome(List<CompressionCode> foundCompressionCodes) {
        if (!foundCompressionCodes.isEmpty()) {
            simplePrint("Here's your Compression Codes:");
            foundCompressionCodes.forEach(CompressionCode::print);
        } else {
            simplePrint("Sorry, couldn't find any Compression Codes that match your input.");
        }
    }
}