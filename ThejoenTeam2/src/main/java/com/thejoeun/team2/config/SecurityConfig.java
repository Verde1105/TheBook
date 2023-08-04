package com.thejoeun.team2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.thejoeun.team2.config.auth.PrincipalDetailService;

@Configuration//빈등록해주는 어노테이션
@EnableWebSecurity//싴리티 필터가 등록이 된다
@EnableGlobalMethodSecurity(prePostEnabled = true)//특정 주소로 권한 및 인증을 미리 체크하겠다.
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean//ioc가 되는중
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}

	//시큐리티가 대신 로그인할때 시큐리티가 패스워드를 가로챔
	//해당 패스워드가 뭘로 해쉬가 되어 회원가입이 되었는지 알아야
	//같은 해쉬로 암호화해서 데이터베이스에있는 해쉬랑 비교할수있음.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()//csrf 토큰 비활성화(테스트시 걸어두는게 좋음)
		.authorizeHttpRequests()
		.antMatchers("/auth/**","/images/**","/css/**","/thejoeun/**","/assets/**","/js/**")//우리 시큐리티 목줄. (적힌 경로 "만" 허용됨)
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/auth/loginForm")//로그인 페이지
		.loginProcessingUrl("/auth/loginProc")//로그인 연산하는곳
		.defaultSuccessUrl("/thejoeun/index");//기본으로 띄워주는 페이지(로그인 후 돌아오는 페이지)
	}
}
