package com.enp.blabber.api.service;

/*
 * @(#)DirectMessageService.java 1.0 03/11/2024
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

	public List<DirectMessageDto> getDmSent(Long userId) {
		List<DirectMessage> listaDm = new ArrayList<DirectMessage>();
		dmRepository.getDmSent(userId).forEach(listaDm::add);
		
		List<DirectMessageDto> listaDmDto = new ArrayList<DirectMessageDto>();
		
		for(DirectMessage dm : listaDm){
			listaDmDto.add(buildDtoFromDirectMessage(dm));
		}

		return listaDmDto;
	}

}
