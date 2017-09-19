package com.daogukeji.dapeng.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daogukeji.dapeng.dao.OrderDAO_Voice;
import com.daogukeji.dapeng.entity.Dapeng_1_Order_Voice;

@Service("order_VoiceService")
public class Order_VoiceServiceImpl implements Order_VoiceService{

	@Resource
	private OrderDAO_Voice orderDAO_Voice;
	
	public Dapeng_1_Order_Voice addOrder_Voice(String voice) {
		Dapeng_1_Order_Voice dp_1_o_v = new Dapeng_1_Order_Voice(voice);
		orderDAO_Voice.addOrder_Voice(dp_1_o_v);
		return dp_1_o_v;
	}

	public Dapeng_1_Order_Voice findOrder_Voice() {
		Dapeng_1_Order_Voice dp_1_o_v = orderDAO_Voice.findOrder_Voice();
		return dp_1_o_v;
	}

}
