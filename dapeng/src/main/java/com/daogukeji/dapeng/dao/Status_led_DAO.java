package com.daogukeji.dapeng.dao;

import com.daogukeji.dapeng.entity.Dapeng_1_Status_Led;

public interface Status_led_DAO {

	void addStatus_led(Dapeng_1_Status_Led state_led);
	Dapeng_1_Status_Led findStatus_led();
}
