package pojos;

import java.util.List;

public class Folder {
    private List<Chip> activeChips;

    public List<Chip> getActiveChips() {
        return activeChips;
    }

    public void setActiveChips(List<Chip> activeChips) {
        this.activeChips = activeChips;
    }
}
