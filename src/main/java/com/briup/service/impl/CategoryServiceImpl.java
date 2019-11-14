package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.briup.bean.Article;
import com.briup.bean.Category;
import com.briup.bean.CategoryExample;
import com.briup.dao.CategoryMapper;
import com.briup.service.ICategoryService;
import com.briup.util.CustomerException;

public class CategoryServiceImpl implements ICategoryService{

	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public List<Category> findAll() {
		
		return categoryMapper.selectByExample(new CategoryExample());
	}

	@Override
	public void deleteById(Integer id) {
		categoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void saveOrUpdate(Category category) throws RuntimeException {
		if(category.getId()!=null)
		{
			categoryMapper.updateByPrimaryKey(category);
		}
		else
		{
			List<Category> list = findAll();
			for(Category c: list)
			{
				if(c.getName().equals(category.getName()))
				{
					throw new CustomerException();
				}
			}
			categoryMapper.insert(category);
		}
		
	}

}
