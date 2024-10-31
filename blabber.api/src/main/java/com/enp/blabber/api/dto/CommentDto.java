package com.enp.blabber.api.dto;

import java.time.LocalDateTime;

public class CommentDto {
	
	private Long id;
    private String content;
    private UserDto user;
    private BlabDto blab;
    private LocalDateTime commentedAt;
    
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

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public BlabDto getBlab() {
		return blab;
	}

	public void setBlab(BlabDto blab) {
		this.blab = blab;
	}

	public LocalDateTime getCommentedAt() {
		return commentedAt;
	}

	public void setCommentedAt(LocalDateTime commentedAt) {
		this.commentedAt = commentedAt;
	}

	@Override
	public String toString() {
		return "CommentDto [id=" + id + ", content=" + content + ", user=" + user + ", blab=" + blab + ", commentedAt="
				+ commentedAt + "]";
	}

}
