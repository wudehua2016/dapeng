package com.daogukeji.dapeng.entity;

import java.io.Serializable;

public class Dapeng_1_Order_JuanLian implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5236587233816525021L;
	private String juanlian;
	
	
	public Dapeng_1_Order_JuanLian() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dapeng_1_Order_JuanLian(String juanlian) {
		super();
		this.juanlian = juanlian;
	}
	public String getJuanlian() {
		return juanlian;
	}
	public void setJuanlian(String juanlian) {
		this.juanlian = juanlian;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((juanlian == null) ? 0 : juanlian.hashCode());
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
		Dapeng_1_Order_JuanLian other = (Dapeng_1_Order_JuanLian) obj;
		if (juanlian == null) {
			if (other.juanlian != null)
				return false;
		} else if (!juanlian.equals(other.juanlian))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Dapeng_1_Order_JuanLian [juanlian=" + juanlian + "]";
	}
	
	
}
