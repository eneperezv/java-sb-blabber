package com.enp.blabber.api.service;

/*
 * @(#)LikeService.java 1.0 31/10/2024
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
import com.enp.blabber.api.model.Like;
import com.enp.blabber.api.repository.LikeRepository;

@Service
public class LikeService {
	
	@Autowired
	private LikeRepository likeRepository;
	
	@Autowired
	private BlabService blabService;
	
	@Autowired
	private UserService userService;
	
	public Like buildEntity(LikeDto likeDto) {
		Like like = new Like();
		like.setId(likeDto.getId());
		like.setUser(userService.buildEntity(likeDto.getUserDto()));
		like.setBlab(blabService.buildEntity(likeDto.getBlabDto()));
		like.setLikedAt(likeDto.getLikedAt());
		
		return like;
	}
	
	public LikeDto buildDto(Optional<Like> optional) {
		LikeDto likeDto = new LikeDto();
		likeDto.setId(likeDto.getId());
		likeDto.setUserDto(userService.buildDtoFromUser(optional.get().getUser()));
		likeDto.setBlabDto(blabService.buildDtoFromBlab(optional.get().getBlab()));
		likeDto.setLikedAt(likeDto.getLikedAt());
		
		return likeDto;
	}
	
	public LikeDto buildDtoFromLike(Like like) {
		LikeDto likeDto = new LikeDto();
		likeDto.setId(like.getId());
		likeDto.setUserDto(userService.buildDtoFromUser(like.getUser()));
		likeDto.setBlabDto(blabService.buildDtoFromBlab(like.getBlab()));
		likeDto.setLikedAt(likeDto.getLikedAt());
		
		return likeDto;
	}

	public LikeDto setBlabLike(LikeDto likeDto) {
		return buildDto(Optional.of(likeRepository.save(buildEntity(likeDto))));
	}

}
