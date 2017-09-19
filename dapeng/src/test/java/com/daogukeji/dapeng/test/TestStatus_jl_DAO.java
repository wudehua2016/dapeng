package com.daogukeji.dapeng.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daogukeji.dapeng.dao.Status_jl_DAO;
import com.daogukeji.dapeng.entity.Dapeng_1_Status_JuanLian;

public class TestStatus_jl_DAO {
	@Test
	public void testAddStatus_pf(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		Status_jl_DAO dao = ctx.getBean("status_jl_DAO",Status_jl_DAO.class);
		Dapeng_1_Status_JuanLian dp_1_s_pf = new Dapeng_1_Status_JuanLian("排风已开启(50CM)...");
		System.out.println(dp_1_s_pf);
		dao.addStatus_jl(dp_1_s_pf);
	}
	@Test
	public void testFindStatus_pf(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		Status_jl_DAO dao = ctx.getBean("status_jl_DAO",Status_jl_DAO.class);
		System.out.println(dao.findStatus_jl());
	}

}
