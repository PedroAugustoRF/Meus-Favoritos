package com.spring.meusfavoritos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.meusfavoritos.model.MovieModel;

public interface MovieRepository extends JpaRepository<MovieModel, Long> {

}
