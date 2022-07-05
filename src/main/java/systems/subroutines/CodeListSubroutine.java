package systems.subroutines;

import interfaces.subroutines.ListSubroutine;
import pojos.navicust.CompressionCode;
import pojos.navicust.ErrorCode;
import pojos.navicust.ExCode;
import systems.utility.Helpers;
import systems.utility.readers.CodeFileReader;

import static systems.utility.Helpers.simplePrint;

import java.util.ArrayList;
import java.util.List;

public class CodeListSubroutine implements ListSubroutine {

    private final CodeFileReader reader;

    public CodeListSubroutine(CodeFileReader reader) {
        this.reader = reader;
        simplePrint("Code list subroutine started.");
    }

    @Override
    public void printOptions() {
        simplePrint(System.lineSeparator());
        List<String> options = new ArrayList<>();
        options.add("List Extra Codes (ExCodes)");
        options.add("List Error Codes");
        options.add("List Compression Codes");
        options.add("Switch to search mode");
        options.add("Return to previous menu");
        Helpers.printOptions(options);
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