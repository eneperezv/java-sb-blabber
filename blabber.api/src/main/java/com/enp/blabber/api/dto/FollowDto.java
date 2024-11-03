package com.enp.blabber.api.dto;

import java.time.LocalDateTime;

import com.enp.blabber.api.model.User;

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
