package pojos;

import interfaces.Printable;

import java.util.List;

import static systems.utility.Helpers.simplePrint;

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
     * The outputted message will be formatted as such:
     * </p>
     * <pre>
     * Name:        Chip Name
     * Damage:      ### / -
     * Chips Used:  Chip 1 + Chip 2...
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
        //TODO Implement pretty print for chips used in Program Advance.
        //print("Chips used:");
        simplePrint("Description: " + getDescription());
    }
}