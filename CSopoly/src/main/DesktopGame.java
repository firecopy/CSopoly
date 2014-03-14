package main;

//libGDX libraries
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

//Citation:
//Sources used: Libgdx documentation and ForeignGuyMike LibGDX tutorial
//series
//My font Generator, used to create different sized fonts.
//All fonts downloaded from openfontlibrary.org and 1001 Free Fonts

public class DesktopGame {
	public static void main(String[] args){
		
		//Configuration file for the game. Sets the frame size and name.
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = Game.TITLE;
		
		//WIDTH = 640
		// HEIGHT = 480
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
