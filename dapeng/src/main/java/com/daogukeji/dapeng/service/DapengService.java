package com.daogukeji.dapeng.service;

import com.daogukeji.dapeng.entity.Dapeng_1;

public interface DapengService {
	/*
	 * ���ﴫ���������ӿ�
	 */
	//�洢����������
	Dapeng_1 save(String airTem,String airHum,String sun,String soilTem,String soilHum);
	//����id��ѯ����������
	Dapeng_1 findAll();
}
