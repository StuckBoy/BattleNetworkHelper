package pojos;

import static systems.utility.Helpers.simplePrint;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import interfaces.Printable;

public class ProgramAdvance implements Printable {

    /**
     * The name of the Program Advance
     */
    private String name;

    /**
     * A summary of what the program advance does when activated.
     */
    private String description;

    /**
     * The amount dealt to enemies hit by this chip, {@code null} if it doesn't
     * inflict any damage. In the rare case where this restores health instead,
     * the number represents the Hit Points recovered.
     */
    private Integer damage;

    /**
     * A {@link List} containing one or more {@link List} of {@link Chip} needed
     * in order to trigger the program advance. The order of each list dictates
     * the order in which the chips must be for the program advance.
     */
    private List<List<String>> combos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public List<List<String>> getCombos() {
        return combos;
    }

    public void setCombos(List<List<String>> combos) {
        this.combos = combos;
    }

    /**
     * Prints the {@link ProgramAdvance} in a way that is easy for users to
     * parse.
     *
     * <p>
     * The outputted message will be formatted as such, assuming the Program
     * Advance has more than one combination of chips:
     * </p>
     * <pre>
     * Name:        Chip Name
     * Damage:      ### / -
     * Combos:      Chip 1 + Chip 2 + Chip 3
     *              Chip 2 + Chip 3 + Chip 4
     *              Chip 3 + Chip 4 + Chip 5
     * Description: Program Advance Description
     * </pre>
     * @see systems.utility.Helpers#simplePrint(String)
     */
    @Override
    public void print() {
        System.out.println();
        simplePrint("Name:        " + getName());
        if (getDamage() != null) {
            simplePrint("Damage:      " + getDamage());
        } else {
            simplePrint("Damage:      -");
        }
        List<String> comboList = new ArrayList<>();
        combos.forEach(combo -> comboList.add(buildComboString(combo)));
        if (comboList.size() == 1) {
            simplePrint("Combo:       " + comboList.get(0));
        } else {
            simplePrint("Combos:      " + comboList.get(0) + ",");
            ListIterator<String> itr = comboList.listIterator(1);
            while (itr.hasNext()) {
                String line = "             " + itr.next();
                if (itr.hasNext()) {
                    line += ",";
                }
                simplePrint(line);
            }
        }
        simplePrint("Description: " + getDescription());
    }

    /**
     * Constructs a formatted combination of Chips to activate a
     * {@link ProgramAdvance}
     *
     * @param combo The {@link List} of {@link String} containing the names of
     * each {@link Chip} used to activate the {@link ProgramAdvance}.
     * @return a {@link String} representing a combination of Chips needed to
     * activate the {@link ProgramAdvance}.
     */
    private String buildComboString(List<String> combo) {
        String chipOne = combo.get(0);
        String chipTwo = combo.get(1);
        String chipThree = combo.get(2);
        String comboString = "%s + %s + %s";
        switch (combo.size()) {
            case 3 -> comboString = String.format(comboString, chipOne, chipTwo, chipThree);
            case 4 -> {
                comboString += " + %s";
                String chipFour = combo.get(3);
                comboString = String.format(comboString, chipOne, chipTwo, chipThree, chipFour);
            }
            case 5 -> {
                comboString += " + %s + %s";
                String chipFour = combo.get(3);
                String chipFive = combo.get(4);
                comboString = String.format(comboString, chipOne, chipTwo, chipThree, chipFour, chipFive);
            }
        }
        return comboString;
    }
}