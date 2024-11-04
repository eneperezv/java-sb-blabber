package com.enp.blabber.api.repository;

/*
 * @(#)LikeRepository.java 1.0 31/10/2024
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

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enp.blabber.api.model.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
	
	@Query(value = "SELECT a.* FROM likes a WHERE a.blab_id = :blabid", nativeQuery = true)
	List<Like> findAllByBladId(Long blabid);

}
