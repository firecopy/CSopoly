package main;

//libGDX libraries

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopGame {
	public static void main(String[] args){
		
		//Configuration file for the game. Sets the frame size and name.
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = Game.TITLE;
		cfg.width = Game.V_WIDTH * Game.SCALE;
		cfg.height = Game.V_HEIGHT * Game.SCALE;
		
		//Not using GL30. Set to false to speed up loading of game.
		cfg.useGL30 = false;
		
		//Prevents resizing of frame.
		cfg.resizable = false;
		
		//Creates the game frame.
		new LwjglApplication(new Game(), cfg);
	}

}
