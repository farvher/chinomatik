package com.chinomatik.nativeHook;

import java.util.ArrayList;
import java.util.List;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class NativeHookMouse implements NativeMouseInputListener {

	private static final Logger logger = LoggerFactory.getLogger(NativeHookMouse.class);

	private static List<Integer> x;
	private static List<Integer> y;

	public void nativeMouseClicked(NativeMouseEvent e) {
		logger.info("Mouse Moved: " + e.getX() + ", " + e.getY());
	}

	public void nativeMousePressed(NativeMouseEvent e) {
//		exit();
	}

	public void nativeMouseReleased(NativeMouseEvent e) {
		logger.info("Mouse Released: " + e.getButton());
	}

	public void nativeMouseMoved(NativeMouseEvent e) {
		logger.info("Mouse Moved: " + e.getX() + ", " + e.getY());
	}

	public void nativeMouseDragged(NativeMouseEvent e) {

		x.add(e.getX());
		y.add(e.getY());
	}

	public static void init() {
		try {
			GlobalScreen.registerNativeHook();

			x = new ArrayList<Integer>();
			y = new ArrayList<Integer>();

		} catch (NativeHookException ex) {
			logger.error("There was a problem registering the native hook.");
			logger.error(ex.getMessage());
		}
		// Add the appropriate listeners.
		GlobalScreen.addNativeMouseListener(new NativeHookMouse());
		GlobalScreen.addNativeMouseMotionListener(new NativeHookMouse());
	}

	public static void exit() {
		try {
			GlobalScreen.unregisterNativeHook();;

		} catch (NativeHookException ex) {
			logger.error("There was a problem registering the native hook.");
			logger.error(ex.getMessage());
		}

	}

	public static List<Integer> getX() {
		return x;
	}

	public static void setX(List<Integer> x) {
		NativeHookMouse.x = x;
	}

	public static List<Integer> getY() {
		return y;
	}

	public static void setY(List<Integer> y) {
		NativeHookMouse.y = y;
	}

}
