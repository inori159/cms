package com.briup.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.bean.Article;
import com.briup.bean.ArticleExample;
import com.briup.bean.extend.ArticleExtend;
import com.briup.dao.ArticleMapper;
import com.briup.dao.extend.ArticleExtendMapper;
import com.briup.service.IArticleService;
import com.briup.util.CustomerException;


@Service
public class ArticleServiceImpl implements IArticleService{

	private static String status = "正在审核";
	
	@Resource
	ArticleMapper am;
	
	@Resource
	ArticleExtendMapper aem;
	
	@Override
	public List<Article> findAll() {		
		return am.selectByExample(new ArticleExample());
	}
	

	
	@Override
	public List<ArticleExtend> findById(int id) {
		return aem.findById(id);
	}

	@Override
	public void saveOrUpdate(Article article) {
		if(article.getId()!=null)
		{
			System.out.println("执行更改");
			am.updateByPrimaryKey(article);
		}else
		{				
			if(am.selectByPrimaryKey(article.getId())!=null)
			{
				throw new CustomerException();
			}
			article.setPublishTime(new Date().getTime());
			article.setReadTimes(0L);		
			article.setStatus(status);
			article.setThumbUp(0);
			article.setThumbDown(0);
			am.insert(article);
		}
		
	}
	@Override
	public List<ArticleExtend> cascadeFindAll() {
		return aem.cascadeFindAll();
	}


	
}
