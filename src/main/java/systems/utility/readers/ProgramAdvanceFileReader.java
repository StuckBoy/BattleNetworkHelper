package systems.utility.readers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import constants.PathConstants;
import org.apache.commons.lang3.StringUtils;
import pojos.ProgramAdvance;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import static systems.utility.Helpers.simplePrint;

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

    private Reader prepareReader(String filePath) {
        InputStream input = getClass().getResourceAsStream(filePath);
        assert input != null;
        return new InputStreamReader(input);
    }

    private List<ProgramAdvance> prepareList(Reader reader, Gson gson) {
        return gson.fromJson(reader, new TypeToken<List<ProgramAdvance>>() {}.getType());
    }

    private void outputStats() {
        int bnThreeListSize = bnThreeProgramAdvanceList.size();
        simplePrint("Loaded " + bnThreeListSize + " BN3 Program Advances.");
        int bnSixListSize = bnSixProgramAdvanceList.size();
        simplePrint("Loaded " + bnSixListSize + " BN6 Program Advances.");
        int programAdvanceCount = bnThreeListSize + bnSixListSize;
        simplePrint("Loading finished. Total count: " + programAdvanceCount);
    }

    public List<ProgramAdvance> searchPAsByName(String name) {
        List<ProgramAdvance> foundPAs = new ArrayList<>();
        for (ProgramAdvance programAdvance : bnThreeProgramAdvanceList) {
            if (StringUtils.contains(programAdvance.getName(), name)) {
                foundPAs.add(programAdvance);
            }
        }
        return foundPAs;
    }
}