package com.briup.bean.extend;

import java.util.List;

import com.briup.bean.Article;
import com.briup.bean.Category;
import com.briup.bean.Comment;
import com.briup.bean.User;

public class ArticleExtend extends Article{
	private Category category;
	private List<Comment> comments;
	private User user;
	public Category getCategory() {
		return category;
	}



	public List<Comment> getComments() {
		return comments;
	}



	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public List<Comment> getComment() {
		return comments;
	}



	public void setComment(List<Comment> comments) {
		this.comments = comments;
	}



	public void setCategory(Category category) {
		this.category = category;
	}
}
