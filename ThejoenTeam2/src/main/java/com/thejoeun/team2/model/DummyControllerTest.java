package com.thejoeun.team2.model;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thejoeun.team2.repository.UserRepository;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

@RestController
public class DummyControllerTest {

	@Autowired//의존성 주입
	private UserRepository userRepository;
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {//엠티 = 비어있는것. 비어있는 데이터를 선택할시의 익셉션
			return "삭제에 실패하였습니다. 해당 id는 db에 존재하지 않습니다.";
		}
		
		return "삭제 되었습니다! id : " + id;
	}
	
	//<세이브가 있을시>
	//세이브 함수는 id를 전달하지 않으면 인서트를 해주고
	//세이브 함수는 id를 전달하면 해당 id에 대한 데이터가 있으면 업데이트를 해주고
	//세이브 함수는 id를 전달하면 해당 id에 대한 데이터가 없으면 인서트를 한다.
	//이메일이랑 패스워드 받아야함.
	@Transactional//더티채킹, 함수 종료시에 바동 커밋이 됨. 깃허브느낌인거같은데.
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
		System.out.println("id : " + id);//아이디로 업데이트할 계정 선택
		System.out.println("password : " + requestUser.getPassword());
		System.out.println("Email : " + requestUser.getEmail());
		
		User user = userRepository.findById(id).orElseThrow(()->{//람다식
			return new IllegalArgumentException("수정이 불가능 합니다. 아래 사항을 참고해 주세요!");
		});
		user.setPassword(requestUser.getPassword());//여기서 데이터베이스에서 가져온 정보를 수정
		user.setEmail(requestUser.getEmail());
		
//		userRepository.save(user);//없으면 인서트로 업데이트 안됨. 세이브 없어도 업데이트는 가능
		return null;
	}
	
	@GetMapping("/dummy/users")
	public List<User> list(){
	   return userRepository.findAll();
	}
	
	@GetMapping("/dummy/user")//size 갯수에 따라 한 페이지에 몇개나 가져올지 정할 수 있음.
	public Page<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Direction.DESC)Pageable pageble){
		Page<User> pagingUser = userRepository.findAll(pageble);
		if(pagingUser.isLast()) {
			
		}
		List<User> users = pagingUser.getContent();
		return pagingUser;
	}
//	http://127.0.0.1:8000/blog/
	
	
//	http://localhost:8000/blog/dummy/user/
//	{id} 주소로 파라미터를 전달받을 수 있음.
//	@GetMapping("/dummy/user/{id}")
//	public User detail(@PathVariable int id) {
////		옵션으로 유저 객체를 감싸서 가져온다
////		이후 널인지 아닌지 판단해서 리턴
//		User user = userRepository.findById(id).orElseGet(new Supplier<User>() {//.orElseGet = 널 값일때 새 서플라이어를 만들어서 보여줘
//			@Override
//			public User get() {
//				return new User();
//			}
//			
//		});
//		//.get이라 하면 널값이 날리 없는 확신범일때 쓰는것.
//		return user;
//	}덜좋아하는 방법
	
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("존재하지 않는 유저입니다! id : " + id);
			}
		});
		return user;
	}
	
	//http://localhost:8000/blog/dummy/join
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " +user.getPassword());
		System.out.println("email : " + user.getEmail());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return"회원가입이 완료되었습니다!";
	}
	
}
