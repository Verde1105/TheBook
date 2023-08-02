package com.thejoeun.team2.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder//빌더패턴
//orm > java(다른언어) 오브젝트 > xpdlqmffh aovldgownsms rltnf
@Entity//유저 클래스가  자동으로 데이터베이스에 테이블 생성
//@DynamicInsert 인서트 시에 널인 필드를 제외시켜 준다.
public class User {

	@Id//프라이머리키 생성
	@GeneratedValue(strategy = GenerationType.IDENTITY)//프로젝트에서 연결 된 db의 넘버링 전략을 '따라간다.=아이덴티티'
	private int id;
	
	@Column(nullable = false,length=100, unique=true)
	private String username;
	
	@Column(nullable = false,length = 100)
	private String password;
	
	@Column(nullable = false,length = 50)
	private String email;

//	@ColumnDefault("user") 야 기억해 ㅋㅋㅋ. 이넘 없이 이것만 했을때 테이블 안만들어졌음ㅋㅋㅋ.
	@Enumerated(EnumType.STRING)//DB는 롤타입이라는게 없어서, 이넘파일의 타입을 따라가 달라고 이야기한것.
	private RoleType role;//이넘 을 쓰는게 좋다. //어드민,유저.매니저(특정 권한을 줄수있다)
	
	private String oauth;//카카오, 구글
	
	@CreationTimestamp//시간이 자동입력
	private Timestamp createDate;
}
