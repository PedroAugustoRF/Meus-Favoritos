package com.spring.meusfavoritos.controller;

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
import org.springframework.http.HttpStatus;
=======
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
>>>>>>> 6916921 (v1.2)
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
<<<<<<< HEAD

import com.spring.meusfavoritos.dto.UserDto;
import com.spring.meusfavoritos.model.UserModel;
=======
import org.springframework.web.server.ResponseStatusException;

import com.spring.meusfavoritos.dto.UserDto;
import com.spring.meusfavoritos.model.UserModel;
import com.spring.meusfavoritos.model.enumeration.Role;
>>>>>>> 6916921 (v1.2)
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
<<<<<<< HEAD
	public void addFavoriteGame(@PathVariable Long userId, @PathVariable Long gameId) {
		service.addFavoriteGame(userId, gameId);
=======
	public void addFavoriteGame(@PathVariable Long userId, @PathVariable Long gameId,
	                            @AuthenticationPrincipal UserModel me) {
	    checkOwnerOrAdmin(userId, me);
	    service.addFavoriteGame(userId, gameId);
>>>>>>> 6916921 (v1.2)
	}

	@PostMapping("/{userId}/favorites/movies/{movieId}")
	@ResponseStatus(HttpStatus.CREATED)
<<<<<<< HEAD
	public void addFavoriteMovie(@PathVariable Long userId, @PathVariable Long movieId) {
		service.addFavoriteMovie(userId, movieId);
=======
	public void addFavoriteMovie(@PathVariable Long userId, @PathVariable Long movieId,
	                             @AuthenticationPrincipal UserModel me) {
	    checkOwnerOrAdmin(userId, me);
	    service.addFavoriteMovie(userId, movieId);
>>>>>>> 6916921 (v1.2)
	}

	@PostMapping("/{userId}/favorites/musics/{musicId}")
	@ResponseStatus(HttpStatus.CREATED)
<<<<<<< HEAD
	public void addFavoriteMusic(@PathVariable Long userId, @PathVariable Long musicId) {
		service.addFavoriteMusic(userId, musicId);
=======
	public void addFavoriteMusic(@PathVariable Long userId, @PathVariable Long musicId,
	                             @AuthenticationPrincipal UserModel me) {
	    checkOwnerOrAdmin(userId, me);
	    service.addFavoriteMusic(userId, musicId);
	}

	private void checkOwnerOrAdmin(Long userId, UserModel me) {
	    if (!me.getId().equals(userId) && me.getRole() != Role.ADM) {
	        throw new ResponseStatusException(HttpStatus.FORBIDDEN);
	    }
	}
	
	@GetMapping("/me")
	@ResponseStatus(HttpStatus.OK)
	public Optional<UserModel> me(@AuthenticationPrincipal UserModel me) {
	    return service.findById(me.getId());
>>>>>>> 6916921 (v1.2)
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
<<<<<<< HEAD
	public void save(@Valid @RequestBody UserDto userDto) {
=======
	public void save(@Valid @RequestBody UserDto userDto) throws BadRequestException {
>>>>>>> 6916921 (v1.2)
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
