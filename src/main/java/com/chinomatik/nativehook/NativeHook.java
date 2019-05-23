package com.chinomatik.nativehook;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import com.chinomatik.dto.EventDto;

public abstract class NativeHook {
	
	public static Boolean isRecording = false;

	public static final String MOUSEMOVED = "MOUSEMOVED";

	public static final String MOUSEDRAGGED = "MOUSEDRAGGED";

	public static final String MOUSERELEASE = "MOUSERELEASE";

	public static final String INPUTKEYPRESSED = "INPUTKEYPRESSED";

	public static final String INPUTKEYTYPE = "INPUTKEYTYPE";

	public static final String INPUTKEYRELEASE = "INPUTKEYRELEASE";

	public static final String MOUSEPRESSED = "MOUSEPRESSED";

	public static final String MOUSECLICKED = "MOUSECLICKED";

	public static List<EventDto> events;

	public static List<EventDto> getEvents() {
		return events;
	}

	public static void setEvents(List<EventDto> events) {
		NativeHook.events = events;
	}

	public static void init() {
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);
		logger.setUseParentHandlers(false);
		try {
			if (!GlobalScreen.isNativeHookRegistered()) {
				GlobalScreen.registerNativeHook();
				GlobalScreen.addNativeMouseListener(new NativeHookMouse());
				GlobalScreen.addNativeMouseMotionListener(new NativeHookMouse());
				GlobalScreen.addNativeKeyListener(new NativeHookKey());
			}
			if (events == null) {
				events = new ArrayList<>();
			}

		} catch (NativeHookException ex) {
			// logger.error("There was a problem registering the native hook.");
			// logger.error(ex.getMessage());
		}

	}

	public static void exit() {
		if (events != null) {
			events.clear();
//			try {
//				Thread.sleep(3000);
//				events.clear();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}

}
