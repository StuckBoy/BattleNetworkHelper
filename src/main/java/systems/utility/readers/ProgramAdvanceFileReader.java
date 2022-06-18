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
    private final List<ProgramAdvance> bnThreeProgramAdvanceList;
    private final List<ProgramAdvance> bnSixProgramAdvanceList;

    public ProgramAdvanceFileReader() throws IOException {
        //TODO Implement support for remaining BN games.
        Reader bnThreeReader = prepareReader(PathConstants.bnThreeProgramAdvanceLibrary);
        Reader bnSixReader = prepareReader(PathConstants.bnSixProgramAdvanceLibrary);
        Gson gson = new Gson();
        bnThreeProgramAdvanceList = prepareList(bnThreeReader, gson);
        bnSixProgramAdvanceList = prepareList(bnSixReader, gson);
        outputStats();
    }

    private Reader prepareReader(String filePath) throws IOException {
        return Files.newBufferedReader(Paths.get(filePath));
    }

    private List<ProgramAdvance> prepareList(Reader reader, Gson gson) {
        return gson.fromJson(reader, new TypeToken<List<ProgramAdvance>>() {}.getType());
    }

    private void outputStats() {
        int bnThreeListSize = bnThreeProgramAdvanceList.size();
        print("Loaded " + bnThreeListSize + " BN3 Program Advances.");
        int bnSixListSize = bnSixProgramAdvanceList.size();
        print("Loaded " + bnSixListSize + " BN6 Program Advances.");
        int programAdvanceCount = bnThreeListSize + bnSixListSize;
        print("Loading finished. Total count: " + programAdvanceCount);
    }

    public List<ProgramAdvance> searchPAsByName(String name) {
        //TODO Implement
        return new ArrayList<>();
    }
}