package systems.lookups;

import interfaces.Subsystem;
import systems.utility.ChipFileReader;

import java.io.IOException;
import java.util.Scanner;

import static systems.utility.Helpers.print;

public class ProgramAdvanceLookup implements Subsystem {

    private ChipFileReader reader;

    public ProgramAdvanceLookup() {
        bootSequence();
    }

    private void bootSequence() {
        try {
            reader = new ChipFileReader();
            print("P.A. Lookup booted.");
        } catch (IOException ex) {
            print("Error encountered while booting P.A. Lookup");
            print(ex.getMessage());
        }
    }

    @Override
    public void printOptions() {

    }

    @Override
    public void processInput(int input, Scanner keyboard) {

    }
}