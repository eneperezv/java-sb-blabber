package com.enp.blabber.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enp.blabber.api.dto.NotificationDto;
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
	
	

}
