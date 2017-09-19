package com.daogukeji.dapeng.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daogukeji.dapeng.dao.OrderDAO;
import com.daogukeji.dapeng.dao.OrderDAO_Voice;
import com.daogukeji.dapeng.entity.Dapeng_1_Order_Voice;

public class TestOrderDAO_Voice {
	
	@Test
	public void testAddOrder_Voice(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		OrderDAO_Voice dao = ctx.getBean("orderDAO_Voice",OrderDAO_Voice.class);
		Dapeng_1_Order_Voice dp_1_o_v = new Dapeng_1_Order_Voice("1");
		dao.addOrder_Voice(dp_1_o_v);
	}
	@Test
	public void testFindOrder_Voice(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		OrderDAO_Voice dao = ctx.getBean("orderDAO_Voice",OrderDAO_Voice.class);
		System.out.println(dao.findOrder_Voice());
	}

}
