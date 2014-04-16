package states;

import org.lwjgl.opengl.GL11;

import com.badlogic.gdx.Gdx;

import handlers.GameStateManager;

public class Options extends GameState {

	public Options(GameStateManager gsm) {
		super(gsm);
	}
	
	@Override
	public void handleInput() {
		
	}

	@Override
	public void update(float dt) {
		
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL11.GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void dispose() {
		
	}

}
