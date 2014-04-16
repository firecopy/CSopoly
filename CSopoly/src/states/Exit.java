package states;

import com.badlogic.gdx.Gdx;

import handlers.GameStateManager;


public class Exit extends GameState {

	public Exit(GameStateManager gsm) {
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
		Gdx.app.exit();

	}

	@Override
	public void dispose() {

	}

}
