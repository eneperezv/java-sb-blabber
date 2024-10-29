package com.enp.blabber.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enp.blabber.api.model.Blab;

@Repository
public interface BlabRepository extends JpaRepository<Blab, Long> {

}
