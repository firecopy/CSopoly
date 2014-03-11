package buttons;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MenuButton {
	
	//Traits of the buttons
	private float myX;
	private float myY;
	private float myHeight;
	private float myWidth;
	private String myName;
	private boolean isDrawn;
	
	//Constructor
	public MenuButton(String text, float x, float y , float height, float width){
		myName = text;
		myX = x;
		myY = y;
		myHeight = height;
		myWidth = width;
		isDrawn = false;
	}
	
	//Getter methods
	public float getX(){
		return myX;
	}
	
	public float getY(){
		return myY;
	}
	
	public float getHeight(){
		return myHeight;
	}
	
	public float getWidth(){
		return myWidth;
	}
	
	public String getName(){
		return myName;
	}
	
	public boolean getIsDrawn(){
		return isDrawn;
	}
}
