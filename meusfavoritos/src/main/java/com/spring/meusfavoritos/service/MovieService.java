package com.spring.meusfavoritos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.meusfavoritos.model.MovieModel;
import com.spring.meusfavoritos.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {

	private final MovieRepository repository;

	public MovieModel save(MovieModel movie) {
		return repository.save(movie);
	}

	public List<MovieModel> findAll() {
		return repository.findAll();
	}

	public Optional<MovieModel> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}