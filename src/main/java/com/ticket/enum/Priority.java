package com.ticket.enums;

public enum Priority {

	HIGH(1, "High"), MEDIUM(2, "Medium"), LOW(3, "Low");

	private Integer id;
	private String name;

	private Priority(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
