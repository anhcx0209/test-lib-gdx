package engine;

import java.util.ArrayList;
import java.util.List;

/**
 * Sprite Group.
 */
public class SpriteGroup {

    /**
     * Constructor.
     * @param string name of sprite group.
     */
    public SpriteGroup(String string) {
        m_name = string;
        m_list = new ArrayList<>();
    }
    
    /**
     * Add a sprite to end of list.
     * @param s sprite.
     */
    public void add(Sprite s) {
        m_list.add(s);
    }
    
    /**
     * Add sprite at position of group.
     * @param i position to add.
     * @param s sprite.
     */
    public void add(int i, Sprite s) {
        m_list.add(i, s);
    }        
    
    /**
     * Remove sprite from group.
     * @param s sprite to remove.
     */
    public void remove(Sprite s) {
        m_list.remove(s);
    }
    
    /**
     * Set background for group.
     * @param bg background.
     */
    public void setBackground(ImageBackground bg) {
        
    }
    
    /**
     * Update attributes of group.
     * @param elapsed period to update.
     */    
    public void update(long elapsed) {
        m_list.stream().forEach((s) -> {
            s.update(elapsed);
        });
        for (int i = m_list.size() - 1; i >= 0; i--)
            if (!m_list.get(i).isActive())
                remove(m_list.get(i)); 
    }
    
    /**
     * Render.
     * @param g graphics context. 
     */
    public void render(Graphics2D g) {
        m_list.stream().forEach((s) -> {
            s.render(g);
        });
    }
    
    /**
     * List all sprite in group.
     * @return list of sprite.
     */
    public List<Sprite> toList() {
        return m_list;
    }
    
    String m_name;
    
    ArrayList<Sprite> m_list;
}
