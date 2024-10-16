package com.enp.blabber.api.dto;

/*
 * @(#)FollowDto.java 1.0 15/09/2024
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

import com.enp.blabber.api.model.User;

public class FollowDto {
	
	private Long id;
	private User follower;
	private User follows;
	private LocalDateTime followedAt;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getFollower() {
		return follower;
	}

	public void setFollower(User follower) {
		this.follower = follower;
	}

	public User getFollows() {
		return follows;
	}

	public void setFollows(User follows) {
		this.follows = follows;
	}

	public LocalDateTime getFollowedAt() {
		return followedAt;
	}

	public void setFollowedAt(LocalDateTime followedAt) {
		this.followedAt = followedAt;
	}

	@Override
	public String toString() {
		return "FollowDto [id=" + id + ", follower=" + follower + ", follows=" + follows + ", followedAt=" + followedAt
				+ "]";
	}

}
