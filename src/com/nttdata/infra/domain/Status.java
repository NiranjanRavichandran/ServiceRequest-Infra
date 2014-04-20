package com.nttdata.infra.domain;

public class Status {
	private int statusId;
	private String statusDesc;
	Role role;

	public Status(int statusId, String statusDesc) {
		super();
		this.statusId = statusId;
		this.statusDesc = statusDesc;
	}

	public Status() {
		// TODO Auto-generated constructor stub
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return statusId + " - " + statusDesc;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return statusId;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		boolean isSame = false;
		Status sts = (Status) obj;
		if (this.statusId == sts.statusId) {
			isSame = true;
		}
		return isSame;
	}
}
