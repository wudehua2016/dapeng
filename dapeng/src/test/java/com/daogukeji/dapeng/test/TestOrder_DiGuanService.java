package com.daogukeji.dapeng.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daogukeji.dapeng.service.Order_DiGuanService;

public class TestOrder_DiGuanService {
	private Order_DiGuanService service;
	@Before
	public void init(){
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		service = ctx.getBean("order_DiGuanService",Order_DiGuanService.class);
	}
	@Test
	public void testAddOrder(){
		service.addOrder_DiGuan("2");
	}
	@Test
	public void testFindOrder(){
		System.out.println(service.findOrder_DiGuan());
	}

}
