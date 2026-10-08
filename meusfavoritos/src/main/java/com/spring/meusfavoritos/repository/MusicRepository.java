package com.spring.meusfavoritos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.meusfavoritos.model.MusicModel;

public interface MusicRepository extends JpaRepository<MusicModel, Long> {

}
