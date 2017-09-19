package com.daogukeji.dapeng.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daogukeji.dapeng.dao.Status_led_DAO;
import com.daogukeji.dapeng.entity.Dapeng_1_Status_Led;

@Service("status_led_Service")
public class Status_led_ServiceImpl implements Status_led_Service{

	@Resource
	private Status_led_DAO status_led_DAO;
	public Dapeng_1_Status_Led addStatus_led(String state_led) {
		Dapeng_1_Status_Led dp_1_s_pf = new Dapeng_1_Status_Led(state_led);
		status_led_DAO.addStatus_led(dp_1_s_pf);
		return dp_1_s_pf;
	}

	public Dapeng_1_Status_Led findStatus_led() {
		Dapeng_1_Status_Led dp_1_s_pf = status_led_DAO.findStatus_led();
		return dp_1_s_pf;
	}

}
