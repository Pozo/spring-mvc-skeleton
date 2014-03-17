package com.epam.springmvc.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.springmvc.services.article.Article;
import com.epam.springmvc.services.article.ArticleService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping()
public class ArticleController {
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	@Autowired
	private ArticleService articleService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
    @RequestMapping(value = "/articles/{id}", method=RequestMethod.GET, produces="application/json")
    @ResponseBody
	public Article getArticle(@PathVariable("id") int id) {		
	
		return articleService.getArticle(id);
	}
    @RequestMapping(value = "/articles",method=RequestMethod.GET, produces="application/json")
    @ResponseBody
	public List<Article> getArticles() {		
	
		return articleService.getArticles();
	}
}
