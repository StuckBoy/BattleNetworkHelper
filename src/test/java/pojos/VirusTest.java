package pojos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VirusTest {

    private final String testString = "TEST STRING";
    private final int testInt = 10;
    private Virus testVirus;

    @BeforeEach
    public void setUp() {
        testVirus = new Virus();
    }

    @Test
    void getName() {
        assertNull(testVirus.getName());
        testVirus.setName(testString);
        assertEquals(testString, testVirus.getName());
    }

    @Test
    void setName() {
        assertNull(testVirus.getName());
        testVirus.setName(testString);
        assertEquals(testString, testVirus.getName());
    }

    @Test
    void getHitPoints() {
        assertEquals(0, testVirus.getHitPoints());
        testVirus.setHitPoints(testInt);
        assertEquals(testInt, testVirus.getHitPoints());
    }

    @Test
    void setHitPoints() {
        assertEquals(0, testVirus.getHitPoints());
        testVirus.setHitPoints(testInt);
        assertEquals(testInt, testVirus.getHitPoints());
    }

    @Test
    void getDamage() {
        assertNull(testVirus.getDamage());
        testVirus.setDamage(testString);
        assertEquals(testString, testVirus.getDamage());
    }

    @Test
    void setDamage() {
        assertNull(testVirus.getDamage());
        testVirus.setDamage(testString);
        assertEquals(testString, testVirus.getDamage());
    }

    @Test
    void getElement() {
        assertNull(testVirus.getElement());
        testVirus.setElement(testString);
        assertEquals(testString, testVirus.getElement());
    }

    @Test
    void setElement() {
        assertNull(testVirus.getElement());
        testVirus.setElement(testString);
        assertEquals(testString, testVirus.getElement());
    }

    @Test
    void getLocations() {
        assertNull(testVirus.getLocations());
        List<String> testList = new ArrayList<>();
        testVirus.setLocations(testList);
        assertSame(testList, testVirus.getLocations());
    }
}