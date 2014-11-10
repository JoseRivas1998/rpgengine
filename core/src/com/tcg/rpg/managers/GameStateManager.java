package com.tcg.rpg.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.tcg.rpg.Game;
import com.tcg.rpg.MyCamera;
import com.tcg.rpg.gamestates.*;

public class GameStateManager {

	private GameState state;
	private MyCamera fpscam;
	
	private SpriteBatch sb;
	private ShapeRenderer sr;
	
	public final int SPLASH = 0;
	public final int TITLE = 1;
	public final int PLAY = 2;
	
	private boolean fps;
	
	
	public GameStateManager() {
		sb = new SpriteBatch();
		sr = new ShapeRenderer();
		fpscam = new MyCamera(Game.SIZE);
		fpscam.translate(Game.CENTER);
		fpscam.update();
		fps = false;
		setState(PLAY);
	}
	
	public void setState(int newState) {
		if(state != null) state.dispose();
		if(newState == SPLASH) {
			state = new PlayState(this);
		}
		if(newState == TITLE) {
			state = new TitleState(this);
		}
		if(newState == PLAY) {
			state = new PlayState(this);
		}
	}
	
	public void handleInput() {
		state.handleInput();
		if(MyInput.isPressed(MyInput.FPS)) fps = !fps;
	}
	
	public void update(float dt) {
		state.update(dt);
	}
	
	public void draw(float dt) {
		state.draw(sb, sr, dt);
		if(fps) {
			Gdx.graphics.setTitle(Game.NAME + " | " + Game.fps + " fps");
			sb.begin();
			sb.setProjectionMatrix(fpscam.combined);
			//TODO draw fps top left
			sb.end();
		} else {
			Gdx.graphics.setTitle(Game.NAME);
		}
	}

	public void resize(Vector2 size) {
		fpscam.resize(size, true);
		state.resize(size);
	}
	
	public void dispose() {
		state.dispose();
		sb.dispose();
		sr.dispose();
	}
	
}
