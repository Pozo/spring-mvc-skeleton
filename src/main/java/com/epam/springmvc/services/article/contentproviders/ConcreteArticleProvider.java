package com.epam.springmvc.services.article.contentproviders;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.epam.springmvc.services.article.Article;

@Component
public class ConcreteArticleProvider implements ArticleProvider {
	private static final Logger logger = Logger.getLogger(ConcreteArticleProvider.class.getName());

    @Autowired
    private ApplicationContext context;
    @Autowired
    private ArticleRepository articleRepository;
    
    private ArrayList<Article> articles;
    
	@Override
	public List<Article> getArticles() {
		ArrayList<Article> articles = new ArrayList<Article>();
        
		Article article = articleRepository.getArticles().get(0);
		
		articles.add(article);		
		
		return articles;
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
