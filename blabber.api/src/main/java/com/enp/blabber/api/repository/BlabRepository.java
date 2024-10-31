package com.enp.blabber.api.repository;

/*
 * @(#)BlabRepository.java 1.0 29/10/2024
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

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enp.blabber.api.model.Blab;

@Repository
public interface BlabRepository extends JpaRepository<Blab, Long> {

}
