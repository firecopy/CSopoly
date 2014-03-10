package states;

import org.lwjgl.opengl.GL11;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import handlers.GameStateManager;

public class Play extends GameState{

	private BitmapFont font = new BitmapFont();
	
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
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL11.GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void dispose() {
		
	}

}
