package com.ticket.enums;

public enum Status {

	OPEN(1, "Open"), PENDING(2, "Pending"), WIP(3, "In Progress"), RESOLVED(4, "Resolved"), CLOSED(5, "Closed");

	private Integer id;
	private String name;

	private Status(Integer id, String name) {
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
