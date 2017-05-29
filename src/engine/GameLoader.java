package engine;

import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import java.awt.Dimension;


/**
 * Game loader.
 */
public class GameLoader {
    
    /**
     * Default constructor.
     */
    public GameLoader() {
        m_config = new LwjglApplicationConfiguration();
        m_app = null;
    }
    
    /**
     * Start game.
     */
    public void start() {
        m_app = new LwjglApplication(m_gameengine.m_game, m_config);
    }        

    /**
     * Set up game loader.
     * @param game game.
     * @param dimension dimension of window.
     * @param b full screen on or off.
     */
    public void setup(GameEngine game, Dimension dimension, boolean b) {
        m_config.width = dimension.width;
        m_config.height = dimension.height;
        m_config.fullscreen = b;
        m_config.foregroundFPS = 60;
        m_config.resizable = false;
        
        m_gameengine = game;
    }
    
    /**
     * Конфигурация приложения
     */
    LwjglApplicationConfiguration m_config;
    
    /**
     * Приложение для запуска
     */
    LwjglApplication m_app;
    
    /**
     * Игра, которая будет исполняться в приложении
     */
    GameEngine m_gameengine;
}
