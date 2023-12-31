package com.thejoeun.team2.Controller;

import java.util.UUID;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thejoeun.team2.config.auth.PrincipalDetail;
import com.thejoeun.team2.model.KakaoProfile;
import com.thejoeun.team2.model.OAuthToken;
import com.thejoeun.team2.model.User;
import com.thejoeun.team2.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


@Controller
public class UserController {

	@Value("${cos.key}")
	private String cosKey;
	
	@Autowired
	private AuthenticationManager authenticationManager;
   
	@Autowired
	private UserService userService;
	   
	
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		System.out.println("Success Login");
		return "user/loginForm";
//		return "thejoeun/index";
	}

	@GetMapping("/auth/kakao/callback")
	public String kakaoCallback(String code) { //@ResponseBody: data를 리턴해주는 컨트롤러 함수
		//이제 인증된 코드값을 통해 액세스토큰 부여받고, 리소스서버에 등록된 개인정보를 응답받기 위해서 토큰을 부여받아야함.
		
		//POST방식으로 key=value 데이터를 kakao쪽으로 요청
		//Retrofit2(안드로이드에서 자주 사용), OkHttp, RestTemplate
		RestTemplate rt = new RestTemplate(); 
		
		//HttpHeader 오브젝트 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8"); //key=value형태
		
		//HttpBody오브젝트 생성
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "e629bfd8e3ae75a62fdc225cda9c4a9c&redirect_uri=http://localhost:8080/auth/kakao/calback&re");
		params.add("redirect_uri", "http://localhost:8080/auth/kakao/callback");
		params.add("code", code);
		
		//HttpHeader와 HttpBody를 하나의 오브젝트에 담자
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
				new HttpEntity<>(params,headers);
		
		//Http 요청하기- POST방식으로, 그리고 response변수의 응답 받음
		ResponseEntity<String> response = rt.exchange(
			"https://kauth.kakao.com/oauth/token", //토큰발급요청주소
			HttpMethod.POST,
			kakaoTokenRequest,
			String.class //응답
				);
		
		//라이브러리: Gson, Json Simple, ObjectMApper, 
		ObjectMapper objectMapper=new ObjectMapper();
		OAuthToken oauthToken = null;
		try {
			 oauthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("카카오엑세스토큰"+oauthToken.getAccess_token());
	
		
		
		RestTemplate rt2 = new RestTemplate();
		
		//HttpHeader 오브젝트 생성
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization","Bearer "+oauthToken.getAccess_token());
		headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		
		//HttpHeader와 HttpBody를 하나의 오브젝트에 담자
		HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest2 =
				new HttpEntity<>(headers2);
		
		//Http 요청하기- POST방식으로, 그리고 response변수의 응답 받음
		ResponseEntity<String> response2 = rt2.exchange(
			"https://kapi.kakao.com/v2/user/me", //토큰발급요청주소
			HttpMethod.POST,
			kakaoProfileRequest2,
			String.class //응답
				);
		
		System.out.println(response2.getBody());
		
		
		//
		ObjectMapper objectMapper2=new ObjectMapper();
		KakaoProfile kakaoProfile = null;
		try {
			kakaoProfile = objectMapper2.readValue(response2.getBody(), KakaoProfile.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		//User오브젝트
		System.out.println("카카오아이디(번호):"+kakaoProfile.getId());
		System.out.println("카카오 이메일:"+kakaoProfile.getKakao_account().getEmail());
		
		
		//
		System.out.println("블로그 유저네임:" +kakaoProfile.getKakao_account().getEmail()+"_"+kakaoProfile.getId());
		System.out.println("블로그 서버 이메일:"+kakaoProfile.getKakao_account().getEmail());
		//UUID란?: 중복되지 않는 어떤 특정 값을 만들어내는 알고리즘
		UUID garbagePassword = UUID.randomUUID();
		System.out.println("블로그서버 패스워드:"+cosKey);

		User kakaoUser =User.builder()
				.username(kakaoProfile.getKakao_account().getEmail()+"_"+kakaoProfile.getId())
				.password(cosKey)
				.email(kakaoProfile.getKakao_account().getEmail())
				.oauth("kakao")
				.build();
				
		//가입자 혹은 비가입자 
		User originUser=userService.회원찾기(kakaoUser.getUsername());
		
		if(originUser.getUsername()==null) {
			kakaoUser.setEmail("이메일 없음");
			System.out.println("기존회원 아닙니당~");
			userService.회원가입(kakaoUser);
		}
		
		//로그인처리
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(kakaoUser.getUsername(), cosKey));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return "redirect:/thejoeun/index";
		
		
	}


	   
	
	@GetMapping("/user/updateForm")
	public String updateForm(@AuthenticationPrincipal PrincipalDetail principal) {
		System.out.println("회원정보 수정!");
		return "user/updateForm";
	}
}
