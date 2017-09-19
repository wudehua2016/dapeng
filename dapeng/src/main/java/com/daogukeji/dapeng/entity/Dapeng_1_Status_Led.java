package com.daogukeji.dapeng.entity;

import java.io.Serializable;

public class Dapeng_1_Status_Led implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4062144375275054166L;
	private String state_led;
	public Dapeng_1_Status_Led() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dapeng_1_Status_Led(String state_led) {
		super();
		this.state_led = state_led;
	}
	@Override
	public String toString() {
		return "Dapeng_1_Status_Led [state_led=" + state_led + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((state_led == null) ? 0 : state_led.hashCode());
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
		Dapeng_1_Status_Led other = (Dapeng_1_Status_Led) obj;
		if (state_led == null) {
			if (other.state_led != null)
				return false;
		} else if (!state_led.equals(other.state_led))
			return false;
		return true;
	}
	public String getState_led() {
		return state_led;
	}
	public void setState_led(String state_led) {
		this.state_led = state_led;
	}
	
}
