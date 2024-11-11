package com.enp.blabber.api.utils;

/*
 * @(#)DataUtils.java 1.0 31/10/2024
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
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enp.blabber.api.dto.NotificationDto;
import com.enp.blabber.api.dto.UserDto;
import com.enp.blabber.api.service.NotificationService;
import com.enp.blabber.api.service.UserService;

@Service
public class DataUtils {
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private UserService userService;
	
	public LocalDateTime getTimeNow() {
		ZoneId colombiaZone = ZoneId.of("America/Bogota");
		return LocalDateTime.now(colombiaZone);
	}
	
	public void setNotification(Long sendUserId,Long receiveUserId,String notificationMessage) {
		UserDto userSend = userService.findById(sendUserId);
		UserDto userRecieve = userService.findById(receiveUserId);
		NotificationDto notification = new NotificationDto();
		notification.setId(null);
		notification.setUserDto(userRecieve);
		notification.setMessage(userSend.getUsername() + " has started following you.");
		notification.setCreatedAt(getTimeNow());
		notification.setRead(false);
		notificationService.createNotification(notification);
	}

}
