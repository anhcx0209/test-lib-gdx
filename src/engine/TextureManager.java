package engine;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


/**
 * Texture manager.
 * @author anhcx
 */
public class TextureManager {
    
    /**
     * Pair texture and image
     */
    static class Entry {
        /**
         * Texture
         */
        Texture m_texture;
        /**
         * BufferedImage
         */
        BufferedImage m_image;
    }
    
    /**
     * Convert image to texture.
     * @param img image
     * @return texture
     */
    public static Texture imageToTexture(BufferedImage img) {
        Pixmap px = new Pixmap(img.getWidth(), img.getHeight(), Pixmap.Format.RGBA8888);
        Pixmap.setBlending(Pixmap.Blending.None);
        px.setColor(Color.CYAN);
        for(int i = 0; i < img.getWidth(); i++) {
            for(int j = 0; j < img.getHeight(); j++) {
                int color = img.getRGB(i, j);
                int red = (color & 0x00ff0000) >> 16;
                int green = (color & 0x0000ff00) >> 8;
                int blue = color & 0x000000ff;
                int alpha = (color >> 24) & 0xff;
                px.setColor(red / 255.0f, green / 255.0f, blue / 255.0f, alpha / 255.0f);
                px.drawPixel(i, j);
            }
        }
        return new Texture(px);
    }
    
    /**
     * Get texture from image.
     * @param img image
     * @return texture
     */
    public static Texture getTexture(BufferedImage img) {
        if (m_entries == null) {
            m_entries = new ArrayList<>();
        }
        for (Entry m_entry : m_entries) {
            if (m_entry.m_image == img) {
                return m_entry.m_texture;
            }            
        }
        Texture tex = TextureManager.imageToTexture(img);
        Entry e = new Entry();
        e.m_image = img;
        e.m_texture = tex;
        m_entries.add(e);
        return e.m_texture;
    }
        
    /**
     * Dispose textures.
     */
    public static void disposeTextures() {
        if (m_entries != null) {
            m_entries.stream().forEach((m_entry) -> {
                m_entry.m_texture.dispose();
            });            
        }
    }
            
    /**
     * Entries.
     */
    static List<Entry> m_entries;    
}
