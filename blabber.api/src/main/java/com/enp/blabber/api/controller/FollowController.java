package com.enp.blabber.api.controller;

/*
 * @(#)FollowController.java 1.0 15/10/2024
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enp.blabber.api.service.FollowService;

@RestController
@RequestMapping("/api/v1/blabber/follows")
public class FollowController {
	
	@Autowired
	private FollowService followService;

}
