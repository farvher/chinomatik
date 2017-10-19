package com.chinomatik.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.chinomatik.dto.EventDto;
import com.chinomatik.dto.RecordDto;
import com.chinomatik.nativeHook.NativeHookKey;
import com.chinomatik.nativeHook.NativeHookMouse;
import com.chinomatik.services.RecordService;

@Controller
public class HomeController {

	private static final String INDEX = "index";

	private static final String RECORD_SECUENCES = "record";

	@Autowired
	private RecordService recordService;

	@GetMapping("/")
	public String home() {

		return INDEX;
	}

	@GetMapping("/activar")
	public String active() {

		NativeHookMouse.init();
		NativeHookKey.init();
		return INDEX;
	}

	@GetMapping("/status")
	public String status(Model m) {

		List<EventDto> events = NativeHookMouse.getEvents();
		m.addAttribute("events", events);
		return INDEX;
	}

	@GetMapping("/desactivar")
	public String inactive() {
		List<EventDto> events = NativeHookMouse.getEvents();
		RecordDto recordDto = new RecordDto();
		recordDto.setEvents(events);
		recordDto.setRecordEnd(LocalDateTime.now());
		recordDto.setId(recordService.getNextSequence(RECORD_SECUENCES));
		recordService.save(recordDto);
		NativeHookMouse.exit();
		return INDEX;
	}
	
	@GetMapping("/saved")
	public String saved(Model m) {
		m.addAttribute("saved", recordService.findAll());
		return INDEX;
	}

}
