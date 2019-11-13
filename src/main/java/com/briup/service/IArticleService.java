package com.briup.service;

import java.util.List;

import com.briup.bean.Article;
import com.briup.bean.extend.ArticleExtend;

public interface IArticleService {
	
	public List<Article> findAll();
	
	public List<ArticleExtend> findById(int id);
	
	public List<ArticleExtend> cascadeFindAll();
	
	public void saveOrUpdate(Article article) throws RuntimeException;
}
