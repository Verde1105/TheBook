package com.thejoeun.team2.Controller.thejoeun.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thejoeun.team2.config.auth.PrincipalDetail;
import com.thejoeun.team2.dto.ResponseDto;
import com.thejoeun.team2.model.Board;
import com.thejoeun.team2.model.RoleType;
import com.thejoeun.team2.model.User;
import com.thejoeun.team2.service.BoardService;
import com.thejoeun.team2.service.UserService;

@RestController
public class ThejoeunBoardApiController {

	@Autowired
	private BoardService boardService;
	
	@PostMapping("/Thejoeun/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) {
		boardService.글쓰기(board,principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@DeleteMapping("/Thejoeun/api/board/{id}")
	public ResponseDto<Integer> deleteById(@PathVariable int id){
		boardService.글삭제하기(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@PutMapping("/Thejoeun/api/board/{id}")
	private ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board) {
		System.out.println("BoardApiController update : id :"+id);
		System.out.println("BoardApiController update : board :"+board.getTitle());
		System.out.println("BoardApiController update : board :"+board.getContent());
		boardService.글수정하기(id,board);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	
}
	