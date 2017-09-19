package com.daogukeji.dapeng.entity;

import java.io.Serializable;

public class Dapeng_1_Order_Led implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8958951531380355509L;
	private String led;
	public Dapeng_1_Order_Led() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dapeng_1_Order_Led(String led) {
		super();
		this.led = led;
	}
	public String getLed() {
		return led;
	}
	public void setLed(String led) {
		this.led = led;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((led == null) ? 0 : led.hashCode());
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
		Dapeng_1_Order_Led other = (Dapeng_1_Order_Led) obj;
		if (led == null) {
			if (other.led != null)
				return false;
		} else if (!led.equals(other.led))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Dapeng_1_Order_Led [led=" + led + "]";
	}
	
	
}
