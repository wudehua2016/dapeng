package com.daogukeji.dapeng.entity;

import java.io.Serializable;

/*
 * 大棚传感器参数实体类
 */
public class Dapeng_1 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 630554234605409126L;
	
	//private String id;
	private String airTem;
	private String airHum;
	private String sun;
	private String soilTem;
	private String soilHum;
	public Dapeng_1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dapeng_1(String airTem, String airHum, String sun, String soilTem, String soilHum) {
		super();
		this.airTem = airTem;
		this.airHum = airHum;
		this.sun = sun;
		this.soilTem = soilTem;
		this.soilHum = soilHum;
	}
	public String getAirTem() {
		return airTem;
	}
	public void setAirTem(String airTem) {
		this.airTem = airTem;
	}
	public String getAirHum() {
		return airHum;
	}
	public void setAirHum(String airHum) {
		this.airHum = airHum;
	}
	public String getSun() {
		return sun;
	}
	public void setSun(String sun) {
		this.sun = sun;
	}
	public String getSoilTem() {
		return soilTem;
	}
	public void setSoilTem(String soilTem) {
		this.soilTem = soilTem;
	}
	public String getSoilHum() {
		return soilHum;
	}
	public void setSoilHum(String soilHum) {
		this.soilHum = soilHum;
	}
	@Override
	public String toString() {
		return "Dapeng_1 [airTem=" + airTem + ", airHum=" + airHum + ", sun=" + sun + ", soilTem=" + soilTem
				+ ", soilHum=" + soilHum + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airHum == null) ? 0 : airHum.hashCode());
		result = prime * result + ((airTem == null) ? 0 : airTem.hashCode());
		result = prime * result + ((soilHum == null) ? 0 : soilHum.hashCode());
		result = prime * result + ((soilTem == null) ? 0 : soilTem.hashCode());
		result = prime * result + ((sun == null) ? 0 : sun.hashCode());
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
		Dapeng_1 other = (Dapeng_1) obj;
		if (airHum == null) {
			if (other.airHum != null)
				return false;
		} else if (!airHum.equals(other.airHum))
			return false;
		if (airTem == null) {
			if (other.airTem != null)
				return false;
		} else if (!airTem.equals(other.airTem))
			return false;
		if (soilHum == null) {
			if (other.soilHum != null)
				return false;
		} else if (!soilHum.equals(other.soilHum))
			return false;
		if (soilTem == null) {
			if (other.soilTem != null)
				return false;
		} else if (!soilTem.equals(other.soilTem))
			return false;
		if (sun == null) {
			if (other.sun != null)
				return false;
		} else if (!sun.equals(other.sun))
			return false;
		return true;
	}
	
	
	

	
	

	

	
	
	
	
}
