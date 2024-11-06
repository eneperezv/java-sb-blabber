package com.enp.blabber.api.dto;

/*
 * @(#)Follow.java 1.0 05/11/2024
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

public class FollowDto {
	
	private Long id;
    private UserDto followerDto;  // Usuario que sigue a otro
    private UserDto followedDto;  // Usuario que es seguido
    private LocalDateTime followedAt;  // Fecha en la que comenzó a seguir
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDto getFollowerDto() {
		return followerDto;
	}

	public void setFollowerDto(UserDto followerDto) {
		this.followerDto = followerDto;
	}

	public UserDto getFollowedDto() {
		return followedDto;
	}

	public void setFollowedDto(UserDto followedDto) {
		this.followedDto = followedDto;
	}

	public LocalDateTime getFollowedAt() {
		return followedAt;
	}

	public void setFollowedAt(LocalDateTime followedAt) {
		this.followedAt = followedAt;
	}

	@Override
	public String toString() {
		return "FollowDto [id=" + id + ", followerDto=" + followerDto + ", followedDto=" + followedDto + ", followedAt="
				+ followedAt + "]";
	}

}
