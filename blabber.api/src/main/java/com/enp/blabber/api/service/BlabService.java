package com.enp.blabber.api.service;

/*
 * @(#)BlabService.java 1.0 6/09/2024
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

	public BlabDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public BlabDto createBlab(BlabDto blabDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Blab buildEntity(BlabDto blabDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setRole(userDto.getRole());
		user.setName(userDto.getName());
		
		return user;
	}
	
	public BlabDto buildDto(Optional<Blab> optional) {
		UserDto userDto = new UserDto();
		userDto.setId(optional.get().getId());
		userDto.setUsername(optional.get().getUsername());
		userDto.setPassword(optional.get().getPassword());
		userDto.setRole(optional.get().getRole());
		userDto.setName(optional.get().getName());
		
		return userDto;
	}

}
