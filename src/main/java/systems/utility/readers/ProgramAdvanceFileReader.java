package systems.utility.readers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import constants.PathConstants;
import pojos.ProgramAdvance;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static systems.utility.Helpers.print;

public class ProgramAdvanceFileReader {

    private final List<ProgramAdvance> bnThreeProgramAdvancelist;
    private final List<ProgramAdvance> bnSixProgramAdvancelist;

    public ProgramAdvanceFileReader() throws IOException {
        Gson gson = new Gson();
        //TODO Implement support for remaining BN games.
        Reader bnThreeReader = Files.newBufferedReader(Paths.get(PathConstants.bnThreeProgramAdvanceLibrary));
        Reader bnSixReader = Files.newBufferedReader(Paths.get(PathConstants.bnSixProgramAdvanceLibrary));
        bnThreeProgramAdvancelist = gson.fromJson(bnThreeReader, new TypeToken<List<ProgramAdvance>>() {}.getType());
        bnSixProgramAdvancelist = gson.fromJson(bnSixReader, new TypeToken<List<ProgramAdvance>>() {}.getType());
        int bnThreeListSize = bnThreeProgramAdvancelist.size();
        print("Loaded " + bnThreeListSize + " BN3 Program Advances.");
        int bnSixListSize = bnSixProgramAdvancelist.size();
        print("Loaded " + bnSixListSize + " BN6 Program Advances.");
        int programAdvanceCount = bnThreeListSize + bnSixListSize;
        print("Loading finished. Total count: " + programAdvanceCount);
    }

    public List<ProgramAdvance> searchPAsByName(String name) {
        //TODO Implement
        return new ArrayList<>();
    }
}