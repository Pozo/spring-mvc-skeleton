package com.epam.springmvc.services.article;

import java.util.List;

public interface ArticleService {
    public List<Article> getArticles();
    public Article getArticle(int id);
}
