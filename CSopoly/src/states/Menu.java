package states;

import org.lwjgl.opengl.GL11;

import buttons.MenuButton;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import handlers.GameStateManager;

public class Menu extends GameState {

	public Menu(GameStateManager gsm) {
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
		
		//Draws buttons on screen
		ShapeRenderer myShapeRenderer = new ShapeRenderer();
		
		myShapeRenderer.begin(ShapeType.Line);
		myShapeRenderer.setColor(Color.BLACK);
		//Draws buttons on screen
		MenuButton test = new MenuButton(myShapeRenderer, "", 50, 50, 50, 50);
		myShapeRenderer.end();
	}

	@Override
	public void dispose() {
		
	}

}
