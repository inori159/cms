package com.briup.service;

import java.util.List;

import com.briup.bean.Article;
import com.briup.bean.Category;
import com.briup.bean.extend.ArticleExtend;

public interface ICategoryService {
	public List<Category> findAll();
	
	public void deleteById(Integer id);
	
	public void saveOrUpdate(Category category) throws RuntimeException;
	
	public void batchDelete(Integer[] ids);
}
