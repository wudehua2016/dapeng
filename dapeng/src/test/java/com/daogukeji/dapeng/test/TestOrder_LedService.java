package com.daogukeji.dapeng.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daogukeji.dapeng.service.Order_JuanLianService;
import com.daogukeji.dapeng.service.Order_LedService;

public class TestOrder_LedService {
	private Order_LedService service;
	@Before
	public void init(){
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		service = ctx.getBean("order_LedService",Order_LedService.class);
	}
	@Test
	public void testAddOrder(){
		service.addOrder_Led("2");
	}
	@Test
	public void testFindOrder(){
		System.out.println(service.findOrder_Led());
	}

}
