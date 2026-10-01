package com.spring.meusfavoritos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.meusfavoritos.model.UserModel;
import com.spring.meusfavoritos.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	private final UserService service;

	@PostMapping("/{userId}/favorites/games/{gameId}")
	public void addFavoriteGame(@PathVariable Long userId, @PathVariable Long gameId) {
		service.addFavoriteGame(userId, gameId);
	}

	@PostMapping("/{userId}/favorites/movies/{movieId}")
	public void addFavoriteMovie(@PathVariable Long userId, @PathVariable Long movieId) {
		service.addFavoriteMovie(userId, movieId);
	}

	@PostMapping("/{userId}/favorites/musics/{musicId}")
	public void addFavoriteMusic(@PathVariable Long userId, @PathVariable Long musicId) {
		service.addFavoriteMusic(userId, musicId);
	}

	@PostMapping
	public UserModel save(@RequestBody UserModel userModel) {
		return service.save(userModel);
	}

	@GetMapping
	public List<UserModel> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Optional<UserModel> findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}
}
