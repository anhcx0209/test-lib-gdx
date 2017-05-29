package engine;

import collision.Ellipse;
import collision.Line;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test basic collision
 * @author anhcx
 */
public class BasicCollisionGroupTest {
    
    public BasicCollisionGroupTest() {
    }    

    @Test
    public void testCollision() {
        {
            collision.Math.CollisionPointPair pair = collision.Math.
                getCollisionPointsBetweenLineAndEllipse(0, 1, 0, 0, 0, 1, 1);
            assertEquals(pair.x1, -2.0, 1E-3);
            assertEquals(pair.y1, 0.0, 1E-3);
            assertEquals(pair.x2, 1.0, 1E-3);
            assertEquals(pair.y2, 0.0, 1E-3);
        }
        
        
        {
            collision.Math.CollisionPointPair pair = collision.Math
                    .getCollisionPointsBetweenLineAndEllipse(1, 0, 0, 0, 0, 2, 2);
            assertEquals(pair.x1, 0.0, 1E-3);
            assertEquals(pair.y1, 2.0, 1E-3);
            assertEquals(pair.x2, 0.0, 1E-3);
            assertEquals(pair.y2, -2.0, 1E-3);
        }
        
        {
            collision.Math.CollisionPointPair pair = collision.Math.
            getCollisionPointsBetweenLineAndEllipse(0, 1, 0, 0, 0, 2, 1); assertEquals(pair.x1, -2.0, 1E-3);
            assertEquals(pair.y1, 0.0, 1E-3);
            assertEquals(pair.x2, 2.0, 1E-3);
            assertEquals(pair.y2, 0.0, 1E-3);
        }
        {
            collision.Math.CollisionPointPair pair = collision.Math.
            getCollisionPointsBetweenLineAndEllipse(1, 0, 0, 0, 0, 1, 2); assertEquals(pair.x1, 0.0, 1E-3);
            assertEquals(pair.y1, 2.0, 1E-3);
            assertEquals(pair.x2, 0.0, 1E-3);
                    assertEquals(pair.y2, -2.0, 1E-3);
        }
        {
            collision.Math.CollisionPointPair pair = collision.Math.
                    getCollisionPointsBetweenLineAndEllipse(0, 1, 3, 2,
                            3, 2, 1);
            assertEquals(pair.x1, 0.0, 1E-3);
            assertEquals(pair.y1, 3.0, 1E-3);
            assertEquals(pair.x2, 4.0, 1E-3);
            assertEquals(pair.y2, 3.0, 1E-3);
        } 
        {
            collision.Math.CollisionPointPair pair = collision.Math. getCollisionPointsBetweenLineAndEllipse(1, 0, 2, 2, 3, 1, 2);
            assertEquals(pair.x1, 2.0, 1E-3);
            assertEquals(pair.y1, 5.0, 1E-3);
            assertEquals(pair.x2, 2.0, 1E-3);
            assertEquals(pair.y2, 1.0, 1E-3);
        }   
        {
            collision.Math.CollisionPointPair pair = collision.Math
            .getCollisionPointsBetweenLineAndEllipse(1, -1, 0, 2, 2, 2, 2);
            assertEquals(pair.x1, 3.4142, 1E-3);
            assertEquals(pair.y1, 3.4142, 1E-3);
            assertEquals(pair.x2, 0.5857, 1E-3);
            assertEquals(pair.y2, 0.5857, 1E-3);
        }
    }
    
    @Test
    public void testLine() {
        {
            Line l = new Line(1, 0, 1, 1);
            assertEquals(l.k1, 1, 1E-3);
            assertEquals(l.k2, 0, 1E-3);
            assertEquals(l.k3, 1, 1E-3);
        }
        {
            Line l = new Line(1, 1, 1, 1);
            assertEquals(l.k1, 1, 1E-3);
            assertEquals(l.k2, 0, 1E-3);
            assertEquals(l.k3, 1, 1E-3);
        }
        {
            Line l = new Line(0, 1, 1, 1);
            assertEquals(l.k1, 0, 1E-3);
            assertEquals(l.k2, 1, 1E-3);
            assertEquals(l.k3, 1, 1E-3);

        } 
        {
            Line l = new Line(1, 1, 2, 2);
            assertEquals(l.k1, 1, 1E-3);
            assertEquals(l.k2, -1, 1E-3);
            assertEquals(l.k3, 0, 1E-3);
        }
        {
            Line l = new Line(2, 3, 3, 4);
            assertEquals(l.k1, 1, 1E-3);
            assertEquals(l.k2, -1, 1E-3);
            assertEquals(l.k3, -1, 1E-3);
        }
    }
    
    @Test
    public void testEllipses() {
        assertTrue((new Ellipse(0, 0, 2, 1)).collidesWith(new Ellipse(0, 0, 2, 1)));
        assertTrue((new Ellipse(0, 0, 2, 1)).collidesWith(new Ellipse(0, 3, 2, 1))); 
        assertTrue((new Ellipse(0, 0, 2, 1)).collidesWith(new Ellipse(0, 4, 2, 1))); 
        assertFalse((new Ellipse(0, 0, 2, 1)).collidesWith(new Ellipse(0, 5, 2, 1)));
    }
    
}
