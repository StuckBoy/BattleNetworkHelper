package systems.lookups;

import interfaces.Subsystem;
import systems.utility.readers.CodeFileReader;

import java.io.IOException;
import java.util.Scanner;

import static systems.utility.Helpers.*;

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
        1) List Extra Codes (ExCodes)
        2) Search Extra Codes (ExCodes)
        3) List Error Codes
        4) Search Error Codes
        5) List compression Codes
        6) Search Compression Codes
        7) Return to main menu
        """);
    }

    @Override
    public void processInput(int input, Scanner keyboard) {
        switch (input) {
            case 1 -> beginListingExtraCodes();
            case 2 -> beginExtraCodeSearch(keyboard);
            case 3 -> beginListingErrorCodes();
            case 4 -> beginErrorCodeSearch(keyboard);
            case 5 -> beginListingCompressionCodes();
            case 6 -> beginCompressionCodeSearch(keyboard);
            case 7 -> print("Returning to main menu...\n");
            default -> print("Unusable input, please try again.");
        }
    }

    private void beginListingExtraCodes() {
        prettyPrintExtraCodes(reader.getExCodes());
    }

    private void beginExtraCodeSearch(Scanner keyboard) {
        //TODO Implement additional options and search
    }

    private void beginListingErrorCodes() {
        prettyPrintErrorCodes(reader.getErrorCodes());
    }

    private void beginErrorCodeSearch(Scanner keyboard) {
        //TODO Implement additional options and search
    }

    private void beginListingCompressionCodes() {
        prettyPrintCompressionCodes(reader.getCompressionCodes());
    }

    private void beginCompressionCodeSearch(Scanner keyboard) {
        //TODO Implement additional options and search
    }

}