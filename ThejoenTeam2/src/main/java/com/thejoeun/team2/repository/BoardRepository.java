package com.thejoeun.team2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thejoeun.team2.model.Board;

public interface BoardRepository extends JpaRepository<Board,Integer>{
	
}
