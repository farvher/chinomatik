package com.chinomatik.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinomatik.dto.ExecutionDto;
import com.chinomatik.dto.RecordDto;
import com.chinomatik.robot.RobotService;
import com.chinomatik.robot.RobotServiceImpl;
import com.chinomatik.services.ExecutionService;
import com.chinomatik.services.RecordService;

@Controller
public class ExecutionController {

	private static final String EXECUTION = "execution";

	@Autowired
	private RecordService recordService;

	@Autowired
	private ExecutionService executionService;

	@Autowired
	private RobotService robotService;

	@GetMapping("/executions")
	public String saved(Model m) {
		m.addAttribute("saved", recordService.findAll());
		m.addAttribute("executions", executionService.findAll());
		return EXECUTION;
	}

	@PostMapping("/createExecution")
	public String addExecution(Model m, Long[] idRecord, String executionName, String dateTime,Integer times) {

		ExecutionDto executionDto = new ExecutionDto();
		executionDto.setExecutionName(executionName);
		executionDto.setId(executionService.getNextSequence("execution"));
		executionDto.setScheduledStart(parseLocalDateTime(dateTime));
		executionDto.setRecordsId(Arrays.asList(idRecord));
		executionDto.setTimes(times);
		executionService.save(executionDto);

		return "redirect:/executions";
	}
	

	// TODO remove this method
	@GetMapping("/saved/{id}")
	public String saved(Model m, @PathVariable Long id) {
		RecordDto recorDto = recordService.findRecord(id);
		m.addAttribute("events", recorDto.getEvents());
		m.addAttribute("recordNo", recorDto.getId());
		return EXECUTION;
	}

	@PostMapping("/execute-record")
	public String executeSingleRecord(Model m, Long id) {
		robotService.execute(recordService.findRecord(id));
		return "redirect:/executions";
	}
	
	@PostMapping("/execute-execution")
	public String executeExecution(Model m, Integer id) {
		ExecutionDto execution = executionService.findById(id);
		List<RecordDto> recordList = recordService.findByIdIn(execution.getRecordsId());
		robotService.execute(recordList,execution.getTimes());
		return "redirect:/executions";
	}
	
	@PostMapping("/current-execution")
	@ResponseBody
	public Integer currentExecution(){
		return RobotServiceImpl.getCurrentExecution();
	}

	@PostMapping("/delete-execution")
	@ResponseBody
	public String delete(Model m, Integer id) {
		executionService.delete(id);
		return "deleted";
	}

	private LocalDateTime parseLocalDateTime(String dateTimeString) {
		String str = dateTimeString.replace("T", " ");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		return dateTime;
	}

}
