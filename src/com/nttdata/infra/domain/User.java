package com.nttdata.infra.domain;

public class User {
	private int id;
	private String passwd;
	private String name;
	private int rollId;

	public User(int id, String passwd, String name, int rollId) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.rollId = rollId;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollId() {
		return rollId;
	}

	public void setRollId(int rollId) {
		this.rollId = rollId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", passwd=" + passwd + ", name=" + name
				+ ", rollId=" + rollId + "]";
	}

}
