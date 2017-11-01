package com.chinomatik.nativehook;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinomatik.dto.EventDto;
import com.chinomatik.robot.RobotService;
import com.chinomatik.robot.RobotServiceImpl;
import com.chinomatik.services.RecordService;
import com.chinomatik.services.RecordServiceImpl;

@Component
public class NativeHookKey extends NativeHook implements NativeKeyListener {

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
		// events.add(new EventDto(null, null, e.getKeyCode(),
		// LocalDateTime.now(),
		// Calendar.getInstance().getTimeInMillis(), INPUTKEYTYPE));
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
			RobotServiceImpl.kill();
		} else if (e.getKeyCode() == NativeKeyEvent.VC_F9) {
			isRecording = !isRecording;
		} else if (e.getKeyCode() == NativeKeyEvent.VC_F10) {
			NativeHook.exit();
		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		if (isRecording) {
			events.add(new EventDto(null, null, e.getKeyCode(), LocalDateTime.now(),
					Calendar.getInstance().getTimeInMillis(), INPUTKEYRELEASE));
		}
	}

}
