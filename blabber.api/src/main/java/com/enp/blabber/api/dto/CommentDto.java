package com.enp.blabber.api.dto;

/*
 * @(#)CommentDto.java 1.0 31/10/2024
 * 
 * El código implementado en este formulario esta protegido
 * bajo las leyes internacionales del Derecho de Autor, sin embargo
 * se entrega bajo las condiciones de la General Public License (GNU GPLv3)
 * descrita en https://www.gnu.org/licenses/gpl-3.0.html
 */

/**
 * @author eliezer.navarro
 * @version 1.0
 * @since 1.0
 */

import java.time.LocalDateTime;

public class CommentDto {
	
	private Long id;
    private String content;
    private UserDto userDto;
    private BlabDto blabDto;
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

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public BlabDto getBlabDto() {
		return blabDto;
	}

	public void setBlabDto(BlabDto blabDto) {
		this.blabDto = blabDto;
	}

	public LocalDateTime getCommentedAt() {
		return commentedAt;
	}

	public void setCommentedAt(LocalDateTime commentedAt) {
		this.commentedAt = commentedAt;
	}

	@Override
	public String toString() {
		return "CommentDto [id=" + id + ", content=" + content + ", userDto=" + userDto + ", blabDto=" + blabDto
				+ ", commentedAt=" + commentedAt + "]";
	}

}
