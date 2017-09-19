package com.daogukeji.dapeng.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daogukeji.dapeng.dao.Status_jl_DAO;
import com.daogukeji.dapeng.entity.Dapeng_1_Status_JuanLian;

@Service("status_jl_Service")
public class Status_jl_ServiceImpl implements Status_jl_Service{

	@Resource
	private Status_jl_DAO status_jl_DAO;
	public Dapeng_1_Status_JuanLian addStatus_jl(String state_juanlian) {
		Dapeng_1_Status_JuanLian dp_1_s_pf = new Dapeng_1_Status_JuanLian(state_juanlian);
		status_jl_DAO.addStatus_jl(dp_1_s_pf);
		return dp_1_s_pf;
	}

	public Dapeng_1_Status_JuanLian findStatus_jl() {
		Dapeng_1_Status_JuanLian dp_1_s_pf = status_jl_DAO.findStatus_jl();
		return dp_1_s_pf;
	}

}
