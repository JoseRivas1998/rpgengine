package com.tcg.rpg.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.tcg.rpg.Constants;
import com.tcg.rpg.MyCamera;
import com.tcg.rpg.managers.MyInput;

public class Player extends Entity {

	public boolean running, walking;
	
	private Vector2 vel;
	
	private Animation wl, wr, wu, wd, rl, rr, ru, rd;
	private float stateTime = 0;
	private TextureRegion r, l, u, d, currentFrame;
	
	private final float WALK_SPEED = 5;
	private final float RUN_SPEED = 10;
	
	private Rectangle ls, rs, us, ds;
	
	public Player(int direction, float x, float y) {
		super(direction);
		init(x, y);
    	vel = new Vector2(0, 0);
    	
    	stateTime = 0;
	}
	
	private void init(float x, float y) {
		bounds.x = x;
		bounds.y = y;
		ls = new Rectangle();
		rs = new Rectangle();
		us = new Rectangle();
		ds = new Rectangle();
		createAnimations();
	}
	
	private void createAnimations() {
		String wp = "entities/player/walk/";
		int numwuFrames = 4;
    	Texture wutemp = new Texture(wp + "up.png");
    	TextureRegion[] wuframes = TextureRegion.split(wutemp, wutemp.getWidth() / numwuFrames, wutemp.getHeight())[0];
    	

		int numwrFrames = 4;
    	Texture wrtemp = new Texture(wp + "right.png");
    	TextureRegion[] wrframes = TextureRegion.split(wrtemp, wrtemp.getWidth() / numwrFrames, wrtemp.getHeight())[0];
    	

		int numwlFrames = 4;
    	Texture wltemp = new Texture(wp + "left.png");
    	TextureRegion[] wlframes = TextureRegion.split(wltemp, wltemp.getWidth() / numwlFrames, wltemp.getHeight())[0];
    	

		int numwdFrames = 4;
    	Texture wdtemp = new Texture(wp + "down.png");
    	TextureRegion[] wdframes = TextureRegion.split(wdtemp, wdtemp.getWidth() / numwdFrames, wdtemp.getHeight())[0];

		
		String rp = "entities/player/run/";
		int numruFrames = 4;
    	Texture rutemp = new Texture(rp + "up.png");
    	TextureRegion[] ruframes = TextureRegion.split(rutemp, rutemp.getWidth() / numruFrames, rutemp.getHeight())[0];
    	

		int numrrFrames = 4;
    	Texture rrtemp = new Texture(rp + "right.png");
    	TextureRegion[] rrframes = TextureRegion.split(rrtemp, rrtemp.getWidth() / numrrFrames, rrtemp.getHeight())[0];
    	

		int numrlFrames = 4;
    	Texture rltemp = new Texture(rp + "left.png");
    	TextureRegion[] rlframes = TextureRegion.split(rltemp, rltemp.getWidth() / numrlFrames, rltemp.getHeight())[0];
    	

		int numrdFrames = 4;
    	Texture rdtemp = new Texture(rp + "down.png");
    	TextureRegion[] rdframes = TextureRegion.split(rdtemp, rdtemp.getWidth() / numrdFrames, rdtemp.getHeight())[0];
    	
    	
    	wl = new Animation(.25f, wlframes);
    	wr = new Animation(.25f, wrframes);
    	wu = new Animation(.25f, wuframes);
    	wd = new Animation(.25f, wdframes);
    	rd = new Animation(.075f, rdframes);
    	ru = new Animation(.075f, ruframes);
    	rr = new Animation(.075f, rrframes);
    	rl = new Animation(.075f, rlframes);
    	
    	String ip = "entities/player/idle/";
    	r = new TextureRegion(new Texture(ip + "right.png"));
    	l = new TextureRegion(new Texture(ip + "left.png"));
    	u = new TextureRegion(new Texture(ip + "up.png"));
    	d = new TextureRegion(new Texture(ip + "down.png"));
    	
	}

	public void update(Array<Rectangle> groundB) {
		collisions(groundB);
		setBounds();
		updateDir();
	}
	
	private void collisions(Array<Rectangle> groundB) {
		//TODO
		for(Rectangle r : groundB) {
			if(ls.overlaps(r)) {
				bounds.x = r.x + r.width + 3;
			}
			if(rs.overlaps(r)) {
				bounds.x = r.x - bounds.width - 3;
			}
			if(us.overlaps(r)) {
				bounds.y = r.y - bounds.height - 3;
			}
			if(ds.overlaps(r)) {
				bounds.y = r.y + r.height + 3;
			}
		}
	}
	
