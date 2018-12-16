package com.soft.app.model;

public class CustomResponse {

	private int id;
	private int status;
	private String message;
	public CustomResponse() {
		super();
	}
	public CustomResponse(int id, int status, String message) {
		super();
		this.id = id;
		this.status = status;
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "CustomResponse [id=" + id + ", status=" + status + ", message=" + message + "]";
	}
	
	
}
