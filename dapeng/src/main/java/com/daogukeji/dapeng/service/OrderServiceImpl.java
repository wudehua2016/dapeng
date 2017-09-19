package com.daogukeji.dapeng.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daogukeji.dapeng.dao.OrderDAO;
import com.daogukeji.dapeng.entity.Dapeng_1_Order_Paifeng;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	@Resource
	private OrderDAO orderDAO;

	public Dapeng_1_Order_Paifeng addOrder(String zhiling) {
		Dapeng_1_Order_Paifeng dp_1_o_pf = new Dapeng_1_Order_Paifeng(zhiling);
		orderDAO.addOrder(dp_1_o_pf);
		System.out.println("��������ִ�п�������");
		return dp_1_o_pf;
	}

	public Dapeng_1_Order_Paifeng findOrder() {
		Dapeng_1_Order_Paifeng dp_1_o_pf = orderDAO.findOrder();
		System.out.println("��������ִ�в�ѯ��������");
		return dp_1_o_pf;
	}

}
