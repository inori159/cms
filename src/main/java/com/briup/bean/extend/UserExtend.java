package com.briup.bean.extend;

import java.util.List;

import com.briup.bean.Comment;
import com.briup.bean.Logs;
import com.briup.bean.Role;
import com.briup.bean.User;

public class UserExtend extends User{
	
	private List<Role> roles;
	private List<ArticleExtend> articleExtends;
	private List<Comment> comments;
	private List<Logs> logs;

	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public List<ArticleExtend> getArticleExtends() {
		return articleExtends;
	}
	public void setArticleExtends(List<ArticleExtend> articleExtends) {
		this.articleExtends = articleExtends;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Logs> getLogs() {
		return logs;
	}
	public void setLogs(List<Logs> logs) {
		this.logs = logs;
	}

}
