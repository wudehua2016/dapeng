package com.daogukeji.dapeng.entity;

import java.io.Serializable;

public class Dapeng_1_Order_Paifeng implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4318384277111964581L;
	private String zhiling;
	
	public Dapeng_1_Order_Paifeng() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dapeng_1_Order_Paifeng(String zhiling) {
		super();
		this.zhiling = zhiling;
	}

	public String getZhiling() {
		return zhiling;
	}

	public void setZhiling(String zhiling) {
		this.zhiling = zhiling;
	}

	@Override
	public String toString() {
		return "Dapeng_1_Order_Paifeng [zhiling=" + zhiling + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((zhiling == null) ? 0 : zhiling.hashCode());
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
		Dapeng_1_Order_Paifeng other = (Dapeng_1_Order_Paifeng) obj;
		if (zhiling == null) {
			if (other.zhiling != null)
				return false;
		} else if (!zhiling.equals(other.zhiling))
			return false;
		return true;
	}
	
	
}
