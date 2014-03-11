package buttons;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MenuButton {
	
	public MenuButton(ShapeRenderer sr, String text, float x, float y , float height, float width){
		sr.rect(x, y, width, height);
	}
}
