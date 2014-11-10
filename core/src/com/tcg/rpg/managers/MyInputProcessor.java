package com.tcg.rpg.managers;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.tcg.rpg.Game;

public class MyInputProcessor extends InputAdapter {

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.UP || keycode == Keys.W) {
			MyInput.setKey(MyInput.UP, true);
		}
		if(keycode == Keys.DOWN || keycode == Keys.S) {
			MyInput.setKey(MyInput.DOWN, true);
		}
		if(keycode == Keys.LEFT || keycode == Keys.A) {
			MyInput.setKey(MyInput.LEFT, true);
		}
		if(keycode == Keys.RIGHT || keycode == Keys.D) {
			MyInput.setKey(MyInput.RIGHT, true);
		}
		if(keycode == Keys.ENTER) {
			MyInput.setKey(MyInput.ENTER, true);
		}
		if(keycode == Keys.ESCAPE) {
			MyInput.setKey(MyInput.ESCAPE, true);
		}
		if(keycode == Keys.SPACE) {
			MyInput.setKey(MyInput.SPACE, true);
		}
		if(keycode == Keys.SHIFT_LEFT || keycode == Keys.SHIFT_RIGHT) {
			MyInput.setKey(MyInput.SHIFT, true);
		}
		if(keycode == Keys.F2) {
			MyInput.setKey(MyInput.FPS, true);
		}
		if(keycode == Keys.F9) {
			MyInput.setKey(MyInput.DEBUG, true);
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Keys.UP || keycode == Keys.W) {
			MyInput.setKey(MyInput.UP, false);
		}
		if(keycode == Keys.DOWN || keycode == Keys.S) {
			MyInput.setKey(MyInput.DOWN, false);
		}
		if(keycode == Keys.LEFT || keycode == Keys.A) {
			MyInput.setKey(MyInput.LEFT, false);
		}
		if(keycode == Keys.RIGHT || keycode == Keys.D) {
			MyInput.setKey(MyInput.RIGHT, false);
		}
		if(keycode == Keys.ENTER) {
			MyInput.setKey(MyInput.ENTER, false);
		}
		if(keycode == Keys.ESCAPE) {
			MyInput.setKey(MyInput.ESCAPE, false);
		}
		if(keycode == Keys.SPACE) {
			MyInput.setKey(MyInput.SPACE, false);
		}
		if(keycode == Keys.SHIFT_LEFT || keycode == Keys.SHIFT_RIGHT) {
			MyInput.setKey(MyInput.SHIFT, false);
		}
		if(keycode == Keys.F2) {
			MyInput.setKey(MyInput.FPS, false);
		}
		if(keycode == Keys.F9) {
			MyInput.setKey(MyInput.DEBUG, false);
		}
		return true;
	}
	
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(screenX < Game.SIZE.x 
				&& Game.SIZE.y - screenY < Game.SIZE.y
				&& pointer < 20
				&& button == Buttons.LEFT)MyInput.setTouch(true);
		return true;
	}
	
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		MyInput.setTouch(false);
		return true;
	}

}
