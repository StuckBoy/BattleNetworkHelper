package systems.utility.readers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import constants.PathConstants;
import pojos.CompressionCode;
import pojos.ErrorCode;
import pojos.ExCode;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static systems.utility.Helpers.print;

public class CodeFileReader {

    private final List<ExCode> extraCodeList;
    private final List<ErrorCode> errorCodeList;
    private final List<CompressionCode> compressionCodeList;

    public CodeFileReader() throws IOException {
        Gson gson = new Gson();
        //TODO Implement for remaining BN games.
        Reader exReader = Files.newBufferedReader(Paths.get(PathConstants.bnThreeExCodes));
        Reader errorReader = Files.newBufferedReader(Paths.get(PathConstants.bnThreeErrorCodes));
        Reader compressionReader = Files.newBufferedReader(Paths.get(PathConstants.bnThreeCompressionCodes));

        extraCodeList = gson.fromJson(exReader, new TypeToken<List<ExCode>>() {}.getType());
        errorCodeList = gson.fromJson(errorReader, new TypeToken<List<ErrorCode>>() {}.getType());
        compressionCodeList = gson.fromJson(compressionReader, new TypeToken<List<CompressionCode>>() {}.getType());
        int extraCodeListSize = extraCodeList.size();
        print("Loaded " + extraCodeListSize + " Extra Codes");
        int errorCodeListSize = errorCodeList.size();
        print("Loaded " + errorCodeListSize + " Error Codes");
        int compressionCodeListSize = compressionCodeList.size();
        print("Loaded " + compressionCodeListSize + " Compression Codes");
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

}