package com.epam.springmvc.services.article.contentproviders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import com.epam.springmvc.services.article.Article;
import com.epam.springmvc.services.article.utils.ThumbnailHelper;

@Repository
public class ArticleRepository {
    @Autowired
    private ApplicationContext context;
    
    private ArrayList<Article> articles = new ArrayList<Article>();

	public List<Article> getArticles() {
		if(articles.size() == 0) {
	        Article article = new Article();
	        Article article1 = new Article();
	        Article article2 = new Article();
	        
	        article.setDateTime("45 min");
	        article.setText("We have discovered an Asset Allocation Breach in your portfolio which require your attention. We have identified a trading opportunity which will correct this issue. ");
	        article.setTitle("Health Issue For UBS Advice Portfolio 1");
	        article.setThumbnail(String.format("%s%s","data:image/png;base64,", ThumbnailHelper.encodeToString(context.getClassLoader().getResourceAsStream("MockNotificationImage.png"))));
	        
	        article1.setDateTime("23.10.13");
	        article1.setText("Dear Heikko, you have a fairly high Apple exposure in UBS Brokerage Portfolio 2. Take a look at this trading idea.");
	        article1.setTitle("Janik has a new trading idea for you. ");
	        article1.setThumbnail(String.format("%s%s","data:image/png;base64,", ThumbnailHelper.encodeToString(context.getClassLoader().getResourceAsStream("MockNotificationImage.png"))));
	        
	        article2.setDateTime("23.08.13");
	        article2.setText("We have identified an opportunity within the high-tech sector which our research shows is likely to...");
	        article2.setTitle("New treading idea: UBS Brokerage Protfolio 3");
	        article2.setThumbnail(String.format("%s%s","data:image/png;base64,", ThumbnailHelper.encodeToString(context.getClassLoader().getResourceAsStream("MockNotificationImage.png"))));
	        
	        articles.add(article);
	        articles.add(article1);
	        articles.add(article2);
		}
		return articles;

	}
}
