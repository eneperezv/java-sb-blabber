package com.enp.blabber.api.dto;

/*
 * @(#)LikeDto.java 1.0 14/09/2024
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

import java.time.LocalDateTime;

import com.enp.blabber.api.model.Blab;
import com.enp.blabber.api.model.User;

public class LikeDto {
	
	private Long id;
	private User user;  // Usuario que dio el Like
    private Blab blab;  // Blab al que se le dio el Like
    private LocalDateTime likedAt;  // Fecha en la que se dio el Like

}
