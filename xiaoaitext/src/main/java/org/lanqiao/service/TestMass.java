package org.lanqiao.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMass {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		PostService ps=ac.getBean("PostService",PostService.class);
		ps.massService();
		ps.massServiceA();
		ps.massServiceB();
	}
}
