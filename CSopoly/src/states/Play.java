package states;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import main.Game;

import org.lwjgl.opengl.GL11;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import gameobjects.GameBoard;
import gameobjects.Player;
import handlers.GameStateManager;

public class Play extends GameState {

	//If you don't know what this is, you might want to learn more about Java
	Random random = new Random();

	GameBoard myGameBoard;
	SpriteBatch batch;

	private Texture goPiece = new Texture(
			Gdx.files.internal("src/assets/BoardSprites/GO.png"));
	ArrayList<Player> playerList;

	boolean gameStart = true;
	boolean gameGoing = false;
	boolean gameEnd = false;

	public Play(GameStateManager gsm) {
		super(gsm);
		batch = new SpriteBatch();

		playerList = new ArrayList<Player>();

		// Initializes the list of players
		for (int i = 0; i < 4; i++) {
			playerList.add(new Player("Player " + (i + 1), 1500));
		}
		
	}

	@Override
	public void handleInput() {

	}

	int currentPlayer = 0;
	
	@Override
	public void update(float dt) {
		// Signals start of game
		if (gameStart) {
			System.out.println("Game Starting");
			gameStart = false;
			playerSort(0, playerList.size() - 1);
			gameStart = false;
			gameGoing = true;
			
		}
		
		while(gameGoing) {
			//Start on Player 1 / Move to player x
			String[] animals = {"cat", "mouse", "frog", "dog", "dog"};
			
			ExecuteMove(playerList.get(0));
			
			//Switch Player
			
			//Any players have 0 money. gameGoing equals false.
			for(int i = 0; i < playerList.size(); i++){
				if(playerList.get(i).getMyMoney() == 0) {
					gameGoing = false;
				}
			}
		}
		

		// TODO End of Game
		if (gameEnd) {
			System.out.println("Player X has won!");
		}
	}
    
	private void ExecuteMove(Player player) {
		// TODO Auto-generated method stub
		
	}

	private int playerTurn(Player player) {
		
		int rollDice; 
		System.out.println("Test");
		int choosenMove = 0;
		
		
		while(choosenMove == 0){
		
		}
		
		//Trading
		if(choosenMove == 1){
			
		}
		return 0;
	}
	

	// TODO: Determine dice roll accurately.
	private int rollDice() {
		return ((random.nextInt(6) + 1) + (random.nextInt(6) + 1));
	}

	private void playerSort(int indexFirst, int indexSecond) {

		//Create an array of rolls based on number of people rolling.
		int arraySize = indexSecond - indexFirst + 1;
		
		int[] rollArray = generateRollArray(arraySize);
		
		printRolls(rollArray, arraySize, indexFirst);
		
		//Sort the arrays of rolls and the list which corresponds to rolls.
		sortArray(rollArray, indexFirst);
		printPlayerList();
		
		//Partition list. IndexFirst should have the same index the first number repeated. IndexSecond should have the same index as the last number repeated
		partionList(rollArray, arraySize, indexFirst, indexSecond);
	}
	
	private void partionList(int[] rollArray, int arraySize, int indexFirst,
			int indexSecond) {
		
		//Go through list of roll, find the first set of repeats.
		for(int i = 0; i < arraySize; i++){
			boolean repeatStart = true;
			boolean partionStart = false;
			int first = -1;
			int second = -1;
			
			//Find the first set of repeated values
			for(int j = i + 1; j < arraySize; j++) {
				
				//Gets first index of repeated values.
				if(rollArray[i] == rollArray[j]) {
					if(repeatStart){
						first = i + indexFirst;
						repeatStart = false;
						partionStart = true;
					}
					//Gets second index of repeated values.
					second = j + indexFirst;
				}
				
				
			}
			//Recursively do a playerSort on the first set of repeated values. Change index to end value
			if(partionStart) {
				playerSort(first, second);
				i = second - indexFirst;
			}
		}
		
	}

	private void printRolls(int[] rollArray, int arraySize, int indexFirst) {
		for(int i = 0; i < arraySize; i++) {
			System.out.println(playerList.get((i + indexFirst)).getMyName() + " has rolled a " + rollArray[i]);
		}		
		System.out.println();
	}
	
	private void printPlayerList(){
		System.out.println("Player List Order");
		System.out.println("-----------------------------");
		for(int i = 0; i < playerList.size(); i++){
			System.out.println(playerList.get(i).getMyName());
		}
	}

	private int[] generateRollArray(int arraySize){
		
		int[] returnedRolls = new int[arraySize];
		
		for(int i = 0; i < arraySize; i++) {
			returnedRolls[i] = ((random.nextInt(6) + 1) + (random.nextInt(6) + 1));
		}
		return returnedRolls;
	}
	
	//Param: An Array
	//Return: Returns parameter sorted
	//NOTE: This is an insertion sort
	private void sortArray(int[] arr, int playerListFirst){
		int i;
		int j;
		int k;
		int l;
		int ARRAYLEN = arr.length;
		int key;
		Player playerKey;
		
		for(i = 0; i < ARRAYLEN; i++){
			
			k = playerListFirst + i;
			
			key = arr[i];
			playerKey = playerList.get(k);
			
			for(j = i - 1; (j >= 0) && (arr[j] < key); j--){
				l = playerListFirst + j;
				arr[j + 1] = arr[j];
				playerList.set(l + 1, playerList.get(l));
			}
			
			l = playerListFirst + j;
			arr[j + 1] = key;
			playerList.set(l + 1, playerKey);
		}
	
	}

	@Override
	public void render() {

		// Documentation for clear color
		// http://www.opengl.org/sdk/docs/man2/xhtml/glClearColor.xml
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL11.GL_COLOR_BUFFER_BIT);

		// Notes
		// Rectangles: 35px x 65px
		// Squares: 65px x 65px
		ShapeRenderer myShapeRenderer = new ShapeRenderer();
		myShapeRenderer.begin(ShapeType.Line);
		myShapeRenderer.setColor(Color.BLACK);
		for (int i = 0; i < 9; i++) {
			myShapeRenderer.rect((35 * i) + 65, 0, 35, 65);
			myShapeRenderer.rect((35 * i) + 65, 380, 35, 65);
			myShapeRenderer.rect(0, (35 * i) + 65, 65, 35);
			myShapeRenderer.rect(380, (35 * i) + 65, 65, 35);
		}

		myShapeRenderer.rect(0, 0, 65, 65);
		batch.begin();
		batch.draw(goPiece, 380, 0, 65, 65);
		batch.end();
		myShapeRenderer.rect(380, 380, 65, 65);
		myShapeRenderer.rect(0, 380, 65, 65);
		myShapeRenderer.end();

	}

	@Override
	public void dispose() {

	}

}
