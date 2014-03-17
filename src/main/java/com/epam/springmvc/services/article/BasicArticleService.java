package com.epam.springmvc.services.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.epam.springmvc.services.article.contentproviders.ConcreteArticleProvider;

@Service
public class BasicArticleService implements ArticleService {
	@Autowired
	private ApplicationContext context;

	@Override
	public List<Article> getArticles() {
		return context.getBean(ConcreteArticleProvider.class).getArticles();

	}

	@Override
	public Article getArticle(int id) {
		return context.getBean(ConcreteArticleProvider.class).getArticle(id);
	}

}
