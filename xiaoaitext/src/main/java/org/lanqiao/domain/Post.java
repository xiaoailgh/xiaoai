package org.lanqiao.domain;

import java.util.Date;

public class Post {
	private int post_id;
	private String post_title;
	private String post_author;
	private Date post_date;
	private String post_content;
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_author() {
		return post_author;
	}
	public void setPost_author(String post_author) {
		this.post_author = post_author;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
}
