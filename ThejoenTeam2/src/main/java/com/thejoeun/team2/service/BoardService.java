package com.thejoeun.team2.service;

//import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thejoeun.team2.model.Board;
import com.thejoeun.team2.model.Reply;
import com.thejoeun.team2.model.RoleType;
import com.thejoeun.team2.model.User;
import com.thejoeun.team2.repository.BoardRepository;
import com.thejoeun.team2.repository.ReplyRepository;
import com.thejoeun.team2.repository.UserRepository;

//스프링이 컴포넌트 스캔을 통해서 빈에 등록을 해줌(ioc해주는거임)
@Service
public class BoardService {

	
	@Autowired
	private BoardRepository boardRepository;

	@Transactional
	public void 글쓰기(Board board, User user) {//받는거 두가지 타이블 + 컨텐츠
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	} 
	
	@Transactional(readOnly = true)
	public Page<Board> 글목록(Pageable pageable) {
//		return boardRepository.findAll(pageable);
		return boardRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Board 글상세보기(int id) {
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글상세보기 실패 : 아이디를 찾을수가 없습니다.");
				});
	}
	
	@Transactional(readOnly = true)
	public void 글삭제하기(int id) {
		System.out.println("글삭제하기 : " + id);
		boardRepository.deleteById(id);
		
	}
	
	@Transactional
	public void 글수정하기(int id,Board requestBoard) {
		Board board = boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 찾기 실패 : 대당하는 글을 찾을 수 없습니다.");
				});//영속화 완료
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());// [오류수정20230522] 내용이 빠져있었음!!
		board.setCount(requestBoard.getCount());
		//해당 함수 종료시(서비스 조욜시) 트랜잭션 종료, 자동 업데이트가 되어서 db에 갱신
	}

}
