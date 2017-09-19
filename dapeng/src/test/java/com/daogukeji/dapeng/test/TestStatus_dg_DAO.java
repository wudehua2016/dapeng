package com.daogukeji.dapeng.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daogukeji.dapeng.dao.Status_dg_DAO;
import com.daogukeji.dapeng.entity.Dapeng_1_Status_DiGuan;

public class TestStatus_dg_DAO {
	@Test
	public void testAddStatus_pf(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		Status_dg_DAO dao = ctx.getBean("status_dg_DAO",Status_dg_DAO.class);
		Dapeng_1_Status_DiGuan dp_1_s_pf = new Dapeng_1_Status_DiGuan("排风已开启(50CM)...");
		System.out.println(dp_1_s_pf);
		dao.addStatus_dg(dp_1_s_pf);
	}
	@Test
	public void testFindStatus_pf(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		Status_dg_DAO dao = ctx.getBean("status_dg_DAO",Status_dg_DAO.class);
		System.out.println(dao.findStatus_dg());
	}

}
