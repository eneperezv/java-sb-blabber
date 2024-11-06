package com.enp.blabber.api.service;

/*
 * @(#)FollowService.java 1.0 05/11/2024
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

import com.enp.blabber.api.dto.FollowDto;
import com.enp.blabber.api.model.Follow;
import com.enp.blabber.api.repository.FollowRepository;

@Service
public class FollowService {
	
	@Autowired
	private FollowRepository followRepository;
	
	@Autowired
	private UserService userService;
	
	public Follow buildEntity(FollowDto followDto) {
		Follow follow = new Follow();
		follow.setId(followDto.getId());
		follow.setFollower(userService.buildEntity(followDto.getFollowerDto()));
		follow.setFollowed(userService.buildEntity(followDto.getFollowedDto()));
		follow.setFollowedAt(followDto.getFollowedAt());
		
		return follow;
	}
	
	public FollowDto buildDto(Optional<Follow> optional) {
		FollowDto followDto = new FollowDto();
		followDto.setId(optional.get().getId());
		followDto.setFollowerDto(userService.buildDtoFromUser(optional.get().getFollower()));
		followDto.setFollowedDto(userService.buildDtoFromUser(optional.get().getFollowed()));
		followDto.setFollowedAt(optional.get().getFollowedAt());
		
		return followDto;
	}
	
	public FollowDto buildDtoFromFollow(Follow follow) {
		FollowDto followDto = new FollowDto();
		followDto.setId(follow.getId());
		followDto.setFollowerDto(userService.buildDtoFromUser(follow.getFollower()));
		followDto.setFollowedDto(userService.buildDtoFromUser(follow.getFollowed()));
		followDto.setFollowedAt(follow.getFollowedAt());
		
		return followDto;
	}
	
	public List<FollowDto> getFollows(Long userid){
		List<Follow> followsLista = new ArrayList<Follow>();
		followRepository.getFollows(userid).forEach(followsLista::add);
		
		List<FollowDto> followsDto = new ArrayList<FollowDto>();
		
		for(Follow follow : followsLista){
			followsDto.add(buildDtoFromFollow(follow));
		}

		return followsDto;
	}
	
	public List<FollowDto> getFollowers(Long userid){
		List<Follow> followsLista = new ArrayList<Follow>();
		followRepository.getFollowers(userid).forEach(followsLista::add);
		
		List<FollowDto> followsDto = new ArrayList<FollowDto>();
		
		for(Follow follow : followsLista){
			followsDto.add(buildDtoFromFollow(follow));
		}

		return followsDto;
	}

}
