package com.chinomatik.nativeHook;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.springframework.stereotype.Component;

import com.chinomatik.dto.EventDto;

@Component
public class NativeHookKey extends NativeHook implements NativeKeyListener {


	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
//		events.add(new EventDto(null, null, e.getKeyCode(), LocalDateTime.now(),
//				Calendar.getInstance().getTimeInMillis(), INPUTKEYTYPE));--eliminado por que retorna 0
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
//		events.add(new EventDto(null, null, e.getKeyCode(), LocalDateTime.now(),
//				Calendar.getInstance().getTimeInMillis(), INPUTKEYPRESSED));
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		events.add(new EventDto(null, null, e.getKeyCode(), LocalDateTime.now(),
				Calendar.getInstance().getTimeInMillis(), INPUTKEYRELEASE));
	}

	public static void init() {

		try {
			GlobalScreen.registerNativeHook();
			Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
			logger.setLevel(Level.OFF);
			if (events == null) {
				events = new ArrayList<>();
			}

		} catch (NativeHookException ex) {
//			logger.error("There was a problem registering the native hook.");
//			logger.error(ex.getMessage());
		}

		/* Construct the example object and initialze native hook. */
		GlobalScreen.addNativeKeyListener(new NativeHookKey());
	}

	public static void exit() {
		events.clear();
	}

}
