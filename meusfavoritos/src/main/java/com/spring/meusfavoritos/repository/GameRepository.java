package com.spring.meusfavoritos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.meusfavoritos.model.GameModel;

public interface GameRepository extends JpaRepository<GameModel, Long> {
}