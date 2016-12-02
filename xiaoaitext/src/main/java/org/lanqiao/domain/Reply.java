package org.lanqiao.domain;

import java.util.Date;

public class Reply {
	private int reply_id;
	private String reply_content;
	private String reply_author;
	private Date reply_date;
	public int getReply_id() {
		return reply_id;
	}
	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_author() {
		return reply_author;
	}
	public void setReply_author(String reply_author) {
		this.reply_author = reply_author;
	}
	public Date getReply_date() {
		return reply_date;
	}
	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}
	
}
