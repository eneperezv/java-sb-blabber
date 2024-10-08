package com.enp.blabber.api.model;

import java.util.Date;

import org.springframework.http.ResponseEntity;

public class ResponseDetails<T> {
	
	private String status;
	private Date timestamp;
	private String code;
	private String message;
	private ResponseEntity<T> response;
	
	public ResponseDetails(String status, Date timestamp, String code, String message, ResponseEntity<T> response) {
		super();
		this.status = status;
		this.timestamp = timestamp;
		this.code = code;
		this.message = message;
		this.response = response;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseEntity<T> getResponse() {
		return response;
	}

	public void setResponse(ResponseEntity<T> response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "ResponseDetails [status=" + status + ", timestamp=" + timestamp + ", code=" + code + ", message="
				+ message + ", response=" + response + "]";
	}

}
