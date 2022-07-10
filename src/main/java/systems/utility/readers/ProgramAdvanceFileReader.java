package systems.utility.readers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import constants.Game;
import constants.PathConstants;
import exceptions.UnsupportedGameException;
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
    private final List<ProgramAdvance> programAdvanceList;

    public ProgramAdvanceFileReader(Game currentGame) throws IOException, UnsupportedGameException {
        Reader gameReader;
        switch (currentGame) {
            case BN3 -> gameReader = prepareReader(PathConstants.bnThreeProgramAdvanceLibrary);
            case BN6 -> gameReader = prepareReader(PathConstants.bnSixProgramAdvanceLibrary);
            default -> throw new UnsupportedGameException("P.A. lookup not yet supported for current game.");
        }
        Gson gson = new Gson();
        programAdvanceList = prepareList(gameReader, gson);
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
        int programAdvanceCount = programAdvanceList.size();
        simplePrint("Loading finished. Total count: " + programAdvanceCount);
    }

    public List<ProgramAdvance> searchPAsByName(String name) {
        List<ProgramAdvance> foundPAs = new ArrayList<>();
        for (ProgramAdvance programAdvance : programAdvanceList) {
            if (StringUtils.containsIgnoreCase(programAdvance.getName(), name)) {
                foundPAs.add(programAdvance);
            }
        }
        return foundPAs;
    }

    public List<ProgramAdvance> searchPAsByDamage(int input) {
        List<ProgramAdvance> foundPAs = new ArrayList<>();
        for (ProgramAdvance programAdvance : programAdvanceList) {
            if (programAdvance.getDamage() == input) {
                foundPAs.add(programAdvance);
            }
        }
        return foundPAs;
    }

    public List<ProgramAdvance> searchPAsByChipUsed(String input) {
        List<ProgramAdvance> foundPAs = new ArrayList<>();
        for (ProgramAdvance programAdvance : programAdvanceList) {
            for (List<String> combo : programAdvance.getCombos()) {
                for (String chip : combo) {
                    if (StringUtils.containsIgnoreCase(chip, input)) {
                        foundPAs.add(programAdvance);
                    }
                }
            }
        }
        return foundPAs;
    }
}