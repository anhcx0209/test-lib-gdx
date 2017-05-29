package engine;

import com.badlogic.gdx.graphics.Texture;
import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import collision.Ellipse;


/**
 * Sprite - object, what can move and play a role in game.
 */
public abstract class Sprite {
    
    /**
     *  Constructor.
     */
    public Sprite() {                
        m_active = true;
    }
    
    /**
     * Create new sprite and set image and position for it.
     * @param bi image.
     * @param x x position.
     * @param y y position.
     */
    public Sprite(BufferedImage bi, int x, int y) {
        m_x = x;
        m_old_x = x;
        m_y = y;
        m_old_y = y;
        setImage(bi);
    }
    
    /**
     * Set image for sprite.
     * @param bi image.
     */    
    public void setImage(BufferedImage bi) {
        m_texture = TextureManager.getTexture(bi);
        m_shape = new Ellipse(
                m_x +  m_texture.getWidth() / 2, 
                m_y -  m_texture.getHeight() / 2, 
                m_texture.getWidth() / 2, 
                m_texture.getHeight() / 2
        ); 
    }
    
    /**
     * Update sprite.
     * @param elapsed elapsed time.
     */    
    public void update(long elapsed) {
        double nx = m_x + m_horizontal_speed * elapsed;
        double ny = m_y + m_vertical_speed * elapsed;
        
        m_old_x = m_x;
        m_old_y = m_y;
        
        m_x = nx;
        m_y = ny;
        
        m_shape.x0 = m_x +  m_texture.getWidth() / 2;
        m_shape.y0 = m_y -  m_texture.getHeight() / 2;
    }
    
    /**
     * Render sprite.
     * @param g graphic. 
     */
    public void render(Graphics2D g) {
        if (m_texture != null)  {
            g.getBatch().draw(
                m_texture, 
                (float)m_x, 
                (float)(m_y - m_texture.getHeight())
            );
        }
    }
    
    /**
     * Set x position for sprite.
     * @param x position in Ox.
     */    
    public void setX(double x) {
        m_x = x;
        m_shape.x0 = x + m_texture.getWidth() / 2;
    }

    /**
     * Set y position for sprite.
     * @param y position in Oy.
     */   
    public void setY(double y) {
        m_y = y;
        m_shape.y0 = y - m_texture.getHeight() / 2;
    }

    /**
     * Get x position of sprite.
     * @return position in Ox.
     */    
    public double getX() {
        return m_x;
    }

    /**
     * Get y position of sprite.
     * @return position in Oy.
     */    
    public double getY() {
        return m_y;
    }
    
    public Point getCenter() {
        return new Point((int)m_shape.x0,(int) m_shape.y0);
    }
    
    /**
     * Set horizontal speed for sprite.
     * @param v speed in Ox.
     */    
    public void setHorizontalSpeed(double v) {
        m_horizontal_speed = v;
    }

    /**
     * Set vertical speed for sprite.
     * @param v speed in Oy.
     */    
    public void setVerticalSpeed(double v) {
        m_vertical_speed = v;
    }
    
    /**
     * Get horizontal speed.
     * @return speed in Ox.
     */    
    public double getHorizontalSpeed() {
        return m_horizontal_speed;
    }

    /**
     * Get vertical speed.
     * @return speed in Oy.
     */    
    public double getVerticalSpeed() {
        return m_vertical_speed;
    }
    
    /**
     * Get width of sprite.
     * @return width of sprite.
     */    
    public int getWidth() {        
        return m_texture.getWidth();
    }
    
    /**
     * Get old position in Ox.
     * @return  position in Ox.
     */      
    public double getOldX() {
        return m_old_x;
    }
    
    /**
     * Get old position in Oy.
     * @return position in Oy.
     */    
    public double getOldY() {
       return m_old_y;
    }
    
    /**
     * Mark sprite active.
     * @param b status.
     */    
    public void setActive(boolean b) {
       m_active = b;
    }    
    
    /**
     * Set speed for sprite.
     * @param d1 speed in Ox.
     * @param d2 speed in Oy.
     */    
    public void setSpeed(double d1, double d2) {
        m_horizontal_speed = d1;
        m_vertical_speed = d2;
    }
    
    /**
     * Check if sprite is active.
     * @return status.
     */    
    public boolean isActive() {
        return m_active;
    }
    
    /**
     * Set background for sprite.
     * @param b image background.
     */
    public void setBackground(ImageBackground b) {        
    }
    
    public Ellipse getCollisionShape() {
        return m_shape;        
    }
    
    
    /**
     * Texture.
     */
    Texture m_texture;
    
    /**
     * Form of sprite.
     */
    Ellipse m_shape;
    
    /**
     * X coordinate of center.
     */
    double m_x = 0;
    
    /**
     * Y coordinate of center.
     */
    double m_y = 0;
    
    /**
     * Old X.
     */
    double m_old_x = 0;
    
    /**
     * Old Y.
     */
    double m_old_y = 0;
    
    /**
     * Speed horizontal.
     */
    double m_horizontal_speed = 0;
    
    /**
     * Speed vertical.
     */
    double m_vertical_speed = 0;
    
    protected int angle = 0;
    
    protected double speed = 0;
    
    /**
     * Color of sprite.
     * This color will be fill as a background of icon.
     */
    protected Color color = null;
    
    /**
     * Icon of sprite.
     */
    protected BufferedImage icon = null;    
    
    /**
     * Graphic.
     */
    protected java.awt.Graphics2D g2d;
    
    public boolean m_active;
}
