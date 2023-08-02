package com.thejoeun.team2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thejoeun.team2.model.RoleType;
import com.thejoeun.team2.model.User;
import com.thejoeun.team2.repository.UserRepository;

//스프링이 컴포넌트 스캔을 통해서 빈에 등록을 해줌(ioc해주는거임)
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public void 회원가입(User user) {
		String rawPassword = user.getPassword();//1234원문
		String encPassword = encoder.encode(rawPassword);//해쉬화
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	} 
	
	@Transactional
	public void 회원수정(User user) {
		//수정시에는 영속성 컨텍스트 유저 오브젝트를 영속화 시키고, 영속화된 유저 오브젝트를 수정
		//셀렉트를 이용해서 유저 오브젝트를 db로부터 가져오는 이유는 영속화 하기 위해서다.
		//영속화된 오브젝트를 변경하면 자동으로 db에 업데이트문을 날려주기 때문.
		User persistance=userRepository.findById(user.getId()).orElseThrow(()->{
			return new IllegalArgumentException("회원찾기 실패");
		});
		
		if(persistance.getOauth()==null || persistance.getOauth().equals("")) {
			String rawPassword = user.getPassword();
			String enPassword = encoder.encode(rawPassword);
			persistance.setPassword(enPassword);
			persistance.setEmail(user.getEmail());
			//회원수정 함수 종료시 = 서비스 종료 = 트랜잭션 종료 = 커밋이 자동으로 됩니다.
			//영속화 된 persistance 객체의 변화가 감지되면 더티체킹이 되어 업데이트문을 자동으로 날려준다(깃허브같네)
		}
	}
	
//	@Transactional(readOnly = true)
//	public User 로그인(User user) {
//		return userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
//	}
	
	@Transactional(readOnly=true)
	public User 회원찾기(String username) {
		User user = userRepository.findByUsername(username).orElseGet(()->{
		return new User();
		});
		return user;
	}
	
}
