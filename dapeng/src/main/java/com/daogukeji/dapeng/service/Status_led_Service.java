package com.daogukeji.dapeng.service;

import com.daogukeji.dapeng.entity.Dapeng_1_Status_Led;

public interface Status_led_Service {

	Dapeng_1_Status_Led addStatus_led(String state_led);
	Dapeng_1_Status_Led findStatus_led();
}
