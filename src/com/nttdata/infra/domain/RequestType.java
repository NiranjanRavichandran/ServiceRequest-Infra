package com.nttdata.infra.domain;

public class RequestType {
	private int id;
	private String desc;

	public RequestType(int id, String desc) {
		super();
		this.id = id;
		this.desc = desc;
	}

	public RequestType() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return id + " - " + desc;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		boolean isSame = false;
		RequestType details = (RequestType) obj;
		if (this.id == details.id) {
			isSame = true;
		}
		return isSame;
	}

}
