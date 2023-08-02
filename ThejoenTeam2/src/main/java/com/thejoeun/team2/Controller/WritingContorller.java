package com.thejoeun.team2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WritingContorller {

	 
	@GetMapping("/thejoeun/writing/quarantine")
	public String quarantine() {
		return "thejoeun/writing/quarantine";
	}
	
	@GetMapping("/thejoeun/writing/disease")
	public String disease() {
		return "thejoeun/writing/disease";
	}
	
	@GetMapping("thejoeun/writing/infectious")
	public String infectious() {
		return "thejoeun/writing/infectious";
	}
	
	@GetMapping("thejoeun/writing/respiratory")
	public String respiratory() {
		return "thejoeun/writing/respiratory";
	}
	
	@GetMapping("thejoeun/writing/mpox_people")
	public String mpox_people() {
		return "thejoeun/writing/mpox_people";
	}
	
	@GetMapping("thejoeun/writing/mpox_guest")
	public String mpox_guest() {
		return "thejoeun/writing/mpox_guest";
	}
	
}
