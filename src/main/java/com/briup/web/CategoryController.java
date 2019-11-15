package com.briup.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Category;
import com.briup.service.ICategoryService;
import com.briup.util.Message;
import com.briup.util.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "栏目接口")
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	ICategoryService categoryService;
	
	@ApiOperation(value = "查询所有栏目")
	@GetMapping("/findAll")
	public Message findAll()
	{
		return MessageUtil.success("查询成功",categoryService.findAll() );
	}
	
	@ApiOperation(value = "通过id删除栏目")
	@GetMapping("/deleteById")
	public Message deleteById(Integer id)
	{
		categoryService.deleteById(id);
		return MessageUtil.success("删除成功");
	}
	
	@ApiOperation(value = "更新或插入数据")
	@PostMapping("/saveOrUpdate")
	public Message saveOrUpdate(
			@ApiParam(name = "id",value = "编号")@RequestParam(required = false,name = "id") Integer id,
			@ApiParam(name = "name",value = "栏目名称")@RequestParam(required = true,name = "name") String name,
			@ApiParam(name = "description",value = "栏目描述")@RequestParam(required = false,name = "description")String description
	)
	{
		Category category = new Category();
		category.setId(id);
		category.setName(name);
		category.setDescription(description);
		categoryService.saveOrUpdate(category);
		System.out.println("test git history");
		
		
		
		return MessageUtil.success("更新成功");
		
	}
	

	@ApiOperation(value = "批量删除栏目")
	@PostMapping(value = "batchDelete")
	public Message batchDelete( Integer[] ids)
	{
		System.out.println(Arrays.toString(ids));
		categoryService.batchDelete(ids);
		return MessageUtil.success("批量删除成功");
	}
}
