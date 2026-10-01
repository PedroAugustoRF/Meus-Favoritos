package com.spring.meusfavoritos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.meusfavoritos.model.GameModel;
import com.spring.meusfavoritos.repository.GameRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameService {

	private final GameRepository repository;

	public GameModel save(GameModel game) {
		return repository.save(game);
	}

	public List<GameModel> findAll() {
		return repository.findAll();
	}

	public Optional<GameModel> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}