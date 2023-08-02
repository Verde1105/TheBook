package com.thejoeun.team2.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.thejoeun.team2.model.NewsArticle;
import com.thejoeun.team2.repository.NewsRepository;



@Controller
public class NewsController{
	@Autowired
    private NewsRepository newsRepository;


	  @GetMapping("/thejoeun/news")
	    public String showNews(Model model) {
	        List<NewsArticle> newsList = newsRepository.findAll();
	        model.addAttribute("newsList", newsList);
	        return "thejoeun/writing/news";
	    }
	}