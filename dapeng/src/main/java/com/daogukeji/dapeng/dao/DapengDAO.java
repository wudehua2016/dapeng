package com.daogukeji.dapeng.dao;

import com.daogukeji.dapeng.entity.Dapeng_1;
/*
 * 大棚传感器持久层DAO
 */
public interface DapengDAO {
	void addInfo(Dapeng_1 dapeng_1);//增
	Dapeng_1 findAll();//查
}
