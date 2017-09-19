package com.daogukeji.dapeng.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daogukeji.dapeng.dao.OrderDAO_DiGuan;
import com.daogukeji.dapeng.entity.Dapeng_1_Order_DiGuan;

public class TestOrderDAO_DiGuan {
	
	@Test
	public void testAddOrder_Voice(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		OrderDAO_DiGuan dao = ctx.getBean("orderDAO_DiGuan",OrderDAO_DiGuan.class);
		Dapeng_1_Order_DiGuan dp_1_o_jl = new Dapeng_1_Order_DiGuan("1");
		dao.addOrder_DiGuan(dp_1_o_jl);
	}
	@Test
	public void testFindOrder_Voice(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		OrderDAO_DiGuan dao = ctx.getBean("orderDAO_DiGuan",OrderDAO_DiGuan.class);
		System.out.println(dao.findOrder_DiGuan());
	}

}
