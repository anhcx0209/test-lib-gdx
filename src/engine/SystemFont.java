package engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Color;

/**
 * System font for write text.
 */
public class SystemFont {
    
    /**
     * Constructor.
     * @param fontName font name.
     * @param attrs attributes.
     * @param size font size.
     * @param clr  color.
     */
    public SystemFont(String fontName, int attrs, int size, java.awt.Color clr) {
        m_font = new BitmapFont();
        m_font.setColor(new Color(
                clr.getRed() / 255.0f, 
                clr.getGreen() / 255.0f,
                clr.getBlue() / 255.0f,
                clr.getAlpha() / 255.0f
        ));
    }
    
    /**
     * Render.
     * @param g context.
     * @param data data.
     * @param x x coordinate of position.
     * @param y y coordinate of position.
     */
    public void drawString(Graphics2D g, String data, int x, int y) {
        float px = x + (Game.m_current_camera.position.x - Gdx.graphics.getWidth() / 2);
        float py =  (Gdx.graphics.getHeight() - y) 
                 + (Game.m_current_camera.position.y - Gdx.graphics.getHeight() / 2);
        m_font.draw(
            g.getBatch(), 
            data, 
            px, 
            py
        );
    }
    
    BitmapFont m_font;
}
