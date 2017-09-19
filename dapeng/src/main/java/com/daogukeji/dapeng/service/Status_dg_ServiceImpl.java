package com.daogukeji.dapeng.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daogukeji.dapeng.dao.Status_dg_DAO;
import com.daogukeji.dapeng.entity.Dapeng_1_Status_DiGuan;

@Service("status_dg_Service")
public class Status_dg_ServiceImpl implements Status_dg_Service{

	@Resource
	private Status_dg_DAO status_dg_DAO;
	public Dapeng_1_Status_DiGuan addStatus_dg(String state_diguan) {
		Dapeng_1_Status_DiGuan dp_1_s_pf = new Dapeng_1_Status_DiGuan(state_diguan);
		status_dg_DAO.addStatus_dg(dp_1_s_pf);
		return dp_1_s_pf;
	}

	public Dapeng_1_Status_DiGuan findStatus_dg() {
		Dapeng_1_Status_DiGuan dp_1_s_pf = status_dg_DAO.findStatus_dg();
		return dp_1_s_pf;
	}

}
