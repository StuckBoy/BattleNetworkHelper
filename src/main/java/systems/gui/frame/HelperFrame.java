package systems.gui.frame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import constants.AppConstants;
import systems.gui.window.ChipLookupPanel;

public class HelperFrame extends JFrame {

    private int buttonCount = 0;
    private final int helperWidth = 720;
    private final int helperHeight = 1280;
    private final Panel mainPanel;

    public HelperFrame() {
        mainPanel = new Panel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, helperWidth, helperHeight);
        Label logo = new Label("Battle Network Helper");
        // setting position on screen
        logo.setFont(new Font(Font.MONOSPACED, Font.BOLD, 48));
        logo.setAlignment(Label.CENTER);
        logo.setBounds(80, 25, 600, 300);
        mainPanel.add(logo);

        Panel defaultPanel = createDefaultPanel();
        mainPanel.add(defaultPanel);
        setSize(helperWidth, helperHeight);
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

    private Panel createDefaultPanel() {
        Panel panel = new Panel();

        int xOffset = 260;
        int x = (helperWidth/2)-xOffset;
        int y = helperHeight/4;
        int width = (helperWidth/3) + xOffset;
        int height = helperHeight/3;
        panel.setBounds(x, y, width, height);

        Button chipLookup = prepareButton(AppConstants.codeLookup);
        chipLookup.addActionListener(listener -> bootChipLookup());
        Button programAdvanceLookup = prepareButton(AppConstants.programAdvanceLookup);
        programAdvanceLookup.addActionListener(listener -> bootProgramAdvanceLookup());
        Button folderBuilder = prepareButton(AppConstants.folderBuilder);
        folderBuilder.addActionListener(listener -> bootFolderBuilder());
        Button codeLookup = prepareButton(AppConstants.codeLookup);
        codeLookup.addActionListener(listener -> bootCodeLookup());
        Button editConfig = prepareButton(AppConstants.editConfig);
        editConfig.addActionListener(listener -> bootConfiguration());
        Button exit = prepareButton(AppConstants.exit);
        exit.addActionListener(listener -> exitHelper());

        // adding button into frame
        panel.add(chipLookup);
        panel.add(programAdvanceLookup);
        panel.add(folderBuilder);
        panel.add(codeLookup);
        panel.add(editConfig);
        panel.add(exit);

        panel.setLayout(null);
        return panel;
    }

    private Button prepareButton(String label) {
        Button button = new Button(label);
        int y = 20;
        int x = (helperWidth/3)-180;
        int width = 380;
        int height = 60;
        int spacing = 20;
        button.setBounds(x, y+(height*buttonCount)+spacing, width, height);
        buttonCount++;
        button.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
        return button;
    }

    private void bootChipLookup() {
        remove(mainPanel);
        ChipLookupPanel chipPanel = new ChipLookupPanel();
        add(chipPanel);
//        chipPanel.setBounds(0, 0, helperWidth, helperHeight);
    }

    private void bootProgramAdvanceLookup() {
        //TODO
    }

    private void bootFolderBuilder() {
        //TODO
    }

    private void bootCodeLookup() {
        //TODO
    }

    private void bootConfiguration() {
        //TODO
    }

    private void exitHelper() {
        dispose();
    }

    public static void main(String args[]) {
        // creating instance of Frame class
        HelperFrame f = new HelperFrame();
    }
}
