package com.daogukeji.dapeng.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daogukeji.dapeng.service.OrderService;

public class TestOrderService {
	private OrderService service;
	@Before
	public void init(){
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		service = ctx.getBean("orderService",OrderService.class);
	}
	@Test
	public void testAddOrder(){
		service.addOrder("off");
	}
	@Test
	public void testFindOrder(){
		System.out.println(service.findOrder());
	}

}
