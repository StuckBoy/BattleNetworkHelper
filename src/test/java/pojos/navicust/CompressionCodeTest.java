package pojos.navicust;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompressionCodeTest {

    private final String testString = "TEST STRING";

    private CompressionCode testCompressionCode;

    @BeforeEach
    public void setUp() {
        testCompressionCode = new CompressionCode();
    }

    @Test
    void getProgramName() {
        assertNull(testCompressionCode.getProgramName());
        testCompressionCode.setProgramName(testString);
        assertEquals(testString, testCompressionCode.getProgramName());
    }

    @Test
    void setProgramName() {
        assertNull(testCompressionCode.getProgramName());
        testCompressionCode.setProgramName(testString);
        assertEquals(testString, testCompressionCode.getProgramName());
    }

    @Test
    void getInputSequence() {
        assertNull(testCompressionCode.getInputSequence());
        testCompressionCode.setInputSequence(testString);
        assertEquals(testString, testCompressionCode.getInputSequence());
    }

    @Test
    void setInputSequence() {
        assertNull(testCompressionCode.getInputSequence());
        testCompressionCode.setInputSequence(testString);
        assertEquals(testString, testCompressionCode.getInputSequence());
    }
}
