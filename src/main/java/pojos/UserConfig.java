package pojos;

import constants.Game;

/**
 * Contains information about the user that should be able to persist between
 * sessions.
 */
public class UserConfig {
    /**
     * The self-assigned name for the user.
     */
    private String username;

    /**
     * {@link Game} {@link Enum} whose data should be loaded.
     */
    private Game currentGame;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }
}