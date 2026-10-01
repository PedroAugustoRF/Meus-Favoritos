package com.spring.meusfavoritos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.meusfavoritos.model.MusicModel;
import com.spring.meusfavoritos.repository.MusicRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MusicService {

	private final MusicRepository repository;

	public MusicModel save(MusicModel music) {
		return repository.save(music);
	}

	public List<MusicModel> findAll() {
		return repository.findAll();
	}

	public Optional<MusicModel> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}