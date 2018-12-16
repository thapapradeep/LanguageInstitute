package com.soft.app.model;

public class MessageInfo {

	private int id;
	private String name;
	private String email;
	private String message;

	public MessageInfo() {

	}

	public MessageInfo(int id, String email, String message) {
		super();
		this.id = id;
		this.email = email;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MessageInfo [id=" + id + ", email=" + email + ", message=" + message + "]";
	}

}
