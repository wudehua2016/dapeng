package com.daogukeji.dapeng.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daogukeji.dapeng.dao.OrderDAO;
import com.daogukeji.dapeng.entity.Dapeng_1_Order_Paifeng;

public class TestOrderDAO {
	
	@Test
	public void testAddOrder(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		OrderDAO dao = ctx.getBean("orderDAO",OrderDAO.class);
		Dapeng_1_Order_Paifeng dp_1_o_pf = new Dapeng_1_Order_Paifeng("off");
		dao.addOrder(dp_1_o_pf);
	}
	@Test
	public void testFindOrder(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		OrderDAO dao = ctx.getBean("orderDAO",OrderDAO.class);
		System.out.println(dao.findOrder());
	}

}
