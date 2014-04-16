package gameobjects;

public class Player {
	
	String myName;
	int myMoney;
	
	public Player(String name, int startingMoney){
		myName = name;
		myMoney = startingMoney;
	}
	
	public int getMyMoney(){
		return myMoney;
	}
	
	public String getMyName(){
		return myName;
	}
	
	
}
