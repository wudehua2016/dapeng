package com.daogukeji.dapeng.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daogukeji.dapeng.dao.DapengDAO;
import com.daogukeji.dapeng.entity.Dapeng_1;

/*
 * ���ﴫ���������ӿڵ�ʵ����
 */
@Service("dapengService")//�����ע��
public class DapengServiceImpl implements DapengService{
	@Resource//����ע��ע�⣬��DapengDAO�־ò�DAOע�����
	private DapengDAO dapengDAO;
	
	public Dapeng_1 save(String airTem,String airHum,String sun,String soilTem,String soilHum) {
		
		Dapeng_1 da_1 = new Dapeng_1(airTem,airHum,sun,soilTem,soilHum);
		dapengDAO.addInfo(da_1);
		System.out.println("��������ִ���������");
		return da_1;
	}

	public Dapeng_1 findAll() {
		Dapeng_1 da_1 = dapengDAO.findAll();
		System.out.println("��������ִ�в�ѯ����");
		return da_1;
	}

	

}
