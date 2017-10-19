package com.chinomatik.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.chinomatik.dto.EventDto;
import com.chinomatik.dto.RecordDto;
import com.chinomatik.nativeHook.NativeHookKey;
import com.chinomatik.nativeHook.NativeHookMouse;
import com.chinomatik.robot.RobotService;
import com.chinomatik.services.RecordService;

@Controller
public class HomeController {

	private static final String INDEX = "index";

	private static final String RECORD_SECUENCES = "record";

	@Autowired
	private RecordService recordService;

	@Autowired
	private RobotService robotService;

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

	@GetMapping("/save")
	public String save() {
		List<EventDto> events = NativeHookMouse.getEvents();
		RecordDto recordDto = new RecordDto();
		recordDto.setEvents(events);
		recordDto.setRecordEnd(LocalDateTime.now());
		recordDto.setId(recordService.getNextSequence(RECORD_SECUENCES));
		recordService.save(recordDto);
		NativeHookMouse.exit();
		return INDEX;
	}
	
	@GetMapping("/desactivar")
	public String inactive() {
		NativeHookMouse.exit();
		return INDEX;
	}

	@GetMapping("/saved")
	public String saved(Model m) {
		m.addAttribute("saved", recordService.findAll());
		return INDEX;
	}

	@GetMapping("/saved/{id}")
	public String saved(Model m, @PathVariable Long id) {
		m.addAttribute("events", recordService.findRecord(id).getEvents());
		return INDEX;
	}

	@GetMapping("/execute/{id}")
	public String execute(Model m, @PathVariable Long id) {
		robotService.execute(recordService.findRecord(id));
		return INDEX;
	}
	
	@GetMapping("/deleteall")
	public String deleteAll() {
		recordService.deleteAll();
		return INDEX;
	}

}
