package handlers;

import java.util.Stack;

import com.badlogic.gdx.Gdx;

import states.Exit;
import states.GameState;
import states.Menu;
import states.Options;
import states.Play;
import main.Game;

public class GameStateManager {
	public Game game;
	
	private Stack<GameState> gameStates;
	
	//The different game states you can choose from.
	public static final int PLAY = 1;
	public static final int OPTIONS = 2;
	public static final int CREDITS = 3;
	public static final int EXIT = 4;
	public static final int MENU = 5;
	
	public GameStateManager(Game game) {
		this.game = game;
		gameStates = new Stack<GameState>();
		pushState(MENU);
	}
	
	public Game game() {
		return game;
	}
	
	public void update(float dt) {
		gameStates.peek().update(dt);
	}
	
	public void render() {
		gameStates.peek().render();
	}
	
	private GameState getState(int state) {
		
		if(state == PLAY) {
			return new Play(this);
		}
		
		//TODO Create an options class
		if(state == OPTIONS) {
			return new Options(this);
		}
		
		//TODO Create a credits class
		if(state == CREDITS){
			return new Play(this);
		}
		
		if(state == MENU) {
			return new Menu(this);
		}
		
		if(state == EXIT) {
			return new Exit(this);
		}
		
		return null;
	}
	
	//Used to change between the different states
	public void setState(int state) {
		popState();
		pushState(state);
	}
	
	public void pushState(int state) {
		gameStates.push(getState(state));
	}
	
	public void popState() {
		GameState g = gameStates.pop();
		g.dispose();	
	}
}
