package com.enp.blabber.api.dto;

/*
 * @(#)LikeDto.java 1.0 31/10/2024
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

public class LikeDto {
	
	private Long id;
    private UserDto userDto;
    private BlabDto blabDto;
    private LocalDateTime likedAt;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDateTime getLikedAt() {
		return likedAt;
	}

	public void setLikedAt(LocalDateTime likedAt) {
		this.likedAt = likedAt;
	}

	@Override
	public String toString() {
		return "LikeDto [id=" + id + ", userDto=" + userDto + ", blabDto=" + blabDto + ", likedAt=" + likedAt + "]";
	}

}
