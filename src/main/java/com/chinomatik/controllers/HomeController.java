package com.chinomatik.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.jnativehook.GlobalScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinomatik.dto.EventDto;
import com.chinomatik.dto.RecordDto;
import com.chinomatik.nativeHook.NativeHook;
import com.chinomatik.nativeHook.NativeHookMouse;
import com.chinomatik.services.RecordService;
import com.google.gson.Gson;

@Controller
public class HomeController {

	private static final String INDEX = "index";

	private static final String RECORD_SECUENCES = "record";
	
	private static final String EXECUTIONS ="executions";
	

	@Autowired
	private RecordService recordService;

	private Gson gson = new Gson();

	@GetMapping("/activar")
	public String active() {
		NativeHook.exit();
		NativeHook.init();
		return INDEX;
	}

	@GetMapping("/")
	public String status(Model m) {
		List<EventDto> events =  new ArrayList<>();
		if(NativeHookMouse.getEvents()!=null){
			events.addAll(NativeHookMouse.getEvents());
		}
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
		if (events != null) {
			recordService.save(recordDto);
		}
		NativeHookMouse.exit();
		return "redirect:/executions";
	}

	@GetMapping("/reset")
	public String inactive(Model m) {
		NativeHook.exit();
		return "redirect:/";
	}


	@PostMapping("/deleteall")
	public String deleteAll() {
		recordService.deleteAll();
		return "redirect:/executions";
	}

	
	
	@GetMapping("/events")
	@ResponseBody
	public String ajaxEvent() {
		List<EventDto> events = NativeHookMouse.getEvents();
		return gson.toJson(events);
	}

	@GetMapping("/count")
	@ResponseBody
	public Integer ajaxCount() {
		List<EventDto> events = NativeHookMouse.getEvents();
		return events != null ? events.size() : 0;
	}

	@GetMapping("/recording")
	@ResponseBody
	public Boolean ajaxIsRecording() {
		return GlobalScreen.isNativeHookRegistered();
	}

}
