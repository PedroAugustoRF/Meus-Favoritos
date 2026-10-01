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

import com.spring.meusfavoritos.model.GameModel;
import com.spring.meusfavoritos.service.GameService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {
	private final GameService service;

	@PostMapping
	public GameModel save(@RequestBody GameModel gameModel) {
		return service.save(gameModel);
	}

	@GetMapping
	public List<GameModel> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Optional<GameModel> findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}
}