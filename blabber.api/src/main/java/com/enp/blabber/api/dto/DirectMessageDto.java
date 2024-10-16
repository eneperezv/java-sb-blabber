package com.enp.blabber.api.dto;

import java.time.LocalDateTime;

import com.enp.blabber.api.model.User;

public class DirectMessageDto {
	
	private Long id;
	private User sender;
	private User receiver;
	private String message;
	private boolean isRead;
	private LocalDateTime sentAt;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
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

	public LocalDateTime getSentAt() {
		return sentAt;
	}

	public void setSentAt(LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}

	@Override
	public String toString() {
		return "DirectMessageDto [id=" + id + ", sender=" + sender + ", receiver=" + receiver + ", message=" + message
				+ ", isRead=" + isRead + ", sentAt=" + sentAt + "]";
	}

}
