package com.enp.blabber.api.repository;

/*
 * @(#)CommentRepository.java 1.0 31/10/2024
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

import com.enp.blabber.api.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	@Query(value = "SELECT a.* FROM comments a WHERE a.blab_id = :blabid", nativeQuery = true)
	List<Comment> findAllByBladId(Long blabid);

}
