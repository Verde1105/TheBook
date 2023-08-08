package com.thejoeun.team2.model;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Admin {

	@Id//이거 포문 랜덤돌려서 영어라 숫자조합만들수있을것같은데
	@Column(nullable = false,length = 100, unique=true)
	private int adminId;
	
	@Column(nullable = false,length = 100, unique=true)
	private String adminName;
	
	@Column(nullable = false,length = 100)
	private String adminPassword;
	
	@Column(nullable = false,length = 50)
	private String adminEmail;
	
	@CreationTimestamp
	private Timestamp createDateAdmin;
	
	
	
	
	
}
