package pojos.navicust;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ExCodeTest {

    private final String testString = "Test String";

    private ExCode testExCode;

    @BeforeEach
    public void setUp() {
        testExCode = new ExCode();
    }

    @Test
    void getCode() {
        assertNull(testExCode.getCode());
        testExCode.setCode(testString);
        assertEquals(testString, testExCode.getCode());
    }

    @Test
    void setCode() {
        assertNull(testExCode.getCode());
        testExCode.setCode(testString);
        assertEquals(testString, testExCode.getCode());
    }

    @Test
    void getEffect() {
        assertNull(testExCode.getEffect());
        testExCode.setEffect(testString);
        assertEquals(testString, testExCode.getEffect());
    }

    @Test
    void setEffect() {
        assertNull(testExCode.getEffect());
        testExCode.setEffect(testString);
        assertEquals(testString, testExCode.getEffect());
    }

    @Test
    void getGlitch() {
        assertNull(testExCode.getGlitch());
        testExCode.setGlitch(testString);
        assertEquals(testString, testExCode.getGlitch());
    }

    @Test
    void setGlitch() {
        assertNull(testExCode.getGlitch());
        testExCode.setGlitch(testString);
        assertEquals(testString, testExCode.getGlitch());
    }
}