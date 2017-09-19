package com.daogukeji.dapeng.dao;

import com.daogukeji.dapeng.entity.Dapeng_1_Order_Paifeng;

public interface OrderDAO {

	void addOrder(Dapeng_1_Order_Paifeng addOrder);
	Dapeng_1_Order_Paifeng findOrder();
}
