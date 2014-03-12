package states;

import main.Game;

import org.lwjgl.opengl.GL11;

import buttons.MenuButton;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.openal.Mp3.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import handlers.GameStateManager;

public class Menu extends GameState {

	//Used to manage shapes, textures, and text
	ShapeRenderer myShapeRenderer = new ShapeRenderer();
	SpriteBatch mySpriteBatch = new SpriteBatch();
	
	BitmapFont titleFont = new BitmapFont();
	BitmapFont buttonFont = new BitmapFont();
	
	int buttonFontSize = 24;
	
	public Menu(GameStateManager gsm) {
		super(gsm);
		FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("src/assets/fonts/BASIF___.ttf"));
		buttonFont = fontGenerator.generateFont(buttonFontSize);
		titleFont = fontGenerator.generateFont(50);
		fontGenerator.dispose();
	}

	@Override
	public void handleInput() {
		
	}

	@Override
	public void update(float dt) {
		
	}

	@Override
	public void render() {
		
		int screenWidth = Game.V_WIDTH * Game.SCALE;
		int screenHeight = Game.V_WIDTH * Game.SCALE;
		
		//Documentation for clear color
		//http://www.opengl.org/sdk/docs/man2/xhtml/glClearColor.xml
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		buttonFont.setColor(0.0f, 0.0f, 0.0f, 1.0f);
		titleFont.setColor(0.0f, 0.0f, 0.0f, 1.0f);
		
		myShapeRenderer.begin(ShapeType.Line);
		mySpriteBatch.begin();
		
		myShapeRenderer.setColor(Color.BLACK);
		
		//Draws buttons on screen
		int standardbuttonHeight = 45;
		int standardButtonWidth = Game.V_WIDTH / 14 * 13;
		
		
		//My font Generator, used to create different sized fonts.
		//All fonts downloaded from openfontlibrary.org and 1001 Free Fonts
	
		//TODO Deprecated. Find some other way to read fonts

		buttonFont.setColor(Color.BLACK);
		titleFont.setColor(Color.BLACK);
		MenuButton playButton = new MenuButton("Play", Game.V_WIDTH / 2, Game.V_HEIGHT * Game.SCALE / 15 * 12, standardbuttonHeight, standardButtonWidth);
		MenuButton optionsButton = new MenuButton("Options", Game.V_WIDTH / 2, Game.V_HEIGHT * Game.SCALE / 15 * 10, standardbuttonHeight, standardButtonWidth);
		MenuButton creditsButton = new MenuButton("Credits", Game.V_WIDTH / 2, Game.V_HEIGHT * Game.SCALE / 15 * 8, standardbuttonHeight, standardButtonWidth);
		MenuButton exitButton = new MenuButton("Exit", Game.V_WIDTH / 2, Game.V_HEIGHT * Game.SCALE / 15 * 6, standardbuttonHeight, standardButtonWidth);
	
		drawButton(playButton);
		drawButton(optionsButton);
		drawButton(creditsButton);
		drawButton(exitButton);
		
		titleFont.draw(mySpriteBatch, "CSopoly", 50, 100);
		
		mySpriteBatch.end();
		myShapeRenderer.end();


		
	}

	@Override
	public void dispose() {
		
	}
	
	//Draws the selected button
	private void drawButton(MenuButton button){
		if(!button.getIsDrawn()){
			myShapeRenderer.setColor(Color.BLACK);

			float buttonX = button.getX();
			float buttonY = button.getY();
			float buttonWidth = button.getWidth();
			float buttonHeight = button.getHeight();
			
			myShapeRenderer.rect(buttonX, buttonY, buttonWidth, buttonHeight);
			buttonFont.draw(mySpriteBatch, button.getName(), buttonX, buttonY + buttonFontSize * 2);
		}
		else {
			//Prevents drawing of multiple buttons
			System.out.println(button.getName() + " is already drawn");
		}
	}

}
