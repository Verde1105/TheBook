package com.thejoeun.team2.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
@Data
@NoArgsConstructor
public class Member {
	
//	private int id = 1;
//	private String username = "test";
//	private String password = "0001";
//	private String email = "test@nate.com";
	
	private int id;
	private String username;
	private String password;
	private String email;
	
	@Builder
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
}
