package org.lanqiao.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.lanqiao.domain.Post;
import org.lanqiao.domain.PostVo;
import org.lanqiao.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
@Controller
@RequestMapping("/user")
public class PostController {
	@Autowired
	PostService ed;
	//登陆
		@RequestMapping("/login")
		public String login(String username,String password,HttpSession session){
			try {
				username = new String(username.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<HashMap> list=ed.login(username,password);
			
			if(list.size()!=0){
				session.setAttribute("reply_author", username);
				return "redirect:/user/post";
			}else{
				return "login";
			}
			
		}
		//帖子
		@RequestMapping("/post")
		public String post(Model model){
			List<Post> list=ed.selectPost1();
			model.addAttribute("list",list);
			return "tiezi";
		}
		//回帖
		@RequestMapping("/reply")
		public String reply(int post_id,Model model,HttpSession session){
			session.setAttribute("reply_post_id", post_id);
			List list=ed.selectPost(post_id);
			model.addAttribute("list",list);
			Post post=ed.selectPost2(post_id);
			model.addAttribute("post",post);
			return "reply";
		}
		//添加回复
		@RequestMapping("/addReply")
		public String add(String reply_content,HttpSession session){
			try {
				reply_content = new String(reply_content.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int post_id=(int) session.getAttribute("reply_post_id");
			String reply_author=(String)session.getAttribute("reply_author");
			ed.insertReply(reply_author, reply_content,post_id);
			return "redirect:/user/reply?post_id="+post_id;
		}
		//删除帖子
		@RequestMapping("/ajaxdel")
		public void ajaxdel(String[] reply_id,HttpServletResponse response){
			
			ed.deleteReply(reply_id);
			HashMap<String,Object> hashmap=new HashMap<String,Object>();
			hashmap.put("status", "y");
			hashmap.put("msg", "删除成功");
			Gson gson= new Gson();
			String json=gson.toJson(hashmap);
			try {
				response.getWriter().print(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//多条件查询帖子
		@RequestMapping(value="/select2")
		public String selectPost(PostVo pv, Model model){
			String post_author  = pv.getPost_author();
			if(post_author.equals("") ){
				post_author = null;
			}else{
				try {
					post_author = new String(post_author.getBytes("iso-8859-1"),"utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			String post_date = pv.getPost_date();
			Date postDate = null;
			if(post_date.equals("") ){
				post_date = null;
			}else{
				DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
				try {
					 postDate = format1.parse(post_date);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}	
			}
			pv.setPost_date(post_date);
			List<Post> list=ed.selectPostVo(post_author,postDate);
			model.addAttribute("list",list);
			return "tiezi";
		}
		//发帖
		@RequestMapping("/bootPost")
		public String bootPost(HttpSession session,String post_content,String post_title){
			try {
				post_content = new String(post_content.getBytes("iso-8859-1"),"utf-8");
				post_title = new String(post_title.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String post_author=(String) session.getAttribute("reply_author");
			Post post=new Post();
			post.setPost_author(post_author);
			post.setPost_content(post_content);
			post.setPost_title(post_title);
			Date post_date=new Date();
			post.setPost_date(post_date);
			ed.insertPost(post);
			return "redirect:/user/post";
		}
		//删帖
		@RequestMapping("/deletePost")
		public void deletePost(String[] post_id,HttpServletResponse response){
			
			ed.deletePost(post_id);
			HashMap<String,Object> hashmap=new HashMap<String,Object>();
			hashmap.put("status", "y");
			hashmap.put("msg", "删除成功");
			Gson gson= new Gson();
			String json=gson.toJson(hashmap);
			try {
				response.getWriter().print(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
