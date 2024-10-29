package com.enp.blabber.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enp.blabber.api.dto.BlabDto;
import com.enp.blabber.api.model.Blab;
import com.enp.blabber.api.repository.BlabRepository;

@Service
public class BlabService {
	
	@Autowired
	private BlabRepository blabRepository;
	
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
		blab.setUser(blabDto.getUser());
		blab.setCreatedAt(blabDto.getCreatedAt());
		
		return blab;
	}
	
	public BlabDto buildDto(Optional<Blab> optional) {
		BlabDto blabDto = new BlabDto();
		blabDto.setId(optional.get().getId());
		blabDto.setContent(optional.get().getContent());
		blabDto.setUser(optional.get().getUser());
		blabDto.setCreatedAt(optional.get().getCreatedAt());
		
		return blabDto;
	}

}
