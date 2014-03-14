package gameobjects;

import java.util.ArrayList;

public class GameBoard {

	int myWidth;
	int myHeight;
	ArrayList<Player> playerList;
	
	//Constructor
	public GameBoard(int width, int height){
		myWidth = width;
		myHeight = height;
		playerList = new ArrayList<Player>();
	}
	
	public void addPlayer(Player player){
		playerList.add(player);
	}
	
	private int getPlayerListSize(){
		return playerList.size();
	}
	
}
