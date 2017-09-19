package com.daogukeji.dapeng.entity;

import java.io.Serializable;

public class Dapeng_1_Order_Voice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8762240136814425989L;
	
	String voice;

	public String getVoice() {
		return voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	public Dapeng_1_Order_Voice(String voice) {
		super();
		this.voice = voice;
	}

	public Dapeng_1_Order_Voice() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Dapeng_1_Order_Voice [voice=" + voice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((voice == null) ? 0 : voice.hashCode());
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
		Dapeng_1_Order_Voice other = (Dapeng_1_Order_Voice) obj;
		if (voice == null) {
			if (other.voice != null)
				return false;
		} else if (!voice.equals(other.voice))
			return false;
		return true;
	}
	
	
}
