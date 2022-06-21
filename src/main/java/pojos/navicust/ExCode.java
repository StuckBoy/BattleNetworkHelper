package pojos.navicust;

import interfaces.Printable;

import static systems.utility.Helpers.simplePrint;

public class ExCode implements Printable {
    private String code;
    private String effect;
    private String glitch;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getGlitch() {
        return glitch;
    }

    public void setGlitch(String glitch) {
        this.glitch = glitch;
    }

    /**
     * Prints the {@link ExCode} provided in a way that is easy for users to
     * parse.
     * <p>
     * The outputted message will be formatted as such:
     * </p>
     * <pre>
     * Extra Code:  The sequence to be inputted
     * Effect:      Description of the effect.
     * Glitch:      Side effects of using the code.
     * </pre>
     * @see systems.utility.Helpers#simplePrint(String)
     */
    @Override
    public void print() {
        System.out.println();
        simplePrint("Extra Code:  " + getCode());
        simplePrint("Effect:      " + getEffect());
        simplePrint("Glitch:      " + getGlitch());
    }
}