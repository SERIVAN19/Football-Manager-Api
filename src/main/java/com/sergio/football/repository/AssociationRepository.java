package com.sergio.football.repository;

import com.sergio.football.entity.Association;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociationRepository extends JpaRepository<Association,Long> {
}
