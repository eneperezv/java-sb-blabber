package com.enp.blabber.api.dto;

/*
 * @(#)CommentDto.java 1.0 14/09/2024
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

public class CommentDto {
	
	private Long id;
    private String content;  // El contenido del comentario (también limitado a 280 caracteres)
    private User user;  // Usuario que hizo el comentario
    private Blab blab;  // Blab comentado
    private LocalDateTime commentedAt;  // Fecha del comentario

}
