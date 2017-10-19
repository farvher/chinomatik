package com.chinomatik.nativeHook;

import java.util.List;

import com.chinomatik.dto.EventDto;

public abstract class NativeHook {

	public static final String MOUSEMOVED = "MOUSEMOVED";

	public static final String MOUSEDRAGGED = "MOUSEDRAGGED";
	
	public static final String MOUSERELEASE = "MOUSERELEASE";

	public static final String INPUTKEYPRESSED = "INPUTKEYPRESSED";
	
	public static final String INPUTKEYTYPE = "INPUTKEYTYPE";
	
	public static final String INPUTKEYRELEASE = "INPUTKEYRELEASE";

	public static final String MOUSEPRESSED = "MOUSEPRESSED";

	public static final String MOUSECLICKED = "MOUSECLICKED";

	public static List<EventDto> events;

	public static List<EventDto> getEvents() {
		return events;
	}

	public static void setEvents(List<EventDto> events) {
		NativeHook.events = events;
	}

}
