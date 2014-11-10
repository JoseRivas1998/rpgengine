package com.tcg.rpg;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.tcg.rpg.managers.*;

public class Game extends ApplicationAdapter {
	
	public static Vector2 SIZE, CENTER;
	
	public static Content res;
	
	private int frames;
	private float ftime;
	public static int fps;
	
	public GameStateManager gsm;
	
	public static String NAME;
	
	@Override
	public void create () {
		
		int width, height;
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		
		SIZE = new Vector2(width, height);
		CENTER = new Vector2(width * .5f, height * .5f);
		
		res = new Content();
		
		NAME = "Tiny Country Games RPG Engine";
		
		gsm = new GameStateManager();
		
		Gdx.input.setInputProcessor(new MyInputProcessor());
		Controllers.addListener(new MyControllerProcessor());
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		float dt = Gdx.graphics.getDeltaTime();
		gsm.handleInput();
		gsm.update(dt);
		gsm.draw(dt);
		
		frames++;
		ftime += dt;
		if(ftime >= 1) {
			ftime = 0;
			Game.fps = frames;
			frames = 0;
		}
		
		MyInput.update();
		MyController.update();
	}

	@Override
	public void resize(int width, int height) {
		Game.SIZE.set(width, height);
		Game.CENTER.set(width * .5f, height * .5f);
		gsm.resize(Game.SIZE);
	}

	@Override
	public void dispose() {
		gsm.dispose();
	}
}
