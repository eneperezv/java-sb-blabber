package com.enp.blabber.api.service;

/*
 * @(#)BlabService.java 1.0 29/10/2024
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

import com.enp.blabber.api.dto.BlabDto;
import com.enp.blabber.api.dto.UserDto;
import com.enp.blabber.api.model.Blab;
import com.enp.blabber.api.model.User;
import com.enp.blabber.api.repository.BlabRepository;

@Service
public class BlabService {
	
	@Autowired
	private BlabRepository blabRepository;
	
	@Autowired
	private UserService userService;
	
	public BlabDto createBlab(BlabDto blabDto) {
		return buildDto(Optional.of(blabRepository.save(buildEntity(blabDto))));
	}

	public BlabDto findById(Long id) {
		return buildDto(blabRepository.findById(id));
	}
	
	public Blab buildEntity(BlabDto blabDto) {
		Blab blab = new Blab();
		blab.setId(blabDto.getId());
		blab.setContent(blabDto.getContent());
		blab.setUser(userService.buildEntity(blabDto.getUserDto()));
		blab.setCreatedAt(blabDto.getCreatedAt());
		
		return blab;
	}
	
	public BlabDto buildDto(Optional<Blab> optional) {
		BlabDto blabDto = new BlabDto();
		blabDto.setId(optional.get().getId());
		blabDto.setContent(optional.get().getContent());
		blabDto.setUserDto(userService.buildDtoFromUser(optional.get().getUser()));
		blabDto.setCreatedAt(optional.get().getCreatedAt());
		
		return blabDto;
	}
	
	public BlabDto buildDtoFromBlab(Blab blab) {
		BlabDto blabDto = new BlabDto();
		blabDto.setId(blab.getId());
		blabDto.setContent(blab.getContent());
		blabDto.setUserDto(userService.buildDtoFromUser(blab.getUser()));
		blabDto.setCreatedAt(blab.getCreatedAt());
		
		return blabDto;
	}

}
