package com.daogukeji.dapeng.entity;

import java.io.Serializable;

public class Dapeng_1_Status_JuanLian implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7632883787979075346L;
	private String state_juanlian;
	public Dapeng_1_Status_JuanLian() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dapeng_1_Status_JuanLian(String state_juanlian) {
		super();
		this.state_juanlian = state_juanlian;
	}
	@Override
	public String toString() {
		return "Dapeng_1_Status_JuanLian [state_juanlian=" + state_juanlian + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((state_juanlian == null) ? 0 : state_juanlian.hashCode());
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
		Dapeng_1_Status_JuanLian other = (Dapeng_1_Status_JuanLian) obj;
		if (state_juanlian == null) {
			if (other.state_juanlian != null)
				return false;
		} else if (!state_juanlian.equals(other.state_juanlian))
			return false;
		return true;
	}
	public String getState_juanlian() {
		return state_juanlian;
	}
	public void setState_juanlian(String state_juanlian) {
		this.state_juanlian = state_juanlian;
	}
	
	
}
