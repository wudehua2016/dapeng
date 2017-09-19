package com.daogukeji.dapeng.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daogukeji.dapeng.service.Status_pf_Service;

public class TestStatus_pf_Service {
	private Status_pf_Service service;
	
	@Before
	public void init(){
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		service = ctx.getBean("status_pf_Service",Status_pf_Service.class);
	}
	@Test
	public void testAddStatus_pf(){
		service.addStatus_pf("排风正在关闭(50CM)请稍后...");
	}
	@Test
	public void testFindStatus_pf(){
		System.out.println(service.findStatus_pf());
	}

}
