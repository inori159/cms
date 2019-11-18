package com.briup.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Article;
import com.briup.service.IArticleService;
import com.briup.util.Message;
import com.briup.util.MessageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value  = "文章接口")
@Validated
@RestController
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	IArticleService ias;
	
	
	@ApiOperation(value = "查找所有文章")
	@GetMapping("findAll")
	public Message findAll()
	{
		return MessageUtil.success("成功", ias.findAll());
	}
	
	@ApiOperation(value = "分页")
	@GetMapping("findAllPage")
	public Message findAllPage()
	{
		PageHelper.startPage(1, 2);
		List<Article> list = ias.findAll();
		PageInfo<Article> pageInfo = new PageInfo<Article>(list);
		return MessageUtil.success("成功", pageInfo);
	}
	
	@ApiOperation(value = "查找所有栏目的文章")
	@GetMapping("cascadeFindAll")
	public Message cascadeFindAll()
	{
		return MessageUtil.success("成功", ias.cascadeFindAll());
	}
	
	
	@ApiOperation(value = "查找文章即评论")
	@ResponseBody
	@GetMapping("findById")
	public Message findById(Integer id)
	{
		return MessageUtil.success("成功", ias.findById(id));
	}
	
	
	@ApiOperation(value = "保存或更新的接口")
	@PostMapping("saveOrUpdate")
	public Message saveOrUpdate(
			@ApiParam(value = "编号") @RequestParam(value = "id",required = false) Integer id,
			@ApiParam(value = "标题")@RequestParam(value = "title",required = false)String title,
			@ApiParam(value = "文章内容")@RequestParam(value = "content",required = false)String content,
			@ApiParam(value = "文章源")@RequestParam(value = "source",required = false)String source,
			@ApiParam(value = "作者")@RequestParam(value = "authorId",required = false)Integer authorId,
			@ApiParam(value = "栏目")@RequestParam(value = "categoryId",required = true)Integer categoryId			
			)
	{
		Article article = new Article();
		article.setId(id);
		article.setTitle(title);
		article.setContent(content);
		article.setAuthorId(authorId);
		article.setCategoryId(categoryId);
		ias.saveOrUpdate(article);
		return MessageUtil.success("成功");
	}
	@ApiOperation(value = "通过Id来删除")
	@ApiImplicitParams(
			@ApiImplicitParam(name="id",value = "编号",required = true,paramType = "query") 
	)
	@GetMapping("deleteById")
	public Message deleteById(Integer id)
	{
		ias.deleteById(id);
		return MessageUtil.success("删除成功");
	}
}
