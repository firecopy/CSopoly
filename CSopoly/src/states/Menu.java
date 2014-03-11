package states;

import main.Game;

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
		int standardbuttonHeight = 45;
		int standardButtonWidth = Game.V_WIDTH / 14 * 13;
		
		MenuButton playButton = new MenuButton("Play", Game.V_WIDTH / 2, Game.V_HEIGHT * Game.SCALE / 15 * 14, standardbuttonHeight, standardButtonWidth);
		drawButton(playButton, myShapeRenderer);
		myShapeRenderer.end();
	}

	@Override
	public void dispose() {
		
	}
	
	//Draws the selected button
	private void drawButton(MenuButton button, ShapeRenderer sr){
		if(!button.getIsDrawn()){
			sr.setColor(Color.BLACK);
			sr.rect(button.getX(), button.getY(), button.getWidth(), button.getHeight());
		}
		else {
			//Prevents drawing of multiple buttons
			System.out.println(button.getName() + " is already drawn");
		}
	}

}
