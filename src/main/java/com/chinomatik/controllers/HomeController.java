package com.chinomatik.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.chinomatik.nativeHook.NativeHookMouse;

@Controller
public class HomeController {

	private static final String INDEX = "index";

	@GetMapping("/")
	public String home() {

		return INDEX;
	}
	
	@GetMapping("/activar")
	public String active(){
		
		NativeHookMouse.init();
		return INDEX;
	}
	
	@GetMapping("/desactivar")
	public String inactive(){
		
		NativeHookMouse.exit();
		return INDEX;
	}


}
