package states;

import org.lwjgl.opengl.GL11;

import com.badlogic.gdx.Gdx;
import handlers.GameStateManager;

public class Play extends GameState{
	
	public Play(GameStateManager gsm){
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
		//Documentation for clear color
		//http://www.opengl.org/sdk/docs/man2/xhtml/glClearColor.xml
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
	}

	@Override
	public void dispose() {
		
	}

}
