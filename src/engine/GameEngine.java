package engine;

/**
 * Game Engine.
 */
public abstract class GameEngine {
        
    Game m_game; // gdx-game
        
    /**
     * Next game id.
     */
    public int nextGameID;
    
    /**
     * Get game.
     * @param GameID game id.
     * @return GameObject.
     */
    public abstract GameObject getGame(int GameID);
    
    /**
     *  Default constructor.
     */
    public GameEngine() { 
        m_game = new Game();
        m_game.m_gameEngine = this;
    }
            
    /**
     * Set next game id.
     * @param i next game id.
     */
    public void setNextGameID(int i) {
        nextGameID = i;
    }
    
    /**
     * Get next game id.
     * @return id of next game.
     */
    public int getNextGameID() {
        return nextGameID;
    }
}
