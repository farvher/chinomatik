package com.chinomatik.nativeHook;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.springframework.stereotype.Component;

import com.chinomatik.dto.EventDto;

@Component
public class NativeHookMouse extends NativeHook implements NativeMouseInputListener {

	public void nativeMouseClicked(NativeMouseEvent e) {
//		events.add(new EventDto(e.getX(), e.getY(), null, LocalDateTime.now(), Calendar.getInstance().getTimeInMillis(),MOUSECLICKED));

	}

	public void nativeMousePressed(NativeMouseEvent e) {
		events.add(new EventDto(e.getX(), e.getY(), null, LocalDateTime.now(), Calendar.getInstance().getTimeInMillis(),MOUSEPRESSED));
	}

	public void nativeMouseReleased(NativeMouseEvent e) {
		events.add(new EventDto(e.getX(), e.getY(), null, LocalDateTime.now(), Calendar.getInstance().getTimeInMillis(), MOUSERELEASE));
	}

	public void nativeMouseMoved(NativeMouseEvent e) {
//		events.add(new EventDto(e.getX(), e.getY(), null, LocalDateTime.now(), Calendar.getInstance().getTimeInMillis(),MOUSEMOVED));
	}

	public void nativeMouseDragged(NativeMouseEvent e) {
	events.add(new EventDto(e.getX(), e.getY(), null, LocalDateTime.now(), Calendar.getInstance().getTimeInMillis(),MOUSEDRAGGED));
	}

	public static void init() {
		try {
			GlobalScreen.registerNativeHook();
			Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
			logger.setLevel(Level.OFF);

			// Don't forget to disable the parent handlers.
			logger.setUseParentHandlers(false);
			if (events == null) {
				events = new ArrayList<>();
			}

		} catch (NativeHookException ex) {
//			logger.error("There was a problem registering the native hook.");
//			logger.error(ex.getMessage());
		}
		GlobalScreen.addNativeMouseListener(new NativeHookMouse());
		GlobalScreen.addNativeMouseMotionListener(new NativeHookMouse());
	}

	public static void exit() {
		if (events != null) {
			events.clear();
		}
		// try {
		// GlobalScreen.unregisterNativeHook();;
		//
		// } catch (NativeHookException ex) {
		// logger.error("There was a problem registering the native hook.");
		// logger.error(ex.getMessage());
		// }

	}

}
