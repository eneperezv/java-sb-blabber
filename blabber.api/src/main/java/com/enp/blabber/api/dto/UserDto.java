package com.enp.blabber.api.dto;

/*
 * @(#)UserDto.java 1.0 29/10/2024
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

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Transient;

public class UserDto {
	
	private Long id;
    private String username;
    private String password;
    private String role;
    private String name;
    private String email;
    private List<BlabDto> blabsDto = new ArrayList<>();
    private List<FollowDto> followingDto = new ArrayList<>();
    private List<FollowDto> followersDto = new ArrayList<>();
    private List<NotificationDto> notificationsDto = new ArrayList<>();
    private List<DirectMessageDto> sentMessagesDto = new ArrayList<>();
    private List<DirectMessageDto> receivedMessagesDto = new ArrayList<>();
    private Integer blabsCount;
    private Integer followersCount;
    private Integer followingCount;
    private Integer notificationCount;
    private Integer dmReceivedCount;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<BlabDto> getBlabsDto() {
		return blabsDto;
	}

	public void setBlabsDto(List<BlabDto> blabsDto) {
		this.blabsDto = blabsDto;
	}

	public List<FollowDto> getFollowingDto() {
		return followingDto;
	}

	public void setFollowingDto(List<FollowDto> followingDto) {
		this.followingDto = followingDto;
	}

	public List<FollowDto> getFollowersDto() {
		return followersDto;
	}

	public void setFollowersDto(List<FollowDto> followersDto) {
		this.followersDto = followersDto;
	}

	public List<NotificationDto> getNotificationsDto() {
		return notificationsDto;
	}

	public void setNotificationsDto(List<NotificationDto> notificationsDto) {
		this.notificationsDto = notificationsDto;
	}

	public List<DirectMessageDto> getSentMessagesDto() {
		return sentMessagesDto;
	}

	public void setSentMessagesDto(List<DirectMessageDto> sentMessagesDto) {
		this.sentMessagesDto = sentMessagesDto;
	}

	public List<DirectMessageDto> getReceivedMessagesDto() {
		return receivedMessagesDto;
	}

	public void setReceivedMessagesDto(List<DirectMessageDto> receivedMessagesDto) {
		this.receivedMessagesDto = receivedMessagesDto;
	}

	public Integer getBlabsCount() {
		return blabsCount;
	}

	public void setBlabsCount(Integer blabsCount) {
		this.blabsCount = blabsCount;
	}

	public Integer getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(Integer followersCount) {
		this.followersCount = followersCount;
	}

	public Integer getFollowingCount() {
		return followingCount;
	}

	public void setFollowingCount(Integer followingCount) {
		this.followingCount = followingCount;
	}

	public Integer getNotificationCount() {
		return notificationCount;
	}

	public void setNotificationCount(Integer notificationCount) {
		this.notificationCount = notificationCount;
	}

	public Integer getDmReceivedCount() {
		return dmReceivedCount;
	}

	public void setDmReceivedCount(Integer dmReceivedCount) {
		this.dmReceivedCount = dmReceivedCount;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", name="
				+ name + ", email=" + email + ", blabsDto=" + blabsDto + ", followingDto=" + followingDto
				+ ", followersDto=" + followersDto + ", notificationsDto=" + notificationsDto + ", sentMessagesDto="
				+ sentMessagesDto + ", receivedMessagesDto=" + receivedMessagesDto + ", blabsCount=" + blabsCount
				+ ", followersCount=" + followersCount + ", followingCount=" + followingCount + ", notificationCount="
				+ notificationCount + ", dmReceivedCount=" + dmReceivedCount + "]";
	}

}
