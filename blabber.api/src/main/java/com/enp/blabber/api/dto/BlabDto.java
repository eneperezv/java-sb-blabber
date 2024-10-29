package com.enp.blabber.api.dto;

import java.time.LocalDateTime;

import com.enp.blabber.api.model.User;

public class BlabDto {
	
	private Long id;
    private String content;
    private User user;
    private LocalDateTime createdAt;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "BlabDto [id=" + id + ", content=" + content + ", user=" + user + ", createdAt=" + createdAt
				+ "]";
	}

}
