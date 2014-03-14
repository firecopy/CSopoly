package gameobjects;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class PlayerToken {
	
	String myColor;
	Sprite mySprite;
	
	//Constructor
	public PlayerToken(String color, Sprite sprite){
		myColor = color;
		mySprite = sprite;
	}
}
