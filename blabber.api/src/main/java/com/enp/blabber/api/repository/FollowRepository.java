package com.enp.blabber.api.repository;

/*
 * @(#)FollowRepository.java 1.0 05/11/2024
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

import com.enp.blabber.api.model.Follow;

public interface FollowRepository extends JpaRepository<Follow, Long> {
	
	@Query(value = "SELECT a.* FROM follows a WHERE a.follower_id = :userid", nativeQuery = true)
	List<Follow> getFollows(Long userid);

	@Query(value = "SELECT a.* FROM follows a WHERE a.followed_id = :userid", nativeQuery = true)
	List<Follow> getFollowers(Long userid);

}
