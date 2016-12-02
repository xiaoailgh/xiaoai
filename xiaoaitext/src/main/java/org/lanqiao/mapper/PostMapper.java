package org.lanqiao.mapper;


import java.util.HashMap;
import java.util.List;

import org.lanqiao.domain.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface PostMapper {
	public List<Post> selectPost1();
	public List selectPost(int post_id);
	public Post selectPost2(int post_id);
	public void insertReply(HashMap hashmap);
	public void deleteReply(String[] reply_id);
	public List<Post> selectPostVo(HashMap hashmap);
	public List<HashMap> login(HashMap hashmap);
	public void insertPost(Post post);
	public void deletePost(String[] post_id);
	public void insertHistory(Post post);
	public List<Post> selectHistory(String[] post_id);
}
