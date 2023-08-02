package com.thejoeun.team2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thejoeun.team2.model.User;

//DAO
//자동으로 빈 등록이 된다.
//전에는 어노테이션 레파지토리라고 해주었어야하지만 지금은 생략가능
public interface UserRepository extends JpaRepository<User,Integer>{
	//select * from user where username = 1?;
	Optional<User> findByUsername(String username);
	
}
// jpa 네이밍 전략
//select * from user WHERE username = ?1 AND password = ?2;
//	User findByUsernameAndPassword(String username, String password);

//	@Query(value = "select * from user WHERE username = ?1 AND password = ?2")
//	User login(String username, String password);//네이티브 쿼리라 함.
