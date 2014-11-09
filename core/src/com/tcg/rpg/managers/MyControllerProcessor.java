package com.tcg.rpg.managers;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerAdapter;
import com.badlogic.gdx.controllers.PovDirection;

public class MyControllerProcessor extends ControllerAdapter {
	
	@Override
	public boolean buttonDown (Controller controller, int buttonIndex) {
		if(buttonIndex == 0) {
			MyController.setKey(MyController.A, true);
		}
		if(buttonIndex == 1) {
			MyController.setKey(MyController.B, true);
		}
		if(buttonIndex == 2) {
			MyController.setKey(MyController.X, true);
		}
		if(buttonIndex == 3) {
			MyController.setKey(MyController.Y, true);
		}
		if(buttonIndex == 4) {
			MyController.setKey(MyController.LB, true);
		}
		if(buttonIndex == 5) {
			MyController.setKey(MyController.RB, true);
		}
		if(buttonIndex == 6) {
			MyController.setKey(MyController.BACK, true);
		}
		if(buttonIndex == 7) {
			MyController.setKey(MyController.START, true);
		}
		if(buttonIndex == 8) {
			MyController.setKey(MyController.L3, true);
		}
		if(buttonIndex == 9) {
			MyController.setKey(MyController.R3, true);
		}
		return true;
	}

	@Override
	public boolean buttonUp (Controller controller, int buttonIndex) {
		if(buttonIndex == 0) {
			MyController.setKey(MyController.A, false);
		}
		if(buttonIndex == 1) {
			MyController.setKey(MyController.B, false);
		}
		if(buttonIndex == 2) {
			MyController.setKey(MyController.X, false);
		}
		if(buttonIndex == 3) {
			MyController.setKey(MyController.Y, false);
		}
		if(buttonIndex == 4) {
			MyController.setKey(MyController.LB, false);
		}
		if(buttonIndex == 5) {
			MyController.setKey(MyController.RB, false);
		}
		if(buttonIndex == 6) {
			MyController.setKey(MyController.BACK, false);
		}
		if(buttonIndex == 7) {
			MyController.setKey(MyController.START, false);
		}
		if(buttonIndex == 8) {
			MyController.setKey(MyController.L3, false);
		}
		if(buttonIndex == 9) {
			MyController.setKey(MyController.R3, false);
		}
		return true;
	}

	@Override
	public boolean axisMoved (Controller controller, int axisIndex, float value) {
		if(axisIndex == 4) {
			if(Math.abs(value) <= .02f) {
				MyController.setTrigger(MyController.LT, false);
				MyController.setTrigger(MyController.RT, false);
			} else if(value > .02f) {
				MyController.setTrigger(MyController.LT, true);
			}	else if(value < -.02f) {
				MyController.setTrigger(MyController.RT, true);
			}
		}
		
		return true;
	}

	@Override
	public boolean povMoved (Controller controller, int povIndex, PovDirection value) {
		MyController.setDPAD(value);
		return true;
	}

}
