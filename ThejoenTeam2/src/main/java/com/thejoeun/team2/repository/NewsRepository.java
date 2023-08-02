package com.thejoeun.team2.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoeun.team2.model.NewsArticle;


@Repository
public interface NewsRepository extends JpaRepository<NewsArticle, Long> {
   
}
