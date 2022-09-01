package systems.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HelperFrame extends Frame {

    private int buttonCount = 0;

    public HelperFrame() {
        Label logo = new Label("Battle Network Helper");
        Button chipLookup = new Button("Chip Lookup");
        Button programAdvanceLookup = new Button("P.A. Lookup");
        Button folderBuilder = new Button("Folder Builder");
        Button codeLookup = new Button("Code Lookup");
        Button editConfig = new Button("Edit Config");
        Button exit = new Button("Exit");
        // setting position on screen
        logo.setFont(new Font(Font.MONOSPACED, Font.BOLD, 48));
        logo.setAlignment(Label.CENTER);
        logo.setBounds(80, 25, 600, 300);

        prepareButton(chipLookup);
        prepareButton(programAdvanceLookup);
        prepareButton(folderBuilder);
        prepareButton(codeLookup);
        prepareButton(editConfig);
        prepareButton(exit);

        // adding button into frame
        add(logo);
        add(chipLookup);
        add(programAdvanceLookup);
        add(folderBuilder);
        add(codeLookup);
        add(editConfig);
        add(exit);
        setSize(720, 1280);
        setTitle("Battle Network Helper");
        // no layout manager
        setLayout(null);
        // now frame will be visible, by default it is not visible
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private void prepareButton(Button button) {
        int y = 550;
        int x = (720/2)-180;
        int width = 360;
        int height = 60;
        int spacing = 20;
        button.setBounds(x, y+(height*buttonCount)+spacing, width, height);
        buttonCount++;
        button.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
    }

    public static void main(String args[]) {
        // creating instance of Frame class
        HelperFrame f = new HelperFrame();
    }
}
