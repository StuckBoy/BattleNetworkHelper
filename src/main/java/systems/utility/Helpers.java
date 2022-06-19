package systems.utility;

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
}