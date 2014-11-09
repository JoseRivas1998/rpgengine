package com.tcg.rpg.managers;

import com.badlogic.gdx.controllers.PovDirection;

public class MyController {
	
	public static boolean[] buttons;
	public static boolean[] pButtons;
	public static PovDirection value;
	public static PovDirection pValue;
	
	public static boolean[] trigger;
	public static boolean[] pTrigger;
	
	public static final int LT = 0;
	public static final int RT = 1;
	
	public static final int NUM_BUTTONS = 10;
	public static final int A     = 0;
	public static final int B     = 1;
	public static final int X     = 2;
	public static final int Y     = 3;
	public static final int LB    = 4;
	public static final int RB    = 5;
	public static final int BACK  = 6;
	public static final int START = 7;
	public static final int L3    = 8;
	public static final int R3    = 9;
	
	static {
		buttons = new boolean[NUM_BUTTONS];
		pButtons = new boolean[NUM_BUTTONS];
		trigger = new boolean[2];
		pTrigger = new boolean[2];
	}
	
	public static void update() {
		for(int i = 0; i < NUM_BUTTONS; i++) {
			pButtons[i] = buttons[i];
		}
		for(int i = 0; i < 2; i++) {
			pTrigger[i] = trigger[i];
		}
		pValue = value;
	}
	
	public static void setDPAD(PovDirection Value) { value = Value; }
	public static void setKey(int i, boolean b) { buttons[i] = b; }
	public static void setTrigger(int triggerIndex, boolean b) { trigger[triggerIndex] = b; }
	
	public static boolean anyButtonDown() {
		for(boolean b : buttons) {
			if(b) return true;
		}
		return false;
	}
	public static boolean isDown(int i) { return buttons[i]; }
	public static boolean isPressed(int i) { return buttons[i] && !pButtons[i]; }
	public static boolean povDown(PovDirection Value) { return  value == Value; }
	public static boolean povPressed(PovDirection Value) { return value == Value && pValue != value; }
	public static boolean triggerDown(int triggerIndex) { return trigger[triggerIndex]; }
	
}
