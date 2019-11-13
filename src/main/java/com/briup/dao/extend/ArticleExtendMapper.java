package com.briup.dao.extend;

import java.util.List;

import com.briup.bean.extend.ArticleExtend;

public interface ArticleExtendMapper {
	List<ArticleExtend> cascadeFindAll();
	List<ArticleExtend> findById(int id);
}
