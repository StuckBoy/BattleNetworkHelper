package systems.utility.readers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import constants.PathConstants;
import org.apache.commons.lang3.StringUtils;
import pojos.CompressionCode;
import pojos.ErrorCode;
import pojos.ExCode;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import static systems.utility.Helpers.simplePrint;

public class CodeFileReader {

    private final List<ExCode> extraCodeList;
    private final List<ErrorCode> errorCodeList;
    private final List<CompressionCode> compressionCodeList;

    public CodeFileReader() throws IOException {
        //TODO Implement for remaining BN games.

        Reader exReader = prepareReader(PathConstants.bnThreeExCodes);
        Reader errorReader = prepareReader(PathConstants.bnThreeErrorCodes);
        Reader compressionReader = prepareReader(PathConstants.bnThreeCompressionCodes);

        Gson gson = new Gson();
        extraCodeList = gson.fromJson(exReader, new TypeToken<List<ExCode>>() {}.getType());
        errorCodeList = gson.fromJson(errorReader, new TypeToken<List<ErrorCode>>() {}.getType());
        compressionCodeList = gson.fromJson(compressionReader, new TypeToken<List<CompressionCode>>() {}.getType());
        outputStats();
    }

    private Reader prepareReader(String filePath) {
        InputStream input = getClass().getResourceAsStream(filePath);
        assert input != null;
        return new InputStreamReader(input);
    }

    private void outputStats() {
        int extraCodeListSize = extraCodeList.size();
        simplePrint("Loaded " + extraCodeListSize + " Extra Codes");
        int errorCodeListSize = errorCodeList.size();
        simplePrint("Loaded " + errorCodeListSize + " Error Codes");
        int compressionCodeListSize = compressionCodeList.size();
        simplePrint("Loaded " + compressionCodeListSize + " Compression Codes");
    }

    public List<ExCode> getExCodes() {
        return extraCodeList;
    }

    public List<ErrorCode> getErrorCodes() {
        return errorCodeList;
    }

    public List<CompressionCode> getCompressionCodes() {
        return compressionCodeList;
    }

    public List<ExCode> searchExCodesByEffect(String input) {
        List<ExCode> foundExCodes = new ArrayList<>();
        for (ExCode exCode : extraCodeList) {
            if (StringUtils.containsIgnoreCase(exCode.getEffect(), input)) {
                foundExCodes.add(exCode);
            }
        }
        return foundExCodes;
    }

    public List<ExCode> searchExCodesByGlitch(String input) {
        List<ExCode> foundExCodes = new ArrayList<>();
        for (ExCode exCode : extraCodeList) {
            if (StringUtils.containsIgnoreCase(exCode.getGlitch(), input)) {
                foundExCodes.add(exCode);
            }
        }
        return foundExCodes;
    }

    public List<ErrorCode> searchErrorCodesByProgram(String input) {
        List<ErrorCode> foundErrorCodes = new ArrayList<>();
        for (ErrorCode errorCode : errorCodeList) {
            if (StringUtils.containsIgnoreCase(errorCode.getProgram(), input)) {
                foundErrorCodes.add(errorCode);
            }
        }
        return foundErrorCodes;
    }

    public List<ErrorCode> searchErrorCodesByStyle(String input) {
        List<ErrorCode> foundErrorCodes = new ArrayList<>();
        for (ErrorCode errorCode : errorCodeList) {
            if (StringUtils.containsIgnoreCase(errorCode.getObtainedFrom(), input)) {
                foundErrorCodes.add(errorCode);
            }
        }
        return foundErrorCodes;
    }

    public List<ErrorCode> searchErrorCodesByErrorNumber(String input) {
        List<ErrorCode> foundErrorCodes = new ArrayList<>();
        for (ErrorCode errorCode : errorCodeList) {
            if (StringUtils.containsIgnoreCase(errorCode.getErrorNumber(), input)) {
                foundErrorCodes.add(errorCode);
            }
        }
        return foundErrorCodes;
    }
    public List<CompressionCode> searchCompressionCodesByProgram(String input) {
        List<CompressionCode> foundCompressionCodes = new ArrayList<>();
        for (CompressionCode compressionCode : compressionCodeList) {
            if (StringUtils.containsIgnoreCase(compressionCode.getProgramName(), input)) {
                foundCompressionCodes.add(compressionCode);
            }
        }
        return foundCompressionCodes;
    }
}