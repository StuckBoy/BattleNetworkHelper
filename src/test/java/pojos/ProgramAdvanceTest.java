package pojos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProgramAdvanceTest {

    private final String testString = "TEST STRING";
    private final Integer testInteger = 1;
    private final List<List<String>> testListList = new ArrayList<>(new ArrayList<>());

    private ProgramAdvance testProgramAdvance;

    @BeforeEach
    public void setUp() {
        testProgramAdvance = new ProgramAdvance();
    }

    @Test
    void getName() {
        assertNull(testProgramAdvance.getName());
        testProgramAdvance.setName(testString);
        assertEquals(testString, testProgramAdvance.getName());
    }

    @Test
    void setName() {
        assertNull(testProgramAdvance.getName());
        testProgramAdvance.setName(testString);
        assertEquals(testString, testProgramAdvance.getName());
    }

    @Test
    void getDescription() {
        assertNull(testProgramAdvance.getDescription());
        testProgramAdvance.setDescription(testString);
        assertEquals(testString, testProgramAdvance.getDescription());
    }

    @Test
    void setDescription() {
        assertNull(testProgramAdvance.getDescription());
        testProgramAdvance.setDescription(testString);
        assertEquals(testString, testProgramAdvance.getDescription());
    }

    @Test
    void getDamage() {
        assertNull(testProgramAdvance.getDamage());
        testProgramAdvance.setDamage(testInteger);
        assertEquals(testInteger, testProgramAdvance.getDamage());
    }

    @Test
    void setDamage() {
        assertNull(testProgramAdvance.getDamage());
        testProgramAdvance.setDamage(testInteger);
        assertEquals(testInteger, testProgramAdvance.getDamage());
    }

    @Test
    void getCombos() {
        assertNull(testProgramAdvance.getCombos());
        testProgramAdvance.setCombos(testListList);
        assertEquals(testListList, testProgramAdvance.getCombos());
    }

    @Test
    void setCombos() {
        assertNull(testProgramAdvance.getCombos());
        testProgramAdvance.setCombos(testListList);
        assertEquals(testListList, testProgramAdvance.getCombos());
    }

    @Test
    void print() {
        testProgramAdvance.setName(testString);
        testProgramAdvance.setDescription(testString);
        testProgramAdvance.setDamage(testInteger);
        testProgramAdvance.setCombos(testListList);

        String output = """
        Name:        TEST STRING
        Description: TEST STRING
        Damage:      1
        Combos:      
        """;
    }
}
