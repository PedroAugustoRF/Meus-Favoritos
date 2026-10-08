package com.spring.meusfavoritos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.meusfavoritos.dto.GameDto;
import com.spring.meusfavoritos.model.GameModel;
import com.spring.meusfavoritos.repository.GameRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameService {

	private final GameRepository repository;

	public void save(GameDto game) {
		repository.save(GameModel.builder()
				.name(game.getName())
				.publisher(game.getPublisher())
				.developer(game.getDeveloper())
				.year(game.getYear())
				.build());
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