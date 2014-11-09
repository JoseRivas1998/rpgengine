package com.tcg.rpg.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.tcg.rpg.Game;

public class MyInput {
	public static boolean[] keys;
	public static boolean[] pkeys;
	public static boolean touch;
	public static boolean ptouch;
	
	private static final int NUM_KEYS = 10;
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	public static final int ESCAPE = 4;
	public static final int SPACE = 5;
	public static final int ENTER = 6;
	public static final int SHIFT = 7;
	public static final int DEBUG = 8;
	public static final int FPS = 9;
	
	static {
		keys = new boolean[NUM_KEYS];
		pkeys = new boolean[NUM_KEYS];
	}
	
	public static void update() {
		for(int i = 0; i < NUM_KEYS; i++) {
			pkeys[i] = keys[i];
		}
		ptouch = touch;
	}

	public static boolean anyKeyDown() {
		for(boolean b : keys) {
			if(b) return true;
		}
		return false;
	}
	public static void setKey(int i, boolean b) { keys[i] = b; }
	public static boolean isDown(int i) { return keys[i]; }
	public static boolean isPressed(int i) { return keys[i] && !pkeys[i]; }
	public static boolean isTouchDown() { return touch; }
	public static boolean isTouched() { return touch && !ptouch; }
	public static void setTouch(boolean b) { touch = b; }
	public static Vector2 getTouch() { return new Vector2(Gdx.input.getX(), Game.SIZE.y - Gdx.input.getY()); }
	

}
