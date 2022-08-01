package com.sparta.sakilaweb.repositories;

import com.sparta.sakilaweb.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}