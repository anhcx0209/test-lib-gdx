package engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;


/**
 * Game Object.
 */
public abstract class GameObject {
    
    Scene m_scene;
    
    public GameEngine parent;
    
    /**
     * Default constructor.
     * @param ge
     */
    public GameObject(GameEngine ge) {
        parent = ge;
        m_scene = new Scene(this);
        MyInputProcessor inputProcessor = new MyInputProcessor();
        Gdx.input.setInputProcessor(inputProcessor);
    }
    
    public void renderInContext(Graphics2D g2d) {
        
    }
    
    /**
     * Get parent of this game object.
     * @return Game engine.
     */
    public GameEngine getParent() {
        return parent;
    }
    
    public boolean keyPressed(int i) {
        if (i == Input.Keys.ENTER) {
            return true;            
        } else {            
            return false;
        }
    }
    
    /**
     * Stop this game.
     */    
    public void finish() {
        this.m_scene.dispose();
        parent.m_game.setScreen(parent.getGame(parent.nextGameID).m_scene);
    }
    
    /**
     * Handle click.
     * @return boolean
     */    
    public boolean click() {
        return m_click;   
    }        
    
    /**
     * Get x coordinate of mouse position.
     * @return coordinate in Ox.
     */    
    public int getMouseX() {
        return Gdx.input.getX() - Gdx.graphics.getWidth() / 2;
    }
    
    /**
     * Get y coordinate of mouse position.
     * @return coordinate in Oy.
     */    
    public int getMouseY() {
        return (Gdx.graphics.getHeight() / 2 - Gdx.input.getY());
    }
    
    /**
     * Abstract of initial resource.
     */    
    public abstract void initResources();
    
    /**
     * Abstract of update.
     * @param l
     */    
    public abstract void update(long l);
    
    /**
     * Abstract of render.
     * @param gd
     */    
    public void render(java.awt.Graphics2D gd) {
        
    }
    
    private class MyInputProcessor implements InputProcessor {
        @Override
        public boolean touchDown(int x, int y, int pointer, int button) {
            if (button == Input.Buttons.LEFT) {
                m_click = true;
                return true;
            }
            return false;
        }

        @Override
        public boolean keyDown(int i) {
            return false;
        }

        @Override
        public boolean keyUp(int i) {
            m_keycode = i;            
            return false;
        }

        @Override
        public boolean keyTyped(char c) {
            return false;
        }

        @Override
        public boolean touchUp(int i, int i1, int i2, int i3) {
            return false;
        }

        @Override
        public boolean touchDragged(int i, int i1, int i2) {
            return false;
        }

        @Override
        public boolean mouseMoved(int i, int i1) {
            return false;
        }

        @Override
        public boolean scrolled(int i) {
            return false;
        }
    }
    
    private boolean m_click = false;
    private int m_keycode = -1;
}
