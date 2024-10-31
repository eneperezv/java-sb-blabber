package com.enp.blabber.api.dto;

/*
 * @(#)BlabDto.java 1.0 29/10/2024
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

public class BlabDto {
	
	private Long id;
    private String content;
    private UserDto userDto;
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

	public UserDto getUser() {
		return userDto;
	}

	public void setUser(UserDto user) {
		this.userDto = user;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "BlabDto [id=" + id + ", content=" + content + ", user=" + userDto + ", createdAt=" + createdAt
				+ "]";
	}

}
