package engine;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Graphic 2D.
 */
public class Graphics2D {
    
    /**
     * Create new G2D with batch
     * @param batch 
     */
    public Graphics2D(SpriteBatch batch) {
        m_batch = batch;
    }
    
    /**
     * Begin painting.
     */
    public void begin() {
        m_batch.begin();
    }
    
    /**
     * End painting.
     */
    public void end() {
        m_batch.end();
    }
    
    
    /**
     * Get the batch of G2D.
     * @return
     */
    public SpriteBatch getBatch() {
        return m_batch;
    }
        
    /**
     * Batch for painting.
     */
    SpriteBatch m_batch;
}
