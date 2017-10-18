package com.chinomatik.nativeHook;

import javax.annotation.PostConstruct;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class NativeHookKey implements NativeKeyListener {

	private static final Logger logger = LoggerFactory.getLogger(NativeHookKey.class);

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
		logger.info(NativeKeyEvent.getKeyText(e.getKeyCode()));
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		logger.info(NativeKeyEvent.getKeyText(e.getKeyCode()));
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		logger.info(NativeKeyEvent.getKeyText(e.getKeyCode()));
	}
//	@PostConstruct
	public static void init(){

		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException ex) {
			logger.error("There was a problem registering the native hook.");
			logger.error(ex.getMessage());
		}

		/* Construct the example object and initialze native hook. */
		GlobalScreen.addNativeKeyListener(new NativeHookKey());
	}
	public static void exit(){
		try {
			GlobalScreen.unregisterNativeHook();
		} catch (NativeHookException ex) {
			logger.error("There was a problem registering the native hook.");
			logger.error(ex.getMessage());
		}
		
	}
	
}