	private void updateDir() {
		if(vel.x == WALK_SPEED || vel.x == RUN_SPEED) {
			setDirection(Constants.RIGHT);
		} else if(vel.x == -WALK_SPEED || vel.x == -RUN_SPEED) {
			setDirection(Constants.LEFT);
		} else if(vel.y == WALK_SPEED || vel.y == RUN_SPEED) {
			setDirection(Constants.UP);
		} else if(vel.y == -WALK_SPEED || vel.y == -RUN_SPEED) {
			setDirection(Constants.DOWN);
		}
	}
	
	private void setBounds() {
		float x, y;
		x = bounds.x;
		y = bounds.y;
		x += vel.x;
		y += vel.y;
		float w, h;
		w = bounds.width;
		h = bounds.height;
		bounds.set(x, y, w, h);
		rs.width = 4;
		rs.height = 4;
		ls.width = 4;
		ls.height = 4;
		us.width = 4;
		us.height = 4;
		ds.width = 4;
		ds.height = 4;
		rs.x = x + w - 2;
		rs.y = y + (h * .5f) - 2;
		ls.x = x - 2;
		ls.y = y + (h * .5f) - 2;
		us.y = y + h - 2;
		us.x = x + (w * .5f) - 2;
		ds.y = y - 2;
		ds.x = x + (w * .5f) - 2;
	}
	
	public void updateCamera(MyCamera cam, float width, float height) {
		//TODO temp
		cam.position.set(bounds.x, bounds.y, 0);
		if(cam.position.x > width - (cam.viewportWidth * .5f)) {
			cam.position.x = width - (cam.viewportWidth * .5f);
		}
		if(cam.position.x < cam.viewportWidth * .5f) {
			cam.position.x = cam.viewportWidth * .5f;
		}
		if(cam.position.y > height - (cam.viewportHeight * .5f)) {
			cam.position.y = height - (cam.viewportHeight * .5f);
		}
		if(cam.position.y < cam.viewportHeight * .5f) {
			cam.position.y = cam.viewportHeight * .5f;
		}
		cam.update();
	}
	
	public void handleInput() {
		running = MyInput.isDown(MyInput.SHIFT);
		if(MyInput.isDown(MyInput.UP)) {
			if(running) {
				walking = false;
				vel.set(0, RUN_SPEED);
			} else {
				walking = true;
				vel.set(0, WALK_SPEED);
			}
		} else if(MyInput.isDown(MyInput.DOWN)) {
			if(running) {
				walking = false;
				vel.set(0, -RUN_SPEED);
			} else {
				walking = true;
				vel.set(0, -WALK_SPEED);
			}
		} else if(MyInput.isDown(MyInput.LEFT)) {
			if(running) {
				walking = false;
				vel.set(-RUN_SPEED, 0);
			} else {
				walking = true;
				vel.set(-WALK_SPEED, 0);
			}
		} else if(MyInput.isDown(MyInput.RIGHT)) {
			if(running) {
				walking = false;
				vel.set(RUN_SPEED, 0);
			} else {
				walking = true;
				vel.set(WALK_SPEED, 0);
			}
		} else {
			walking = false;
			running = false;
			vel.set(0 , 0);
		}
	}
	
	@Override
	public void draw(SpriteBatch sb, ShapeRenderer sr, float dt) {
		stateTime += dt;
		
		if(walking) {
			if(getDirection() == Constants.LEFT) {
				currentFrame = wl.getKeyFrame(stateTime, true);
			}
			if(getDirection() == Constants.RIGHT) {
				currentFrame = wr.getKeyFrame(stateTime, true);
			}
			if(getDirection() == Constants.UP) {
				currentFrame = wu.getKeyFrame(stateTime, true);
			}
			if(getDirection() == Constants.DOWN) {
				currentFrame = wd.getKeyFrame(stateTime, true);
			}
		} else if(running) {
			if(getDirection() == Constants.LEFT) {
				currentFrame = rl.getKeyFrame(stateTime, true);
			}
			if(getDirection() == Constants.RIGHT) {
				currentFrame = rr.getKeyFrame(stateTime, true);
			}
			if(getDirection() == Constants.UP) {
				currentFrame = ru.getKeyFrame(stateTime, true);
			}
			if(getDirection() == Constants.DOWN) {
				currentFrame = rd.getKeyFrame(stateTime, true);
			}
		} else {
			if(getDirection() == Constants.LEFT) {
				currentFrame = l;
			}
			if(getDirection() == Constants.RIGHT) {
				currentFrame = r;
			}
			if(getDirection() == Constants.UP) {
				currentFrame = u;
			}
			if(getDirection() == Constants.DOWN) {
				currentFrame = d;
			}
		}
		
		bounds.width = currentFrame.getRegionWidth() + 8;
		bounds.height = currentFrame.getRegionHeight() + 8;
		
		sb.draw(currentFrame, bounds.x, bounds.y);
		
	}

}
