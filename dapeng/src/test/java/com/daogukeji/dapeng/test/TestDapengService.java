package com.daogukeji.dapeng.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daogukeji.dapeng.entity.Dapeng_1;
import com.daogukeji.dapeng.service.DapengService;

/*
 * 大棚传感器服务层接口测试
 */
public class TestDapengService {
	private DapengService service;
	@Before
	public void init(){
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		service = ctx.getBean("dapengService",DapengService.class);
	}
	
	@Test
	public void testSave(){
		Dapeng_1 da_1 = service.save("11","22","33","44","55");
		System.out.println(da_1);
	}
	@Test
	public void testFindAll(){
		Dapeng_1 da_1 = service.findAll();
		System.out.println(da_1);
	}
}





