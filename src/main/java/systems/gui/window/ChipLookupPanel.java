package systems.gui.window;

import java.awt.*;

public class ChipLookupPanel extends Panel {
    private final int panelWidth = 720;
    private final int panelHeight = 1280;

    public ChipLookupPanel() {
        Label panelName = new Label("Chip Lookup");
        panelName.setFont(new Font(Font.MONOSPACED, Font.BOLD, 48));
        panelName.setAlignment(Label.CENTER);
        panelName.setBounds(80, 25, 500, 200);
        add(panelName);
        setSize(panelWidth, panelHeight);
        setLayout(null);
        setVisible(true);
    }
}
