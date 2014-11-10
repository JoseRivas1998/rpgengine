package com.tcg.rpg.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public abstract class Entity {

	protected Rectangle bounds;
	
	protected int direction;
	
	public Entity(int direction) {
		bounds = new Rectangle();
		this.direction = direction;
	}
	
	public abstract void draw(SpriteBatch sb, ShapeRenderer sr, float dt);

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

}
