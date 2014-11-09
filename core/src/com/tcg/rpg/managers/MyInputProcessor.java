package com.tcg.rpg.managers;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputAdapter;
import com.tcg.rpg.Game;

public class MyInputProcessor extends InputAdapter {

	@Override
	public boolean keyDown(int keycode) {
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
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
