package engine;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**
 * Main class of game.
 */
public class Game extends com.badlogic.gdx.Game {    
    
    /**
     * Set initial resources.
     */    
    public void initResources() {        
        
    }
    
    /**
     * Change game after a elapsed time.
     * @param elapsedTime time between 2 call of update.
     */    
    public void update(long elapsedTime) {        
        
    }
    
    /**
     * Render game.
     * @param g 
     */    
    public void render(java.awt.Graphics2D g) {
        engine.Graphics2D ctx = new engine.Graphics2D(m_batch);
        renderInContext(ctx);
    }
    
    /**
     * Render context.
     * @param g 
     */    
    public void renderInContext(engine.Graphics2D g) {
        
    }
    
    /**
     * Render game.
     * @param g 
     */
    @Override
    public void render() {
        super.render();
    }    
    
    
    SpriteBatch m_batch;
    Graphics2D  m_ctx;
    static Camera m_current_camera;

    @Override
    public void create() {
        m_batch = new SpriteBatch();    
        m_ctx = new Graphics2D(m_batch);
        
        this.setScreen(m_gameEngine.getGame(0).m_scene);
    }
    
    GameEngine m_gameEngine;
}
