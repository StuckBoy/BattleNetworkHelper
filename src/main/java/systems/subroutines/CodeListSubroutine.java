package systems.subroutines;

import interfaces.Subroutine;
import systems.utility.readers.CodeFileReader;

import static systems.utility.Helpers.*;

public class CodeListSubroutine implements Subroutine {

    private final CodeFileReader reader;

    public CodeListSubroutine(CodeFileReader reader) {
        this.reader = reader;
        print("Code list subroutine started.");
    }

    @Override
    public void printOptions() {
        print(System.lineSeparator());
        print("""
        Please select a listing option
        1) List Extra Codes (ExCodes)
        2) List Error Codes
        3) List Compression Codes
        4) Switch to search mode
        5) Return to previous menu
        """);
    }

    @Override
    public void processInput(int input) {
        switch(input) {
            case 1 -> listExtraCodes();
            case 2 -> listErrorCodes();
            case 3 -> listCompressionCodes();
            case 4 -> print("Not currently supported. :(");
            case 5 -> print("Returning to previous menu...");
        }
    }

    public void listExtraCodes() {
        printExtraCodes(reader.getExCodes());
    }

    private void listErrorCodes() {
        printErrorCodes(reader.getErrorCodes());
    }

    private void listCompressionCodes() {
        printCompressionCodes(reader.getCompressionCodes());
    }

}