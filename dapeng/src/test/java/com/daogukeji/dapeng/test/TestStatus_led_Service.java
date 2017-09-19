package com.daogukeji.dapeng.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daogukeji.dapeng.service.Status_led_Service;

public class TestStatus_led_Service {
	private Status_led_Service service;
	
	@Before
	public void init(){
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		service = ctx.getBean("status_led_Service",Status_led_Service.class);
	}
	@Test
	public void testAddStatus_led(){
		service.addStatus_led("排风正在关闭(50CM)请稍后...");
	}
	@Test
	public void testFindStatus_led(){
		System.out.println(service.findStatus_led());
	}

}
