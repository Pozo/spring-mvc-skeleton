package com.epam.springmvc.controllers;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.epam.springmvc.services.article.Article;
import com.epam.springmvc.services.article.ArticleService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/articles")
public class ArticleController {
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	@Autowired
	private ArticleService articleService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
    @RequestMapping(value = "/{id}", method=RequestMethod.GET, produces="application/json")
    @ResponseBody
	public Article getArticle(@PathVariable("id") int id) {		
	
		return articleService.getArticle(id);
	}
    @RequestMapping(value = "",method=RequestMethod.GET, produces="application/json")
    @ResponseBody
	public List<Article> getArticles() {		
	
		return articleService.getArticles();
	}
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String processSystemError(Exception exception) {
		String retval = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			retval = mapper.writeValueAsString(exception);
		} catch (JsonGenerationException e) {
			
			logger.error(e.getMessage());
		} catch (JsonMappingException e) {

			logger.error(e.getMessage());
		} catch (IOException e) {

			logger.error(e.getMessage());
		}
		return retval;
	}
}
