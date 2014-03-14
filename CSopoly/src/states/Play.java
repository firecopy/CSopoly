package states;

import org.lwjgl.opengl.GL11;

import com.badlogic.gdx.Gdx;

import gameobjects.GameBoard;
import gameobjects.Player;
import handlers.GameStateManager;

public class Play extends GameState{
	
	GameBoard myGameBoard;
	
	public Play(GameStateManager gsm){
		super(gsm);
		
		// Creates the Game board and players
		myGameBoard = new GameBoard(10, 10);
		myGameBoard.addPlayer(new Player("Player 1", 1500));
		myGameBoard.addPlayer(new Player("Player 2", 1500));
		myGameBoard.addPlayer(new Player("Player 3", 1500));
		myGameBoard.addPlayer(new Player("Player 4", 1500));
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
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		
		
	}

	@Override
	public void dispose() {
		
	}

}
