package pojos;

public class Chip {
    /**
     * The number to represent the chip in-game.
     */
    private String number;

    /**
     * The name of the chip.
     */
    private String name;

    /**
     * The amount dealt to enemies hit by this chip, null if it doesn't inflict
     * any damage.
     */
    private Integer damage;

    /**
     * The alphabetical codes available for the chip.
     */
    private String possibleCodes;

    /**
     * The memory value for the chip. Restricts what chip can be in your
     * starting hand.
     */
    private Integer memory;

    /**
     * A summary of what the chip does when activated.
     */
    private String description;

    /**
     * Where to obtain it in the game.
     */
    private String locations;

    /**
     * Indicates if the chip is of standard, mega or giga rarity.
     */
    private String rarity;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public String getPossibleCodes() {
        return possibleCodes;
    }

    public void setPossibleCodes(String possibleCodes) {
        this.possibleCodes = possibleCodes;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }
}