package engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Scene.
 * @author anhcx
 */
public class Scene implements Screen {
    
    /** 
     * Game Object.
     */
    final GameObject m_gameObject;

    /** 
     * Camera.
     */
    OrthographicCamera m_camera;
    
    /** 
     * Default constructor.
     * @param gameObject Game Object.
     */
    public Scene(GameObject gameObject){
        m_gameObject = gameObject;
        m_camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        m_camera.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
        m_camera.update();
        
        Game.m_current_camera = m_camera;
    }

    /** 
     * Show game.
     */
    @Override
    public void show() {
        m_gameObject.initResources();
    }

    /**
     * Render game.
     */
    @Override
    public void render(float f) {
        m_camera.update();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        m_gameObject.update((long) (f * 1000.0));
        
        m_gameObject.parent.m_game.m_ctx.getBatch().setProjectionMatrix(m_camera.combined);
        m_gameObject.parent.m_game.m_ctx.begin();
        m_gameObject.renderInContext(m_gameObject.parent.m_game.m_ctx);
        m_gameObject.parent.m_game.m_ctx.end();
    }

    /**
     * Resize game.
     */
    @Override
    public void resize(int i, int i1) {
    }

    /**
     * Pause game.
     */
    @Override
    public void pause() {
    }

    /**
     * Resume game.
     */
    @Override
    public void resume() {
    }

    /**
     * Hide game.
     */
    @Override
    public void hide() { }

    /**
     *  Dispose.
     */
    @Override
    public void dispose() {
        TextureManager.disposeTextures();
    }
}
