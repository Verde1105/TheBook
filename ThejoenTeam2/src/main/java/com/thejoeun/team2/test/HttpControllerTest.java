package com.thejoeun.team2.test;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest : ";
	
	@GetMapping("http/lombok")
	public String lombokTest() {
//		Member member = new Member(1, "testid", "p@ssword1234", "test@test.com");
		Member member = Member.builder().username("testName").password("p@ssword1234").email("test@test.com").build();
		System.out.println(TAG + "getter : "+member.getUsername());
		member.setUsername("setUserName");
		System.out.println(TAG + "setter : "+member.getUsername());
		Member member1 = new Member(1, "testid", "1234", "test@test.com");
		return "lombok Test 완료";
		
	}
	
	//http://localhost:8080/blog/http/get (select)
	@GetMapping("/http/get") 
	public String getTest(Member member) {
		return "get 요청 : ";
	}
	
	//http://localhost:8080/blog/http/post (insert)
	@PostMapping("/http/post")
	public String postTest(@RequestBody  Member m) {
		return "post 요청" + m.getClass(); 
	}
	//http://localhost:8080/blog/http/put (update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청" + m.getClass();
	}
	//http://localhost:8080/blog/http/delete (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
	
}
