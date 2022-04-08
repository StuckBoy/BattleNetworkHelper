package pojos;

public class ErrorCode {
    private String code;
    private String program;
    private String obtainedFrom;
    private String errorNumber;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getObtainedFrom() {
        return obtainedFrom;
    }

    public void setObtainedFrom(String obtainedFrom) {
        this.obtainedFrom = obtainedFrom;
    }

    public String getErrorNumber() {
        return errorNumber;
    }

    public void setErrorNumber(String errorNumber) {
        this.errorNumber = errorNumber;
    }
}