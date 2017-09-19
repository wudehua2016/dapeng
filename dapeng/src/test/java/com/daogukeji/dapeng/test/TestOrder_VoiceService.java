package com.daogukeji.dapeng.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daogukeji.dapeng.service.OrderService;
import com.daogukeji.dapeng.service.Order_VoiceService;

public class TestOrder_VoiceService {
	private Order_VoiceService service;
	@Before
	public void init(){
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		service = ctx.getBean("order_VoiceService",Order_VoiceService.class);
	}
	@Test
	public void testAddOrder(){
		service.addOrder_Voice("2");
	}
	@Test
	public void testFindOrder(){
		System.out.println(service.findOrder_Voice());
	}

}
