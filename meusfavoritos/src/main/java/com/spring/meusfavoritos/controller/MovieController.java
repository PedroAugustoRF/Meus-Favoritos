package com.spring.meusfavoritos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.meusfavoritos.model.MovieModel;
import com.spring.meusfavoritos.service.MovieService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
	private final MovieService service;

	@PostMapping
	public MovieModel save(@RequestBody MovieModel movieModel) {
		return service.save(movieModel);
	}

	@GetMapping
	public List<MovieModel> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Optional<MovieModel> findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}
}