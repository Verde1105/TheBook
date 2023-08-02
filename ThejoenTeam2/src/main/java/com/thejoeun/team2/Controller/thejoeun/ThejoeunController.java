package com.thejoeun.team2.Controller.thejoeun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThejoeunController {
//페이지 이동 컨트롤러
	//홈
	@GetMapping("/thejoeun/index")
	public String index() {//컨트롤에서 세션을 어떻게 찾는가?
		return "thejoeun/index";
	}
	
	@GetMapping("/thejoeun/gen")
	public String gen() {
		return "thejoeun/generic";
	}
	
	@GetMapping("/thejoeun/ele")
	public String ele() {
		return "thejoeun/elements";
	}
	
	@GetMapping("/thejoeun/loginForm")
	public String 주소붙이기() {
		return "thejoeun/index";
	}

	//이하 계절성 감염병 링크
	//봄 페이지
	@GetMapping("/thejoeun/spring")
	public String spring() {
		return "thejoeun/writing/spring";
	}
	//여름 페이지
	@GetMapping("/thejoeun/summer")
	public String summer() {
		return "thejoeun/writing/summer";
	}
	//가을 페이지
	@GetMapping("/thejoeun/autumn")
	public String autumn() {
		return "thejoeun/writing/autumn";
	}
	//겨울 페이지
	@GetMapping("/thejoeun/winter")
	public String winter() {
		return "thejoeun/writing/winter";
	}
	
	@GetMapping("/thejoeun/weather")
	public String weather() {//컨트롤에서 세션을 어떻게 찾는가?
		return "thejoeun/weather";
	}

}
//@AuthenticationPrincipal PrincipalDetail principal
