package pojos.navicust;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ErrorCodeTest {

    private final String testString = "Test String";
    private ErrorCode testErrorCode;

    @BeforeEach
    public void setUp() {
        testErrorCode = new ErrorCode();
    }

    @Test
    void getCode() {
        assertNull(testErrorCode.getCode());
        testErrorCode.setCode(testString);
        assertEquals(testString, testErrorCode.getCode());
    }

    @Test
    void setCode() {
        assertNull(testErrorCode.getCode());
        testErrorCode.setCode(testString);
        assertEquals(testString, testErrorCode.getCode());
    }

    @Test
    void getProgram() {
        assertNull(testErrorCode.getProgram());
        testErrorCode.setProgram(testString);
        assertEquals(testString, testErrorCode.getProgram());
    }

    @Test
    void setProgram() {
        assertNull(testErrorCode.getProgram());
        testErrorCode.setProgram(testString);
        assertEquals(testString, testErrorCode.getProgram());
    }

    @Test
    void getObtainedFrom() {
        assertNull(testErrorCode.getObtainedFrom());
        testErrorCode.setObtainedFrom(testString);
        assertEquals(testString, testErrorCode.getObtainedFrom());
    }

    @Test
    void setObtainedFrom() {
        assertNull(testErrorCode.getObtainedFrom());
        testErrorCode.setObtainedFrom(testString);
        assertEquals(testString, testErrorCode.getObtainedFrom());
    }

    @Test
    void getErrorNumber() {
        assertNull(testErrorCode.getErrorNumber());
        testErrorCode.setErrorNumber(testString);
        assertEquals(testString, testErrorCode.getErrorNumber());
    }

    @Test
    void setErrorCode() {
        assertNull(testErrorCode.getErrorNumber());
        testErrorCode.setErrorNumber(testString);
        assertEquals(testString, testErrorCode.getErrorNumber());
    }
}