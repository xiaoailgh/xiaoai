package org.lanqiao.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Aop {
	public void begin(){
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd hh:mm:ss");
		System.out.println(sdf.format(new Date()));
		System.out.println("��ӭ���ٺ�����");
	}
	public void end(){
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd hh:mm:ss");
		System.out.println(sdf.format(new Date()));
		System.out.println("�´�����Ŷ");
	}
}
