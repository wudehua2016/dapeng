package com.daogukeji.dapeng.service;

import com.daogukeji.dapeng.entity.Dapeng_1;

public interface DapengService {
	/*
	 * 大棚传感器服务层接口
	 */
	//存储传感器数据
	Dapeng_1 save(String airTem,String airHum,String sun,String soilTem,String soilHum);
	//根据id查询传感器数据
	Dapeng_1 findAll();
}
