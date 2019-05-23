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
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.chinomatik.controllers.HomeController;
import com.chinomatik.dto.EventDto;
import com.chinomatik.robot.RobotService;
import com.chinomatik.robot.RobotServiceImpl;
import com.chinomatik.services.RecordService;
import com.chinomatik.services.RecordServiceImpl;

@Component
public class NativeHookKey extends NativeHook implements NativeKeyListener,ApplicationContextAware{

	  private static ApplicationContext ac;
	
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
		} else if (e.getKeyCode() == NativeKeyEvent.VC_F10) {
			isRecording = !isRecording;
		} else if (e.getKeyCode() == NativeKeyEvent.VC_F9) {
			NativeHook.exit();
			isRecording = true;
		}else if(e.getKeyCode() == NativeKeyEvent.VC_F8) {
			
			RecordService recordService = (RecordService) ac.getBean("recordServiceImpl");
			if(recordService!=null) 
				recordService.save();
					
		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		if (isRecording) {
			events.add(new EventDto(null, null, e.getKeyCode(), LocalDateTime.now(),
					Calendar.getInstance().getTimeInMillis(), INPUTKEYRELEASE));
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		 this.ac = applicationContext;
		
	}

}
