package com.daogukeji.dapeng.entity;

import java.io.Serializable;

public class Dapeng_1_Status_DiGuan implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7570436822783198675L;
	private String state_diguan;
	public Dapeng_1_Status_DiGuan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dapeng_1_Status_DiGuan(String state_diguan) {
		super();
		this.state_diguan = state_diguan;
	}
	@Override
	public String toString() {
		return "Dapeng_1_Status_DiGuan [state_diguan=" + state_diguan + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((state_diguan == null) ? 0 : state_diguan.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dapeng_1_Status_DiGuan other = (Dapeng_1_Status_DiGuan) obj;
		if (state_diguan == null) {
			if (other.state_diguan != null)
				return false;
		} else if (!state_diguan.equals(other.state_diguan))
			return false;
		return true;
	}
	public String getState_diguan() {
		return state_diguan;
	}
	public void setState_diguan(String state_diguan) {
		this.state_diguan = state_diguan;
	}
	
}
