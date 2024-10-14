package com.enp.blabber.api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dbo_notifications")
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_notification", unique=true, nullable=false)
	private Long id;
	
	@Column(name = "id_user", nullable = false)
	private User id_user;
	
	@Column(nullable = false, length = 500)
	private String message;
	
	@Column(nullable = false)
	private boolean isRead;
	
	@Column(nullable = false)
	private LocalDateTime createdAt;
	
	public Notification() {
		
	}

	public Notification(User user, String message, boolean isRead, LocalDateTime createdAt) {
		super();
		this.id_user = user;
		this.message = message;
		this.isRead = isRead;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return id_user;
	}

	public void setUser(User user) {
		this.id_user = user;
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
		return "Notification [id=" + id + ", user=" + id_user + ", message=" + message + ", isRead=" + isRead
				+ ", createdAt=" + createdAt + "]";
	}

}
