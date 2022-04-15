package systems.utility;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import constants.PathConstants;
import org.apache.commons.lang3.StringUtils;
import pojos.Chip;
import pojos.ChipList;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static systems.utility.Helpers.print;

public class FileReader {
    private final List<Chip> chipList;

    /**
     * Automatically prepares the file for reading using a {@link Reader}, and
     * parsing of the JSON file using {@link Gson}.
     *
     * @throws IOException If the file it's attempting to read from is missing.
     */
    public FileReader() throws IOException {
        Gson gson = new Gson();
        //TODO Add support for other Battle Network Files
        Reader reader = Files.newBufferedReader(Paths.get(PathConstants.bnThreeChipLibrary));
        chipList = gson.fromJson(reader, new TypeToken<List<ChipList>>() {}.getType());
        print("BN3 Chips read from file. " + chipList.size() + " regular chips loaded.");
    }

    /**
     * Searches the loaded chips for ones that have a matching number.
     *
     * @param number The number we're searching for.
     * @return A {@link List} of {@link Chip} that have a matching number.
     */
    public List<Chip> searchChipsByNumber(String number) {
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
        for (Chip chip : chipList) {
            if (StringUtils.equalsIgnoreCase(chip.getName(), input)) {
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
        for (Chip chip : chipList) {
            if (chip.getDamage() != null && input == chip.getDamage()) {
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
        for (Chip chip : chipList) {
            if (StringUtils.contains(chip.getPossibleCodes(), input)) {
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
        for (Chip chip : chipList) {
            if (chip.getMemory() == input) {
                foundChips.add(chip);
            }
        }
        return foundChips;
    }
}