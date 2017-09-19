package com.daogukeji.dapeng.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daogukeji.dapeng.dao.OrderDAO_JuanLian;

import com.daogukeji.dapeng.entity.Dapeng_1_Order_JuanLian;

public class TestOrderDAO_JuanLian {
	
	@Test
	public void testAddOrder_Voice(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		OrderDAO_JuanLian dao = ctx.getBean("orderDAO_JuanLian",OrderDAO_JuanLian.class);
		Dapeng_1_Order_JuanLian dp_1_o_jl = new Dapeng_1_Order_JuanLian("1");
		dao.addOrder_JuanLian(dp_1_o_jl);
	}
	@Test
	public void testFindOrder_Voice(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		OrderDAO_JuanLian dao = ctx.getBean("orderDAO_JuanLian",OrderDAO_JuanLian.class);
		System.out.println(dao.findOrder_JuanLian());
	}

}
