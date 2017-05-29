package engine;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * Background of game.
 */
public class ImageBackground {

    /**
     * Total width playground.
     */
    int totalWidth = 0;
    
    /**
     * Total height playground.
     */
    int totalHeight = 0;
    
    /**
     * Viewport width.
     */
    int viewportWidth = 0;
    
    /**
     * Viewport height.
     */
    int viewportHeight = 0;
    
    /**
     * Texture region.
     */
    TextureRegion m_region;
    
    /**
     * Texture.
     */
    Texture m_texture;
        
    /**
     * Constructor.
     * @param bi image.
     */
    public ImageBackground(BufferedImage bi) {
        m_texture  = TextureManager.getTexture(bi);
        m_texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
    }
    
    /**
     * Set image for background object.
     * @param bi new image.
     */
    public void setImage(BufferedImage bi) {
        
    }
    
    /**
     * Clip image to fit background.
     * @param x
     * @param y
     * @param width
     * @param height 
     */    
    public  void setClip(int x, int y, int width, int height) {
        viewportWidth = width;
        viewportHeight = height;
    }
    
    /**
     * Setup total clip image.
     * @param totalWidth
     * @param totalHeight 
     */
    public void setTotalClip(int totalWidth, int totalHeight) {
        this.totalWidth = totalWidth;
        this.totalHeight = totalHeight;
        m_region = new TextureRegion(m_texture);
    }
    
    /**
     * Update background image.
     * @param elapsed 
     */    
    public void update(long elapsed) {
        
    }
    
    /**
     * Render background image.
     * @param g 
     */
    public void render(Graphics2D g) {
        if (m_region != null) {
           g.getBatch().draw(m_region, 0, 0, this.totalWidth, this.totalHeight);
       }
    }
    
    /**
     * Set sprite to center of background.
     * @param s 
     */
    public void setToCenter(Sprite s) {
        Point center = s.getCenter();
        float x = center.x;
        float y = center.y;
        if ((x  - viewportWidth / 2) < 0) {
            x = viewportWidth / 2;
        }
        if ((y  - viewportHeight / 2) < 0) {
            y = viewportHeight / 2;
        }
        if ((x + viewportWidth / 2) > totalWidth) {
            x = totalWidth - viewportWidth / 2;
        }
        if ((y + viewportHeight / 2) > totalHeight) {
            y = totalHeight - viewportHeight / 2;
        }
        Game.m_current_camera.position.set(x, y, 0);
    }
    
    /**
     * Return position x of background.
     * @return 
     */    
    public double getX() {
        return Game.m_current_camera.position.x;
    }

    /**
     * Return position y of background.
     * @return 
     */    
    public double getY() {
        return Game.m_current_camera.position.y;
    }
}
