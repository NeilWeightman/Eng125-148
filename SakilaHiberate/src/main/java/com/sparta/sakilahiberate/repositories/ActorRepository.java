package com.sparta.sakilahiberate.repositories;

import com.sparta.sakilahiberate.entities.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<ActorEntity, Integer> {
    List<ActorEntity> findByLastName(String lastName);
}