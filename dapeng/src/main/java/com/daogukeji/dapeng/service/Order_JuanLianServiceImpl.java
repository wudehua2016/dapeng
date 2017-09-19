package com.daogukeji.dapeng.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daogukeji.dapeng.dao.OrderDAO_JuanLian;
import com.daogukeji.dapeng.dao.OrderDAO_Voice;
import com.daogukeji.dapeng.entity.Dapeng_1_Order_JuanLian;
import com.daogukeji.dapeng.entity.Dapeng_1_Order_Voice;

@Service("order_JuanLianService")
public class Order_JuanLianServiceImpl implements Order_JuanLianService{

	@Resource
	private OrderDAO_JuanLian orderDAO_JuanLian;

	public Dapeng_1_Order_JuanLian addOrder_JuanLian(String juanlian) {
		Dapeng_1_Order_JuanLian dp_1_o_jl = new Dapeng_1_Order_JuanLian(juanlian);
		orderDAO_JuanLian.addOrder_JuanLian(dp_1_o_jl);
		return dp_1_o_jl;
		
	}

	public Dapeng_1_Order_JuanLian findOrder_JuanLian() {
		Dapeng_1_Order_JuanLian dp_1_o_jl = orderDAO_JuanLian.findOrder_JuanLian();
		return dp_1_o_jl;
	}
	
	

}
