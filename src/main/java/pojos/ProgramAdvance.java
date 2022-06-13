package pojos;

import java.util.List;

public class ProgramAdvance {

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
     * the numer represents the Hit Points recovered.
     */
    private Integer damage;

    /**
     * A {@link List} containing one or more {@link List} of {@link Chip} needed
     * in order to trigger the program advance. The order of each list dictates
     * the order in which the chips must be for the program advance.
     */
    private List<List<Chip>> chipsNeeded;

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

    public List<List<Chip>> getChipsNeeded() {
        return chipsNeeded;
    }

    public void setChipsNeeded(List<List<Chip>> chipsNeeded) {
        this.chipsNeeded = chipsNeeded;
    }
}