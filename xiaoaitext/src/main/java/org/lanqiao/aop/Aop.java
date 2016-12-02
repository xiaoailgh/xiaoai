package org.lanqiao.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Aop {
	public void begin(){
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd hh:mm:ss");
		System.out.println(sdf.format(new Date()));
		System.out.println("欢迎光临红浪漫");
	}
	public void end(){
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd hh:mm:ss");
		System.out.println(sdf.format(new Date()));
		System.out.println("下次再来哦");
	}
}
