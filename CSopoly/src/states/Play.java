package states;

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
		sb.setProjectionMatrix(cam.combined);
		sb.begin();
		font.draw(sb, "Test", 100, 100);
		sb.end();
	}

	@Override
	public void dispose() {
		
	}

}
