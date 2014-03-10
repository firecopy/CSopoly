package main;

//libGDX imports
import handlers.GameStateManager;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game implements ApplicationListener {

	public static final String TITLE = "CSopoly";
	public static final int V_WIDTH = 320;
	public static final int V_HEIGHT = 240;
	public static final int SCALE = 2;
	
	private SpriteBatch sb;
	private OrthographicCamera cam;
	private OrthographicCamera hudCam;
	
	private GameStateManager gsm;
	
	public static final float STEP = 1 / 60f;
	private float accum;
	
	/*
	 * Q: What is @Override?
	 * 
	 * A: @Override is used on a method in a subclass that overridesmethods from
	 * superclass or interfaces. If the subclass method is notoverriding
	 * anything, the compiler throws an error. Therefore, @Override is used to
	 * prevent developers from mistakes involving not properly overriding
	 * methods.
	 */

	@Override
	public void create() {
		
		sb = new SpriteBatch();
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false, V_WIDTH, V_HEIGHT);
		
		hudCam = new OrthographicCamera();
		hudCam.setToOrtho(false, V_WIDTH, V_HEIGHT);
		
		gsm = new GameStateManager(this);
	}

	@Override
	public void render() {
		
		//Time accumuulated is time between frames person
		//seconds
		accum += Gdx.graphics.getDeltaTime();
		
		while(accum >= STEP){
			accum -= STEP;
			gsm.update(STEP);
			gsm.render();
		}
	}
	
	@Override
	public void dispose() {

	}
	
	public SpriteBatch getSpriteBatch() {
		return sb;
	}
	
	public OrthographicCamera getCamera() {
		return cam;
	}
	
	public OrthographicCamera getHUDCamera() {
		return hudCam;
	}

	@Override
	public void pause() {

	}

	@Override
	public void resize(int width, int height) {

	}
	
	@Override
	public void resume() {

	}

}
