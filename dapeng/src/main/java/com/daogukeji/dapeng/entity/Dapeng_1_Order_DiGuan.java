package com.daogukeji.dapeng.entity;

import java.io.Serializable;

public class Dapeng_1_Order_DiGuan implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -492907542176963870L;
	private String diguan;
	public Dapeng_1_Order_DiGuan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dapeng_1_Order_DiGuan(String diguan) {
		super();
		this.diguan = diguan;
	}
	@Override
	public String toString() {
		return "Dapeng_1_Order_DiGuan [diguan=" + diguan + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diguan == null) ? 0 : diguan.hashCode());
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
		Dapeng_1_Order_DiGuan other = (Dapeng_1_Order_DiGuan) obj;
		if (diguan == null) {
			if (other.diguan != null)
				return false;
		} else if (!diguan.equals(other.diguan))
			return false;
		return true;
	}
	public String getDiguan() {
		return diguan;
	}
	public void setDiguan(String diguan) {
		this.diguan = diguan;
	}
	
	
}
