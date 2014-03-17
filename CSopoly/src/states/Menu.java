package states;

import java.util.ArrayList;

import main.Game;

import org.lwjgl.opengl.GL11;

import buttons.MenuButton;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import handlers.GameStateManager;
import handlers.GameKeys;

public class Menu extends GameState {

	//Used to manage shapes, textures, and text
	ShapeRenderer myShapeRenderer;
	SpriteBatch mySpriteBatch;

	BitmapFont titleFont;
	BitmapFont buttonFont;
	
	private final String title = "CSopoly";
	
	private int selectedButton;
	
	//Game screen width and height
	int screenWidth = Game.V_WIDTH * Game.SCALE;
	int screenHeight = Game.V_HEIGHT * Game.SCALE;
	
	//Button height and width, reused for each button.
	int standardButtonHeight = screenHeight / 19 * 2;
	int standardButtonWidth = Game.V_WIDTH / 14 * 13;
	
	//Button List
	ArrayList<MenuButton> menuButtonList = new ArrayList<MenuButton>();
	
	//The different Buttons
	MenuButton playButton = new MenuButton("Play", Game.V_WIDTH / 2, standardButtonHeight / 2 * 11, standardButtonHeight, standardButtonWidth);
	MenuButton optionsButton = new MenuButton("Options", Game.V_WIDTH / 2, standardButtonHeight / 2 * 8, standardButtonHeight, standardButtonWidth);
	MenuButton creditsButton = new MenuButton("Credits", Game.V_WIDTH / 2, standardButtonHeight / 2 * 5, standardButtonHeight, standardButtonWidth);
	MenuButton exitButton = new MenuButton("Exit", Game.V_WIDTH / 2, standardButtonHeight / 2 * 2, standardButtonHeight, standardButtonWidth);
	
	//Font for buttons
	int buttonFontSize = Game.V_HEIGHT / 19 * 2;
	
	GameKeys inputHandler;
	
	//Constructor
	public Menu(GameStateManager gsm) {
		super(gsm);
		
		selectedButton = 1;
		
		FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("src/assets/fonts/BASIF___.ttf"));
		
		//Used to manage shape and textures
		myShapeRenderer = new ShapeRenderer();
		mySpriteBatch = new SpriteBatch();
		
		//Initializes fonts used
		buttonFont = fontGenerator.generateFont(buttonFontSize);
		titleFont = fontGenerator.generateFont(buttonFontSize * 2);
		
		titleFont.setColor(Color.BLACK);
		
		//Stops generating fonts
		fontGenerator.dispose();
		
		//Adds buttons to the button list
		menuButtonList.add(playButton);
		menuButtonList.add(optionsButton);
		menuButtonList.add(creditsButton);
		menuButtonList.add(exitButton);
	}

	
	
	//We want values between 1 and 4
	@Override
	public void handleInput() {

		if(GameKeys.isPressed(GameKeys.UP)){
			if(selectedButton > 1) {
				selectedButton--;
			}
		}
		if(GameKeys.isPressed(GameKeys.DOWN)){
			if(selectedButton < 4 ){
				selectedButton++;
			}
		}
		if(GameKeys.isPressed(GameKeys.ENTER)){
			select();
		}
		
	}
	
	private void select(){
		gsm.setState(selectedButton);
	}

	@Override
	public void update(float dt) {
		handleInput();
	}

	Double t = 0.0;
	
	@Override
	public void render() {
		
		//Documentation for clear color
		//http://www.opengl.org/sdk/docs/man2/xhtml/glClearColor.xml
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		buttonFont.setColor(0.0f, 0.0f, 0.0f, 1.0f);
		
		titleFont.setColor(0.0f, 0.0f, 0.0f, 1.0f);
		
		myShapeRenderer.begin(ShapeType.Line);
		mySpriteBatch.begin();
		
		myShapeRenderer.setColor(Color.BLACK);
		
		//The Background
		if(t <= 360){ t += 0.02;} else{
			t = 0.0;
		}
		
		myShapeRenderer.rect((int)((Math.cos(t) * (screenWidth/2)) + (screenWidth/2) - 25), (int)((Math.sin(t) * (screenHeight/2)) + (screenHeight/2) - 25), 50, 50, 0, 0, 0);
		myShapeRenderer.rect((int)((Math.cos(t) * (screenWidth/4)) + (screenWidth/2) - 25), (int)((-1 * Math.sin(t) * (screenHeight/4)) + (screenHeight/2) - 25), 50, 50, 0, 0, 0);
		myShapeRenderer.rect((int)((Math.cos(t) * (screenWidth/8)) + (screenWidth/2) - 25), (int)((Math.sin(t) * (screenHeight/8)) + (screenHeight/2) - 25), 50, 50, 0, 0, 0);
		
		//Draws title
		titleFont.draw(mySpriteBatch, title , Game.V_WIDTH / 2, standardButtonHeight / 2 * 17);
		
		//Goes through buttons, highlighting the selected one.
		//Fix Fast Buttons
		for(int i = 0; i < menuButtonList.size(); i++){
			if(i == selectedButton - 1) {
				buttonFont.setColor(Color.GREEN);
			} else {
				buttonFont.setColor(Color.RED);
			}
			drawButton(menuButtonList.get(i));
		}
		/*
		buttonFont.setColor(Color.GREEN);
		drawButton(playButton);
		drawButton(optionsButton);
		drawButton(creditsButton);
		drawButton(exitButton);
		*/
		mySpriteBatch.end();
		
		/*//Rectangle Test
		myShapeRenderer.rect( (int) (100 *Math.cos(t)) + (int)(screenWidth/2 + t),(int) (50 *Math.sin(t * t)) + (int)(t+ screenHeight/2),50, 50);
		myShapeRenderer.rect( (int) (100 *Math.cos(t * t)) + (int)(screenWidth/2 + t),(int) (50 *Math.sin(t)) + (int)(t+ screenHeight/2),50, 50);
		myShapeRenderer.rect( (int) (50 *Math.cos(t * t)) + (int)(screenWidth/2 + t),(int) (50 *Math.sin(t * t)) + (int)(t+ screenHeight/2),50, 50);
		myShapeRenderer.rect( (int) (t *Math.cos(t * t)) + (int)(screenWidth/2 + t),(int) (t * Math.sin(t * t)) + (int)(t+ screenHeight/2),50, 50);
		myShapeRenderer.rect( (int) (t *Math.cos(t * t)) + (int)(screenWidth/2 + t - 30),(int) (t * Math.sin(t * t)) + (int)(t+ screenHeight/2),(int) (t * Math.sin(t + screenHeight/2)), 50);
		myShapeRenderer.rect( (int) (t *Math.cos(t * t) - 124) + (int)(screenWidth/2 + t - 50), -1 * (int) (t * Math.sin(t * t)) + (int)(t+ screenHeight/2),(int) (t * Math.sin(t + screenHeight/2)), (int) (t *Math.cos(t * screenHeight/2)));
		*/
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
