package org.lanqiao.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;


import org.lanqiao.domain.Post;
import org.lanqiao.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class PostService {
	@Autowired
	PostMapper pm;
	public List<Post> selectPost1(){
		List<Post> list=pm.selectPost1();
		return list;
	}
	public List selectPost(int post_id){
		List list=pm.selectPost(post_id);
		return list;
	}
	public Post selectPost2(int post_id){
		Post post=pm.selectPost2(post_id);
		return post;
	}
	public void insertReply(String reply_author,String reply_content,int reply_post_id){
		HashMap<String,Object> hashmap=new HashMap<String,Object>();
		Date date=new Date();
		hashmap.put("reply_author", reply_author);
		hashmap.put("reply_content", reply_content);
		hashmap.put("reply_date", date);
		hashmap.put("reply_post_id", reply_post_id);
		pm.insertReply(hashmap);
	}
	public void deleteReply(String[] reply_id){
		pm.deleteReply(reply_id);
	}
	public List<Post> selectPostVo(String post_author,Date post_date){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("post_author", post_author);
		map.put("post_date", post_date);
		List<Post> list=pm.selectPostVo(map);
		return list;
	}
	public List<HashMap> login(String username,String password){
		HashMap<String, Object> hashmap = new HashMap<>();
		hashmap.put("username", username);
		hashmap.put("password", password);
		List<HashMap> list=pm.login(hashmap);
		return list;
	}
	public void insertPost(Post post){
		pm.insertPost(post);
	}
	
	public void deletePost(String[] post_id){
		List<Post> list=pm.selectHistory(post_id);
		for (int i = 0; i < list.size(); i++) {
			Post post=list.get(i);
			pm.insertHistory(post);
		}
		pm.deletePost(post_id);
	}
	
	public void massService(){
		System.out.println("中式服务");
	}
	public void massServiceA(){
		System.out.println("泰式服务");
	}
	public void massServiceB(){
		System.out.println("日式服务");
	}
}
