package com.enp.blabber.api.dto;

import java.time.LocalDateTime;

public class BlabDto {
	
	private Long id;
    private String content;
    private String username;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "BlabDto [id=" + id + ", content=" + content + ", username=" + username + ", createdAt=" + createdAt
				+ "]";
	}

}
