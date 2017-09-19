package com.daogukeji.dapeng.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daogukeji.dapeng.dao.OrderDAO_JuanLian;
import com.daogukeji.dapeng.dao.OrderDAO_Led;
import com.daogukeji.dapeng.entity.Dapeng_1_Order_JuanLian;
import com.daogukeji.dapeng.entity.Dapeng_1_Order_Led;

public class TestOrderDAO_Led {
	
	@Test
	public void testAddOrder_Voice(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		OrderDAO_Led dao = ctx.getBean("orderDAO_Led",OrderDAO_Led.class);
		Dapeng_1_Order_Led dp_1_o_jl = new Dapeng_1_Order_Led("1");
		dao.addOrder_Led(dp_1_o_jl);
	}
	@Test
	public void testFindOrder_Voice(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		OrderDAO_Led dao = ctx.getBean("orderDAO_Led",OrderDAO_Led.class);
		System.out.println(dao.findOrder_Led());
	}

}
