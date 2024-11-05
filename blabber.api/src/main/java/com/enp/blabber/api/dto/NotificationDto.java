package com.enp.blabber.api.dto;

/*
 * @(#)NotificationDto.java 1.0 03/11/2024
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

public class NotificationDto {
	
	private Long id;
    private UserDto userDto;  // Usuario que recibe la notificación
    private String message;  // Mensaje de la notificación
    private boolean isRead;  // Indica si la notificación ha sido leída
    private LocalDateTime createdAt;  // Fecha de creación de la notificación
    
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "NotificationDto [id=" + id + ", userDto=" + userDto + ", message=" + message + ", isRead=" + isRead
				+ ", createdAt=" + createdAt + "]";
	}

}
