package constants;

public class PathConstants {
    private static final String jsonFilePath = "/JSON/";
    private static final String battleNetworkThreePath = "bn3/BN3 ";
    private static final String battleNetworkSixPath = "bn6/BN6 ";
    private static final String standardLibraryPrefix = "Standard ";
    private static final String megaLibraryPrefix = "Mega ";
    private static final String gigaLibraryPrefix = "Giga ";
    private static final String chipLibraryJson = "Chip Library.json";
    private static final String standardChipLibraryJson = standardLibraryPrefix + chipLibraryJson;
    private static final String megaChipLibraryJson = megaLibraryPrefix + chipLibraryJson;
    private static final String gigaChipLibraryJson = gigaLibraryPrefix + chipLibraryJson;
    private static final String customizerPartLibraryJson = "Customizer Part Library.json";
    private static final String programAdvanceJson = "PA Combos.json";
    private static final String exCodeLibraryJson = "Extra Codes.json";
    private static final String errorCodeLibraryJson = "Error Codes.json";
    private static final String compressionCodeLibraryJson = "Compression Codes.json";

    public static final String userConfigPath = "\\config\\UserConfig.json";
    public static final String unixUserConfigPath = "/config/UserConfig.json";


    //Battle Network 3 Constants
    public static final String bnThreeJsonPath = jsonFilePath + battleNetworkThreePath;
    public static final String bnThreeStandardChipLibrary = bnThreeJsonPath + standardChipLibraryJson;
    public static final String bnThreeMegaChipLibrary = bnThreeJsonPath + megaChipLibraryJson;
    public static final String bnThreeGigaChipLibrary = bnThreeJsonPath + gigaChipLibraryJson;
    public static final String bnThreeCustomizerPartLibrary = bnThreeJsonPath + customizerPartLibraryJson;
    public static final String bnThreeProgramAdvanceLibrary = bnThreeJsonPath + programAdvanceJson;
    public static final String bnThreeExCodes = bnThreeJsonPath + exCodeLibraryJson;
    public static final String bnThreeErrorCodes = bnThreeJsonPath + errorCodeLibraryJson;
    public static final String bnThreeCompressionCodes = bnThreeJsonPath + compressionCodeLibraryJson;

    //Battle Network 6 Constants
    public static final String bnSixJsonPath = jsonFilePath + battleNetworkSixPath;
    public static final String bnSixChipLibrary = bnSixJsonPath + chipLibraryJson;
    public static final String bnSixCustomizerPartLibrary = bnSixJsonPath + customizerPartLibraryJson;
    public static final String bnSixProgramAdvanceLibrary = bnSixJsonPath + programAdvanceJson;
    public static final String bnSixCompressionCodes = bnSixJsonPath + compressionCodeLibraryJson;
}