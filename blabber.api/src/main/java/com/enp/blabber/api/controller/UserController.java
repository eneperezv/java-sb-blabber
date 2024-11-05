package com.enp.blabber.api.controller;

/*
 * @(#)UserController.java 1.0 29/10/2024
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

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enp.blabber.api.dto.BlabDto;
import com.enp.blabber.api.dto.DirectMessageDto;
import com.enp.blabber.api.dto.NotificationDto;
import com.enp.blabber.api.dto.UserDto;
import com.enp.blabber.api.model.ErrorDetails;
import com.enp.blabber.api.model.ResponseDetails;
import com.enp.blabber.api.service.BlabService;
import com.enp.blabber.api.service.DirectMessageService;
import com.enp.blabber.api.service.NotificationService;
import com.enp.blabber.api.service.UserService;
import com.enp.blabber.api.utils.DataUtils;

@RestController
@RequestMapping("/api/v1/blabber/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BlabService blabService;
	
	@Autowired
	private DirectMessageService dmService;
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private DataUtils util;
	
	@PostMapping("/create")
	public ResponseDetails<?> createUser(@RequestBody UserDto userDto){
		UserDto savedUserDto;
		try{
			savedUserDto = userService.createUser(userDto);
			if(savedUserDto == null) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"User <"+savedUserDto+"> not found");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_FOUND", HttpStatus.NOT_FOUND));
			}
			return new ResponseDetails<UserDto>("OK",new Date(),new ResponseEntity<UserDto>(savedUserDto, HttpStatus.OK));
		}catch(Exception e){
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage());
			return new ResponseDetails<ErrorDetails>("ERROR",new Date(),new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}
	
	@GetMapping("/{id}")
	public ResponseDetails<?> getUser(@PathVariable Long id){
		UserDto userDto;
		try {
			userDto = userService.findById(id);
			if(userDto == null) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"User <"+userDto+"> not found");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_FOUND", HttpStatus.NOT_FOUND));
			}
			//***OBTENER BLABS
			List<BlabDto> blabsPublished = new ArrayList<BlabDto>();
			blabService.getBlabsByUserId(userDto.getId()).forEach(blabsPublished::add);
			if(blabsPublished.isEmpty()) {
				userDto.setBlabsDto(new ArrayList<BlabDto>());
				userDto.setBlabsCount(0);
			}else {
				userDto.setBlabsDto(blabsPublished);
				userDto.setBlabsCount(blabsPublished.size());
			}
			//***OBTENER DMS RECIBIDOS
			List<DirectMessageDto> dmReceived = new ArrayList<DirectMessageDto>();
			dmService.getDmReceived(userDto.getId()).forEach(dmReceived::add);
			if(dmReceived.isEmpty()) {
				userDto.setReceivedMessagesDto(new ArrayList<DirectMessageDto>());
				userDto.setDmReceivedCount(0);
			}else {
				userDto.setReceivedMessagesDto(dmReceived);
				userDto.setDmReceivedCount(dmReceived.size());
			}
			//***OBTENER DMS ENVIADOS
			List<DirectMessageDto> dmSent = new ArrayList<DirectMessageDto>();
			dmService.getDmSent(userDto.getId()).forEach(dmSent::add);
			if(dmSent.isEmpty()) {
				userDto.setSentMessagesDto(new ArrayList<DirectMessageDto>());
			}else {
				userDto.setSentMessagesDto(dmSent);
			}
			//***OBTENER NOTIFICACIONES
			List<NotificationDto> notifications = new ArrayList<NotificationDto>();
			notificationService.getNotifications(userDto.getId()).forEach(notifications::add);
			if(notifications.isEmpty()) {
				userDto.setNotificationsDto(new ArrayList<NotificationDto>());
				userDto.setNotificationCount(0);
			}else {
				userDto.setNotificationsDto(notifications);
				userDto.setNotificationCount(notifications.size());
			}
			//OBTENER FOLLOWS
			//OBTENER FOLLOWERS
			return new ResponseDetails<UserDto>("OK",new Date(),new ResponseEntity<UserDto>(userDto, HttpStatus.OK));
		}catch(Exception e) {
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage());
			return new ResponseDetails<ErrorDetails>("ERROR",new Date(),new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}
	
	@PutMapping("/{id}")
	public ResponseDetails<?> updateUser(@RequestBody UserDto userDto){
		UserDto searchedUserDto;
		UserDto savedUserDto;
		try {
			searchedUserDto = userService.findById(userDto.getId());
			if(searchedUserDto == null) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"User <"+searchedUserDto+"> not found");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_FOUND", HttpStatus.NOT_FOUND));
			}
			savedUserDto = userService.updateUser(userDto);
			if(savedUserDto == null) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"User <"+savedUserDto+"> not found");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_FOUND", HttpStatus.NOT_FOUND));
			}
			return new ResponseDetails<UserDto>("OK",new Date(),new ResponseEntity<UserDto>(savedUserDto, HttpStatus.OK));
		}catch(Exception e) {
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage());
			return new ResponseDetails<ErrorDetails>("ERROR",new Date(),new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}
	
	@PostMapping("/dm/send")
	public ResponseDetails<?> sendDm(@RequestBody DirectMessageDto dmDto){
		DirectMessageDto savedDmDto;
		try {
			savedDmDto = dmService.sendDm(dmDto);
			if(savedDmDto == null) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"Direct Message <"+savedDmDto+"> not sent");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_FOUND", HttpStatus.NOT_FOUND));
			}
			UserDto userDto = userService.findById(dmDto.getSenderDto().getId());
			NotificationDto notification = new NotificationDto();
			notification.setId(null);
			notification.setUserDto(dmDto.getReceiverDto());
			notification.setMessage(userDto.getUsername() + " has sent you a direct message.");
			notification.setCreatedAt(util.getTimeNow());
			notification.setRead(false);
			notificationService.createNotification(notification);
			return new ResponseDetails<DirectMessageDto>("OK",new Date(),new ResponseEntity<DirectMessageDto>(savedDmDto, HttpStatus.OK));
		}catch(Exception e) {
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage());
			return new ResponseDetails<ErrorDetails>("ERROR",new Date(),new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}
	
	@GetMapping("/dm/sent/{id}")
	public ResponseDetails<?> getDmSent(@PathVariable Long userId){
		List<DirectMessageDto> dmSent = new ArrayList<DirectMessageDto>();
		try {
			dmService.getDmSent(userId).forEach(dmSent::add);
			if(dmSent.isEmpty()) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"This User has not sent DMs to anyone.");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_FOUND", HttpStatus.NOT_FOUND));
			}
			return new ResponseDetails<List<DirectMessageDto>>("OK",new Date(),new ResponseEntity<List<DirectMessageDto>>(dmSent, HttpStatus.OK));
		}catch(Exception e) {
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage());
			return new ResponseDetails<ErrorDetails>("ERROR",new Date(),new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}
	
	@GetMapping("/dm/received/{id}")
	public ResponseDetails<?> getDmReceived(@PathVariable Long userId){
		List<DirectMessageDto> dmReceived = new ArrayList<DirectMessageDto>();
		try {
			dmService.getDmReceived(userId).forEach(dmReceived::add);
			if(dmReceived.isEmpty()) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"This User has not sent DMs to anyone.");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_FOUND", HttpStatus.NOT_FOUND));
			}
			return new ResponseDetails<List<DirectMessageDto>>("OK",new Date(),new ResponseEntity<List<DirectMessageDto>>(dmReceived, HttpStatus.OK));
		}catch(Exception e) {
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage());
			return new ResponseDetails<ErrorDetails>("ERROR",new Date(),new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}
	
}
