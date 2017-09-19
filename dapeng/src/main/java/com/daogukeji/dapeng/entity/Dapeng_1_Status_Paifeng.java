package com.daogukeji.dapeng.entity;

import java.io.Serializable;

public class Dapeng_1_Status_Paifeng implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3652007718710486139L;
	private String state;
	public Dapeng_1_Status_Paifeng() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dapeng_1_Status_Paifeng(String state) {
		super();
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Dapeng_1_Status_Paifeng [state=" + state + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		Dapeng_1_Status_Paifeng other = (Dapeng_1_Status_Paifeng) obj;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
	
	

}
