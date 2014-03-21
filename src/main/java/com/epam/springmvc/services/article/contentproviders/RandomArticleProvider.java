package com.epam.springmvc.services.article.contentproviders;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.epam.springmvc.services.article.Article;

@Component
public class RandomArticleProvider implements ArticleProvider {
    //private static final Logger logger = Logger.getLogger(RandomArticleProvider.class.getName()

    @Autowired
    private ApplicationContext context;
    @Autowired
    private ArticleRepository articleRepository;
    private Random generator = new Random();
    
	private static final int ELEMENT_NUMBER = 2;
    
    
    @Override
    public List<Article> getArticles() {
    	ArrayList<Article> articles = (ArrayList<Article>) articleRepository.getArticles();
    	
    	ArrayList<Article> randomArticles = new ArrayList<Article>();
    	
    	if(ELEMENT_NUMBER > articles.size() || ELEMENT_NUMBER < 0) {
    		throw new IllegalArgumentException("Requested random element number could not bigger than current available Articles number and could not be less than 0");
    	}
        for (int i = 0; i < ELEMENT_NUMBER; i++) {
        	randomArticles.add(articles.get(generator.nextInt(articles.size())));
		}
        
        return randomArticles;
    }

	@Override
	public Article getArticle(int id) {
		ArrayList<Article> articles = (ArrayList<Article>) articleRepository.getArticles();
		
		if(id < articles.size()) {
			return articles.get(id);
		}
		throw new IllegalArgumentException("Illegal article ID number");
	}
}