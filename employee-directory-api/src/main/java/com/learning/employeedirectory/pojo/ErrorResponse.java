package com.learning.employeedirectory.pojo;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Error Response")
public class ErrorResponse {
	@Schema(description ="status code", example="400")
	private int status;
	@Schema(description ="Error message", example="Bad Request")
	private String message;
	@Schema(description ="timestamp", example="20240905")
	private long timestamp;
	
	
	public ErrorResponse() {
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
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
