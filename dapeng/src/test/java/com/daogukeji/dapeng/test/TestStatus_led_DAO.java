package com.daogukeji.dapeng.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daogukeji.dapeng.dao.Status_led_DAO;
import com.daogukeji.dapeng.dao.Status_pf_DAO;
import com.daogukeji.dapeng.entity.Dapeng_1_Status_Led;

public class TestStatus_led_DAO {
	@Test
	public void testAddStatus_pf(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		Status_led_DAO dao = ctx.getBean("status_led_DAO",Status_led_DAO.class);
		Dapeng_1_Status_Led dp_1_s_pf = new Dapeng_1_Status_Led("排风已开启(50CM)...");
		System.out.println(dp_1_s_pf);
		dao.addStatus_led(dp_1_s_pf);
	}
	@Test
	public void testFindStatus_pf(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		Status_led_DAO dao = ctx.getBean("status_led_DAO",Status_led_DAO.class);
		System.out.println(dao.findStatus_led());
	}

}
