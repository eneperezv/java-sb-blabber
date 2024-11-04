package com.enp.blabber.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enp.blabber.api.dto.DirectMessageDto;
import com.enp.blabber.api.model.DirectMessage;
import com.enp.blabber.api.repository.DirectMessageRepository;

@Service
public class DirectMessageService {
	
	@Autowired
	private DirectMessageRepository dmRepository;
	
	@Autowired
	private UserService userService;
	
	public DirectMessage buildEntity(DirectMessageDto dmDto) {
		DirectMessage dm = new DirectMessage();
		dm.setId(dmDto.getId());
		dm.setSender(userService.buildEntity(dmDto.getSenderDto()));
		dm.setReceiver(userService.buildEntity(dmDto.getReceiverDto()));
		dm.setContent(dmDto.getContent());
		dm.setSentAt(dmDto.getSentAt());
		dm.setRead(dmDto.isRead());
		
		return dm;
	}
	
	public DirectMessageDto buildDto(Optional<DirectMessage> optional) {
		DirectMessageDto dmDto = new DirectMessageDto();
		dmDto.setId(optional.get().getId());
		dmDto.setSenderDto(userService.buildDtoFromUser(optional.get().getSender()));
		dmDto.setReceiverDto(userService.buildDtoFromUser(optional.get().getReceiver()));
		dmDto.setContent(optional.get().getContent());
		dmDto.setSentAt(optional.get().getSentAt());
		dmDto.setRead(optional.get().isRead());
		
		return dmDto;
	}
	
	public DirectMessageDto buildDtoFromDirectMessage(DirectMessage dm) {
		DirectMessageDto dmDto = new DirectMessageDto();
		dmDto.setId(dm.getId());
		dmDto.setSenderDto(userService.buildDtoFromUser(dm.getSender()));
		dmDto.setReceiverDto(userService.buildDtoFromUser(dm.getReceiver()));
		dmDto.setContent(dm.getContent());
		dmDto.setSentAt(dm.getSentAt());
		dmDto.setRead(dm.isRead());
		
		return dmDto;
	}

	public DirectMessageDto sendDm(DirectMessageDto dmDto) {
		return buildDto(Optional.of(dmRepository.save(buildEntity(dmDto))));
	}

}
