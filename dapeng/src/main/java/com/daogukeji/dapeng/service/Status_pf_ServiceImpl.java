package com.daogukeji.dapeng.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daogukeji.dapeng.dao.Status_pf_DAO;
import com.daogukeji.dapeng.entity.Dapeng_1_Status_Paifeng;

@Service("status_pf_Service")
public class Status_pf_ServiceImpl implements Status_pf_Service{

	@Resource
	private Status_pf_DAO status_pf_DAO;
	public Dapeng_1_Status_Paifeng addStatus_pf(String state_pf) {
		Dapeng_1_Status_Paifeng dp_1_s_pf = new Dapeng_1_Status_Paifeng(state_pf);
		status_pf_DAO.addStatus_pf(dp_1_s_pf);
		return dp_1_s_pf;
	}

	public Dapeng_1_Status_Paifeng findStatus_pf() {
		Dapeng_1_Status_Paifeng dp_1_s_pf = status_pf_DAO.findStatus_pf();
		return dp_1_s_pf;
	}

}
