package com.thejoeun.team2.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.thejoeun.team2.model.User;

import lombok.Getter;

//스프링 시큐리티의 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 유저 디테일 타입의 오브젝트를 \
//스프링 시큐리티의 세션에 저장해준다.
@Getter
public class PrincipalDetail implements UserDetails{
	private User user;//콤포지션

	public PrincipalDetail(User user) {
		this.user = user;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	//계정이 만료되지 않았는지 리턴(true일시 만료 안됨)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//계정이 잠겨있지 않았는지 리턴한다 (true : 잠기지 않음)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//비밀번호가 만료되진않았는지 리턴한다 ( true : 만료되지않음)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//계정이 활성화(사용가능)인지 리턴한다. (true : 활성화)
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				return "ROLE_"+user.getRole();//롤 받을때, 반드시 앞에 "롤_"적어줘야 값받아옴
			}
		});
		return null;
	}
	
}
