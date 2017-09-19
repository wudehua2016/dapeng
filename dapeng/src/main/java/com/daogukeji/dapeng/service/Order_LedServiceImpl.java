package com.daogukeji.dapeng.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daogukeji.dapeng.dao.OrderDAO_Led;
import com.daogukeji.dapeng.entity.Dapeng_1_Order_JuanLian;
import com.daogukeji.dapeng.entity.Dapeng_1_Order_Led;

@Service("order_LedService")
public class Order_LedServiceImpl implements Order_LedService{

	@Resource
	private OrderDAO_Led orderDAO_Led;

	public Dapeng_1_Order_Led addOrder_Led(String led) {
		Dapeng_1_Order_Led dp_1_o_l = new Dapeng_1_Order_Led(led);
		orderDAO_Led.addOrder_Led(dp_1_o_l);
		return dp_1_o_l;
		
	}

	public Dapeng_1_Order_Led findOrder_Led() {
		Dapeng_1_Order_Led dp_1_o_l = orderDAO_Led.findOrder_Led();
		return dp_1_o_l;
	}
	
	

}
