package com.tcg.rpg.gamestates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.tcg.rpg.Constants;
import com.tcg.rpg.Game;
import com.tcg.rpg.MyCamera;
import com.tcg.rpg.entity.*;
import com.tcg.rpg.managers.GameStateManager;

public class PlayState extends GameState {
	
	MyCamera cam;
	Player p;
	World w;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	protected void init() {
		cam = new MyCamera(Game.SIZE);
		cam.translate(Game.CENTER);
		cam.update();
		p = new Player(Constants.DOWN, Game.CENTER.x, Game.CENTER.y);
		w = new World();
	}

	@Override
	public void update(float dt) {
		p.update(w.getBounds());
		p.updateCamera(cam, w.getWidth(), w.getHeight());

	}

	@Override
	public void draw(SpriteBatch sb, ShapeRenderer sr, float dt) {
		w.draw(cam);
		sb.begin();
		sb.setProjectionMatrix(cam.combined);
		p.draw(sb, sr, dt);
		sb.end();

	}

	@Override
	public void handleInput() {
		p.handleInput();

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(Vector2 size) {
		cam.resize(size, false);

	}

}
