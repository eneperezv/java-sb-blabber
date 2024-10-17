package com.enp.blabber.api.service;

/*
 * @(#)NotificationService.java 1.0 16/10/2024
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
import org.springframework.stereotype.Service;

import com.enp.blabber.api.repository.NotificationRepository;

@Service
public class NotificationService {
	
	@Autowired
	private NotificationRepository notificationRepository;

}
