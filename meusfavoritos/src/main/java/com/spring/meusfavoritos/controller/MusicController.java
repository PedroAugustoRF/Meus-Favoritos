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

import com.spring.meusfavoritos.model.MusicModel;
import com.spring.meusfavoritos.service.MusicService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/musics")
@RequiredArgsConstructor
public class MusicController {
	private final MusicService service;

	@PostMapping
	public MusicModel save(@RequestBody MusicModel musicModel) {
		return service.save(musicModel);
	}

	@GetMapping
	public List<MusicModel> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Optional<MusicModel> findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}
}