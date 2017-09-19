package com.daogukeji.dapeng.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daogukeji.dapeng.dao.DapengDAO;
import com.daogukeji.dapeng.entity.Dapeng_1;

/*
 * 大棚传感器服务层接口的实现类
 */
@Service("dapengService")//服务层注解
public class DapengServiceImpl implements DapengService{
	@Resource//依赖注入注解，将DapengDAO持久层DAO注入进来
	private DapengDAO dapengDAO;
	
	public Dapeng_1 save(String airTem,String airHum,String sun,String soilTem,String soilHum) {
		
		Dapeng_1 da_1 = new Dapeng_1(airTem,airHum,sun,soilTem,soilHum);
		dapengDAO.addInfo(da_1);
		System.out.println("大棚服务层执行添加任务");
		return da_1;
	}

	public Dapeng_1 findAll() {
		Dapeng_1 da_1 = dapengDAO.findAll();
		System.out.println("大棚服务层执行查询任务");
		return da_1;
	}

	

}
