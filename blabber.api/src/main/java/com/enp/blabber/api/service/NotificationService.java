package com.enp.blabber.api.service;

import java.util.ArrayList;
import java.util.List;

/*
 * @(#)NotificationService.java 1.0 29/10/2024
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

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enp.blabber.api.dto.LikeDto;
import com.enp.blabber.api.dto.NotificationDto;
import com.enp.blabber.api.model.Like;
import com.enp.blabber.api.model.Notification;
import com.enp.blabber.api.repository.NotificationRepository;

@Service
public class NotificationService {
	
	@Autowired
	private NotificationRepository notificationRepository;
	
	@Autowired
	private UserService userService;
	
	public Notification buildEntity(NotificationDto notificationDto) {
		Notification notification = new Notification();
		notification.setId(notificationDto.getId());
		notification.setUser(userService.buildEntity(notificationDto.getUserDto()));
		notification.setMessage(notificationDto.getMessage());
		notification.setRead(notificationDto.isRead());
		notification.setCreatedAt(notificationDto.getCreatedAt());
		
		return notification;
	}
	
	public NotificationDto buildDto(Optional<Notification> optional) {
		NotificationDto notificationDto = new NotificationDto();
		notificationDto.setId(optional.get().getId());
		notificationDto.setUserDto(userService.buildDtoFromUser(optional.get().getUser()));
		notificationDto.setMessage(optional.get().getMessage());
		notificationDto.setRead(optional.get().isRead());
		notificationDto.setCreatedAt(optional.get().getCreatedAt());
		
		return notificationDto;
	}
	
	public NotificationDto buildDtoFromNotification(Notification notification) {
		NotificationDto notificationDto = new NotificationDto();
		notificationDto.setId(notification.getId());
		notificationDto.setUserDto(userService.buildDtoFromUser(notification.getUser()));
		notificationDto.setMessage(notification.getMessage());
		notificationDto.setRead(notification.isRead());
		notificationDto.setCreatedAt(notification.getCreatedAt());
		
		return notificationDto;
	}
	
	public void createNotification(NotificationDto notificationDto) {
		notificationRepository.save(buildEntity(notificationDto));
	}
	
	public List<NotificationDto> getNotifications(Long userid){
		List<Notification> notificationsLista = new ArrayList<Notification>();
		notificationRepository.findAllByUserId(userid).forEach(notificationsLista::add);
		
		List<NotificationDto> notificationsDto = new ArrayList<NotificationDto>();
		
		for(Notification notification : notificationsLista){
			notificationsDto.add(buildDtoFromNotification(notification));
		}

		return notificationsDto;
	}

}
