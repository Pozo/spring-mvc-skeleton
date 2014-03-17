package com.epam.springmvc.services.article.contentproviders;

import java.util.List;

import com.epam.springmvc.services.article.Article;


public interface ArticleProvider {
    public List<Article> getArticles();
    public Article getArticle(int id);
}
