package systems.subroutines;

import interfaces.subroutines.ListSubroutine;
import pojos.CompressionCode;
import pojos.ErrorCode;
import pojos.ExCode;
import systems.utility.readers.CodeFileReader;

import static systems.utility.Helpers.simplePrint;

public class CodeListSubroutine implements ListSubroutine {

    private final CodeFileReader reader;

    public CodeListSubroutine(CodeFileReader reader) {
        this.reader = reader;
        simplePrint("Code list subroutine started.");
    }

    @Override
    public void printOptions() {
        simplePrint(System.lineSeparator());
        simplePrint("""
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
            case 4 -> simplePrint("Not currently supported. :(");
            case 5 -> simplePrint("Returning to previous menu...");
        }
    }

    public void listExtraCodes() {
        reader.getExCodes().forEach(ExCode::print);
    }

    private void listErrorCodes() {
        reader.getErrorCodes().forEach(ErrorCode::print);
    }

    private void listCompressionCodes() {
        reader.getCompressionCodes().forEach(CompressionCode::print);
    }

}