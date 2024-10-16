package com.enp.blabber.api.dto;

import java.time.LocalDateTime;

import com.enp.blabber.api.model.User;

public class NotificationDto {
	
	private Long id;
	private User id_user;
	private String message;
	private boolean isRead;
	private LocalDateTime createdAt;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getId_user() {
		return id_user;
	}

	public void setId_user(User id_user) {
		this.id_user = id_user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "NotificationDto [id=" + id + ", id_user=" + id_user + ", message=" + message + ", isRead=" + isRead
				+ ", createdAt=" + createdAt + "]";
	}

}
