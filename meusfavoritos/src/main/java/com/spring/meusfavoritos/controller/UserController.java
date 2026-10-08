package com.spring.meusfavoritos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.meusfavoritos.dto.UserDto;
import com.spring.meusfavoritos.model.UserModel;
import com.spring.meusfavoritos.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Validated
public class UserController {
	private final UserService service;

	@PostMapping("/{userId}/favorites/games/{gameId}")
	@ResponseStatus(HttpStatus.CREATED)
	public void addFavoriteGame(@PathVariable Long userId, @PathVariable Long gameId) {
		service.addFavoriteGame(userId, gameId);
	}

	@PostMapping("/{userId}/favorites/movies/{movieId}")
	@ResponseStatus(HttpStatus.CREATED)
	public void addFavoriteMovie(@PathVariable Long userId, @PathVariable Long movieId) {
		service.addFavoriteMovie(userId, movieId);
	}

	@PostMapping("/{userId}/favorites/musics/{musicId}")
	@ResponseStatus(HttpStatus.CREATED)
	public void addFavoriteMusic(@PathVariable Long userId, @PathVariable Long musicId) {
		service.addFavoriteMusic(userId, musicId);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@Valid @RequestBody UserDto userDto) {
		service.save(userDto);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<UserModel> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<UserModel> findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}
}
