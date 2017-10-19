package com.chinomatik.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class MoveMouse {
	
	private Robot robot;
	private static final int SPEED = 300;
	
	private void execute(int[] letter){
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		for (int i = 0;i<letter.length ;i++ ) {
			robot.delay(SPEED);
			robot.keyPress(letter[i]);
			robot.keyRelease(letter[i]);
			
		}
	}

//	public static void main(String[] args) {
//		
//		MoveMouse t = new MoveMouse();
//		
//		int[] executeNotepad = {KeyEvent.VK_WINDOWS,KeyEvent.VK_N,KeyEvent.VK_O,KeyEvent.VK_T,KeyEvent.VK_E,KeyEvent.VK_P,KeyEvent.VK_A,KeyEvent.VK_D,KeyEvent.VK_ENTER};
//		int[] maximizeIt = {KeyEvent.VK_ALT,KeyEvent.VK_SPACE,KeyEvent.VK_X};
//		int[] messageToPrint = {KeyEvent.VK_H,KeyEvent.VK_E,KeyEvent.VK_L,KeyEvent.VK_L,KeyEvent.VK_O};
//		
//		t.execute(executeNotepad);
//		t.execute(maximizeIt);
//		t.execute(messageToPrint);
//		
//	}

}
