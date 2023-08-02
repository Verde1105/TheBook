package com.thejoeun.team2.Controller.thejoeun;

//import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.thejoeun.team2.service.BoardService;

@Controller
public class ThejoeunBoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/thejoeun/board")
	public String index(Model model, @PageableDefault(size=3, sort="id", direction = Direction.DESC) Pageable pageable) {//컨트롤에서 세션을 어떻게 찾는가?
//		System.out.println("로그인 사용자 아이디 :" + principal.getUsername());
		model.addAttribute("boards",boardService.글목록(pageable));
		return "thejoeun/board";
	}
	
	// 게시글 상세보기
	@GetMapping("/thejoeun/board/{id}")
	public String findByid(@PathVariable int id, Model model) {
		model.addAttribute("board",boardService.글상세보기(id));
		return "thejoeun/board/detail";
	}
	
	// 게시글 수정
	@GetMapping("/thejoeun/board/{id}/updateForm")
	public String updateForm(@PathVariable int id, Model model) {
		model.addAttribute("board",boardService.글상세보기(id));
		return "thejoeun/board/updateForm";
	}
	
	// 게시글 쓰기 | user권한 필요
	@GetMapping("/thejoeun/board/saveForm")
	public String saveForm() {
		return "thejoeun/board/saveForm";
	}
}
//@AuthenticationPrincipal PrincipalDetail principal
