package com.daogukeji.dapeng.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daogukeji.dapeng.dao.DapengDAO;
import com.daogukeji.dapeng.entity.Dapeng_1;

public class TestDapengDAO {
	
	@Test
	public void testAddInfo(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		DapengDAO dao = ctx.getBean("dapengDAO",DapengDAO.class);
		Dapeng_1 dp_1 = new Dapeng_1("1","2","3","4","5");
		dao.addInfo(dp_1);
	}
	
	@Test
	public void testFindAll(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		DapengDAO dao = ctx.getBean("dapengDAO",DapengDAO.class);
		Dapeng_1 dp_1 = new Dapeng_1();
		dp_1 = dao.findAll();
		System.out.println(dp_1);
	}
	

}
