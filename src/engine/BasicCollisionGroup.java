package engine;

import java.util.List;

/**
 * Group for detecting collision between 2 group of sprite.
 */
public class BasicCollisionGroup {
    
    /**
     * Default Constructor.
     */
    public BasicCollisionGroup() {
        
    }
    
    /**
     * Check if has collision between 2 group.
     */   
    public void checkCollision() {
        if (m_group1 != null && m_group2 != null) {
            List<Sprite> sprites1 = m_group1.toList();
            List<Sprite> sprites2 = m_group2.toList();
            for (int i = 0; i < sprites1.size(); i++) {
                for (int j = 0; j < sprites2.size(); j++) {
                    Sprite s1 = sprites1.get(i);
                    Sprite s2 = sprites2.get(j);                    
                    if (s1 != s2) {
                        if (s1.getCollisionShape().collidesWith(s2.getCollisionShape())) {
                            this.collided(s1, s2);
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Set two group to check collision.
     * @param s1 first sprite group
     * @param s2 second sprite group
     */
    public void setCollisionGroup(SpriteGroup s1, SpriteGroup s2) {
        m_group1 = s1;
        m_group2 = s2;
    }
    
    /**
     * Solve collision.
     * @param first first sprite
     * @param second second sprite
     */    
    public void collided(Sprite first, Sprite second) {
        
    }
    
    /**
     * First group.
     */
    SpriteGroup m_group1;
    
    /**
     * Second group.
     */
    SpriteGroup m_group2;  
}