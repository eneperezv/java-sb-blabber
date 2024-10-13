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

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enp.blabber.api.dto.BlabDto;
import com.enp.blabber.api.dto.CommentDto;
import com.enp.blabber.api.dto.LikeDto;
import com.enp.blabber.api.model.Blab;
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

	public List<BlabDto> getBlabsByUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteBlab(Long id) {
		// TODO Auto-generated method stub
		
	}

	public CommentDto createBlabComment(CommentDto commentDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CommentDto> getBlabComments(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteBlabComment(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	public Blab buildEntity(BlabDto blabDto) {
		Blab blab = new Blab();
		blab.setId(blabDto.getId());
		blab.setContent(blabDto.getContent());
		blab.setUser(blabDto.getUser());
		blab.setComments(blabDto.getComments());
		blab.setLikes(blabDto.getLikes());
		blab.setCreatedAt(blabDto.getCreatedAt());
		blab.setUpdatedAt(blabDto.getUpdatedAt());

		return blab;
	}
	
	public BlabDto buildDto(Optional<Blab> optional) {
		BlabDto blabDto = new BlabDto();
		blabDto.setId(optional.get().getId());
		blabDto.setContent(optional.get().getContent());
		blabDto.setUser(optional.get().getUser());
		blabDto.setComments(optional.get().getComments());
		blabDto.setLikes(optional.get().getLikes());
		blabDto.setCreatedAt(optional.get().getCreatedAt());
		blabDto.setUpdatedAt(optional.get().getUpdatedAt());
		
		return blabDto;
	}

	public LikeDto createBlabLike(LikeDto likeDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
