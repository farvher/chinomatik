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
		events.add(new EventDto(e.getX(), e.getY(), e.getButton(), LocalDateTime.now(), Calendar.getInstance().getTimeInMillis(),MOUSEPRESSED));
	}

	public void nativeMouseReleased(NativeMouseEvent e) {
		events.add(new EventDto(e.getX(), e.getY(), e.getButton(), LocalDateTime.now(), Calendar.getInstance().getTimeInMillis(), MOUSERELEASE));
	}

	public void nativeMouseMoved(NativeMouseEvent e) {
		events.add(new EventDto(e.getX(), e.getY(), null, LocalDateTime.now(), Calendar.getInstance().getTimeInMillis(),MOUSEMOVED));
	}

	public void nativeMouseDragged(NativeMouseEvent e) {
	events.add(new EventDto(e.getX(), e.getY(), null, LocalDateTime.now(), Calendar.getInstance().getTimeInMillis(),MOUSEDRAGGED));
	}

	

}
