package com.daogukeji.dapeng.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daogukeji.dapeng.dao.OrderDAO_DiGuan;
import com.daogukeji.dapeng.entity.Dapeng_1_Order_DiGuan;
import com.daogukeji.dapeng.entity.Dapeng_1_Order_Led;

@Service("order_DiGuanService")
public class Order_DiGuanServiceImpl implements Order_DiGuanService{

	@Resource
	private OrderDAO_DiGuan orderDAO_DiGuan;

	public Dapeng_1_Order_DiGuan addOrder_DiGuan(String diguan) {
		Dapeng_1_Order_DiGuan dp_1_o_l = new Dapeng_1_Order_DiGuan(diguan);
		orderDAO_DiGuan.addOrder_DiGuan(dp_1_o_l);
		return dp_1_o_l;
		
	}

	public Dapeng_1_Order_DiGuan findOrder_DiGuan() {
		Dapeng_1_Order_DiGuan dp_1_o_l = orderDAO_DiGuan.findOrder_DiGuan();
		return dp_1_o_l;
	}
	
	

}
