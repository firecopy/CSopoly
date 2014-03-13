package handlers;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class InputHandler implements ApplicationListener {

	GameStateManager myGsm;
	public InputHandler(GameStateManager gsm){
		myGsm = gsm;
	}
	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)){
            	myGsm.setState(1);
            }
            else{
            	myGsm.setState(1);
            }
                
        }
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
