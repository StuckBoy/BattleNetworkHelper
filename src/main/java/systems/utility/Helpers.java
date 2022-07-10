package systems.utility;

import java.util.List;

public class Helpers {

    /**
     * Allows for errors to be printed using a single call, while not disrupting
     * the spacing of messages from the console. I.E. it prints the message,
     * then a System-dependent line separator.
     *
     * @param s The {@link String} we wish to print.
     * @see #simplePrint(String)
     * @see System#lineSeparator()
     */
    public static void errorPrint(String s) {
        simplePrint(s);
        simplePrint(System.lineSeparator());
    }

    /**
     * Simplifies calls to {@link System} for printing.
     * @param s The complete {@link String} to be printed.
     */
    public static void simplePrint(String s) {
        System.out.println(s);
    }

    /**
     * Constructs a list of selectable options.
     * <p>
     * For a list of three options, they are displayed as follows:
     * </p>
     * <pre>
     * 1) Option 1
     * 2) Option 2
     * 3) Option 3
     *
     * Please select an option...
     * </pre>
     *
     * @param options A {@link String} {@link List} containing the options to
     * be printed in a formatted string.
     */
    public static void printOptions(List<String> options) {
        int optionNum = 1;
        StringBuilder optionsListBuilder = new StringBuilder();
        for (String option : options) {
            String optionLine = optionNum + ") " + option + System.lineSeparator();
            optionsListBuilder.append(optionLine);
            optionNum++;
        }
        optionsListBuilder.append(System.lineSeparator());
        optionsListBuilder.append("Please select an option...");
        simplePrint(optionsListBuilder.toString());
    }
}