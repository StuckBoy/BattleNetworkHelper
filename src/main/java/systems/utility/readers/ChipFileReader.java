package systems.utility.readers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import constants.PathConstants;
import org.apache.commons.lang3.StringUtils;
import pojos.Chip;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import static systems.utility.Helpers.simplePrint;

public class ChipFileReader {
    private final List<Chip> standardChipList;
    private final List<Chip> megaChipList;
    private final List<Chip> gigaChipList;

    /**
     * Automatically prepares the file for reading using a {@link Reader}, and
     * parsing of the JSON file using {@link Gson}.
     *
     * @throws IOException If the file it's attempting to read from is missing.
     */
    public ChipFileReader() throws IOException {
        Gson gson = new Gson();
        //TODO Add support for other Battle Network Files
        Reader standardReader = prepareReader(PathConstants.bnThreeStandardChipLibrary);
        Reader megaReader = prepareReader(PathConstants.bnThreeMegaChipLibrary);
        Reader gigaReader = prepareReader(PathConstants.bnThreeGigaChipLibrary);
        standardChipList = prepareList(standardReader, gson);
        megaChipList = prepareList(megaReader, gson);
        gigaChipList = prepareList(gigaReader, gson);
        outputStats();
    }

    private Reader prepareReader(String filePath) {
        InputStream input = getClass().getResourceAsStream(filePath);
        assert input != null;
        return new InputStreamReader(input);
    }

    private List<Chip> prepareList(Reader reader, Gson gson) {
        return gson.fromJson(reader, new TypeToken<List<Chip>>() {}.getType());
    }

    private void outputStats() {
        int chipCount = standardChipList.size();
        chipCount += megaChipList.size();
        chipCount += gigaChipList.size();
        simplePrint("BN3 Chips read from files successfully, " + chipCount + " chips loaded.");
    }

    /**
     * Searches the loaded chips for ones that have a matching number.
     *
     * @param number The number we're searching for.
     * @return A {@link List} of {@link Chip} that have a matching number.
     */
    public List<Chip> searchChipsByNumber(String number) {
        List<Chip> foundChips = new ArrayList<>();
        foundChips.addAll(searchListForNumber(standardChipList, number));
        foundChips.addAll(searchListForNumber(megaChipList, number));
        foundChips.addAll(searchListForNumber(gigaChipList, number));
        return foundChips;
    }

    private List<Chip> searchListForNumber(List<Chip> chipList, String number) {
        List<Chip> foundChips = new ArrayList<>();
        for (Chip chip : chipList) {
            if (StringUtils.equals(chip.getNumber(), number)) {
                foundChips.add(chip);
            }
        }
        return foundChips;
    }

    /**
     * Searches the loaded chips for ones whose name matches the input.
     *
     * @param input The {@link String} we're searching for.
     * @return A {@link List} of {@link Chip} whose name matches the input.
     */
    public List<Chip> searchChipsByName(String input) {
        List<Chip> foundChips = new ArrayList<>();
        foundChips.addAll(searchListForName(standardChipList, input));
        foundChips.addAll(searchListForName(megaChipList, input));
        foundChips.addAll(searchListForName(gigaChipList, input));
        return foundChips;
    }

    private List<Chip> searchListForName(List<Chip> chipList, String name) {
        List<Chip> foundChips = new ArrayList<>();
        for (Chip chip : chipList) {
            if (StringUtils.equalsIgnoreCase(chip.getName(), name)) {
                foundChips.add(chip);
            }
        }
        return foundChips;
    }

    /**
     * Searches the loaded chips for ones whose damage matches the input.
     *
     * @param input The number we wish the chip to deal in damage.
     * @return A {@link List} of {@link Chip} whose damage matches the number
     * given.
     */
    public List<Chip> searchChipsByDamage(int input) {
        List<Chip> foundChips = new ArrayList<>();
        foundChips.addAll(searchListForDamage(standardChipList, input));
        foundChips.addAll(searchListForDamage(megaChipList, input));
        foundChips.addAll(searchListForDamage(gigaChipList, input));
        return foundChips;
    }

    private List<Chip> searchListForDamage(List<Chip> chipList, int damage) {
        List<Chip> foundChips = new ArrayList<>();
        for (Chip chip : chipList) {
            if (chip.getDamage() != null && damage == chip.getDamage()) {
                foundChips.add(chip);
            }
        }
        return foundChips;
    }

    /**
     * Searches the loaded chips for ones that can have the code given as input.
     *
     * @param input The code we wish the chip to contain.
     * @return A {@link List} of {@link Chip} who can have the code given.
     */
    public List<Chip> searchChipsByCode(String input) {
        List<Chip> foundChips = new ArrayList<>();
        foundChips.addAll(searchListForCode(standardChipList, input));
        foundChips.addAll(searchListForCode(megaChipList, input));
        foundChips.addAll(searchListForCode(gigaChipList, input));
        return foundChips;
    }

    private List<Chip> searchListForCode(List<Chip> chipList, String input) {
        List<Chip> foundChips = new ArrayList<>();
        for (Chip chip : chipList) {
            if (StringUtils.containsIgnoreCase(chip.getPossibleCodes(), input)) {
                foundChips.add(chip);
            }
        }
        return foundChips;
    }

    /**
     * Searches the loaded chips for ones whose memory size matches the input.
     *
     * @param input The memory size we wish the chips to have.
     * @return A {@link List} of {@link Chip} whose memory value matches the
     * input.
     */
    public List<Chip> searchChipsByMemorySize(int input) {
        List<Chip> foundChips = new ArrayList<>();
        foundChips.addAll(searchListForMemory(standardChipList, input));
        foundChips.addAll(searchListForMemory(megaChipList, input));
        foundChips.addAll(searchListForMemory(gigaChipList, input));
        return foundChips;
    }

    private List<Chip> searchListForMemory(List<Chip> chipList, int input) {
        List<Chip> foundChips = new ArrayList<>();
        for (Chip chip : chipList) {
            if (chip.getMemory() == input) {
                foundChips.add(chip);
            }
        }
        return foundChips;
    }
}