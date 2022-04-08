package constants;

public class PathConstants {
    private static final String jsonFilePath = "src/main/resources/JSON/";
    private static final String battleNetworkThreePath = "bn3/BN3 ";
    private static final String battleNetworkSixPath = "bn6/BN6 ";
    private static final String chipLibraryJson = "Chip Library.json";
    private static final String customizerPartLibraryJson = "Customizer Part Library.json";
    private static final String programAdvanceJson = "PA Combos.json";
    private static final String exCodeLibraryJson = "Extra Codes.json";
    private static final String errorCodeLibraryJson = "Error Codes.json";
    private static final String compressionCodeLibraryJson = "Compression Codes.json";

    //Battle Network 3 Constants
    public static final String bnThreeJsonPath = jsonFilePath + battleNetworkThreePath;
    public static final String bnThreeChipLibrary = bnThreeJsonPath + chipLibraryJson;
    public static final String bnThreeCustomizerPartLibrary = bnThreeJsonPath + customizerPartLibraryJson;
    public static final String bnThreeProgramAdvanceLibrary = bnThreeJsonPath + programAdvanceJson;
    public static final String bnThreeExCodes = bnThreeJsonPath + exCodeLibraryJson;
    public static final String bnThreeCompressionCodeLibrary = bnThreeJsonPath + compressionCodeLibraryJson;

    //Battle Network 6 Constants
    public static final String bnSixJsonPath = jsonFilePath + battleNetworkSixPath;
    public static final String bnSixChipLibrary = bnSixJsonPath + chipLibraryJson;
    public static final String bnSixCustomizerPartLibrary = bnSixJsonPath + customizerPartLibraryJson;
    public static final String bnSixProgramAdvanceLibrary = bnSixJsonPath + programAdvanceJson;
    public static final String bnSixCompressionCodeLibrary = bnSixJsonPath + compressionCodeLibraryJson;
}