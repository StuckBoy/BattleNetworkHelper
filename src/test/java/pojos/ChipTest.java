package pojos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ChipTest {

    private final String testString = "TEST STRING";
    private final Integer testInteger = 1;

    private Chip testChip;

    @BeforeEach
    public void setUp() {
        testChip = new Chip();
    }

    @Test
    void getNumber() {
        assertNull(testChip.getNumber());
        testChip.setNumber("TEST STRING");
        assertEquals(testString, testChip.getNumber());
    }

    @Test
    void setNumber() {
        assertNull(testChip.getNumber());
        testChip.setNumber(testString);
        assertEquals(testString, testChip.getNumber());
    }

    @Test
    void getName() {
        assertNull(testChip.getName());
        testChip.setName("TEST STRING");
        assertEquals(testString, testChip.getName());
    }

    @Test
    void setName() {
        assertNull(testChip.getName());
        testChip.setName(testString);
        assertEquals(testString, testChip.getName());
    }

    @Test
    void getDamage() {
        assertNull(testChip.getDamage());
        testChip.setDamage(testInteger);
        assertEquals(testInteger, testChip.getDamage());
    }

    @Test
    void setDamage() {
        assertNull(testChip.getDamage());
        testChip.setDamage(testInteger);
        assertEquals(testInteger, testChip.getDamage());
    }

    @Test
    void getPossibleCodes() {
        assertNull(testChip.getPossibleCodes());
        testChip.setPossibleCodes("TEST STRING");
        assertEquals(testString, testChip.getPossibleCodes());
    }

    @Test
    void setPossibleCodes() {
        assertNull(testChip.getPossibleCodes());
        testChip.setPossibleCodes(testString);
        assertEquals(testString, testChip.getPossibleCodes());
    }

    @Test
    void getMemory() {
        assertNull(testChip.getMemory());
        testChip.setMemory(testInteger);
        assertEquals(testInteger, testChip.getMemory());
    }

    @Test
    void setMemory() {
        assertNull(testChip.getMemory());
        testChip.setMemory(testInteger);
        assertEquals(testInteger, testChip.getMemory());
    }

    @Test
    void getDescription() {
        assertNull(testChip.getDescription());
        testChip.setDescription("TEST STRING");
        assertEquals(testString, testChip.getDescription());
    }

    @Test
    void setDescription() {
        assertNull(testChip.getDescription());
        testChip.setDescription(testString);
        assertEquals(testString, testChip.getDescription());
    }

    @Test
    void getLocations() {
        assertNull(testChip.getLocations());
        testChip.setLocations("TEST STRING");
        assertEquals(testString, testChip.getLocations());
    }

    @Test
    void setLocations() {
        assertNull(testChip.getLocations());
        testChip.setLocations(testString);
        assertEquals(testString, testChip.getLocations());
    }

    @Test
    void getRarity() {
        assertNull(testChip.getRarity());
        testChip.setRarity("TEST STRING");
        assertEquals(testString, testChip.getRarity());
    }

    @Test
    void setRarity() {
        assertNull(testChip.getRarity());
        testChip.setRarity(testString);
        assertEquals(testString, testChip.getRarity());
    }
}