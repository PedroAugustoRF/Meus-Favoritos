package com.spring.meusfavoritos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.meusfavoritos.dto.MusicDto;
import com.spring.meusfavoritos.model.MusicModel;
import com.spring.meusfavoritos.repository.MusicRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MusicService {

	private final MusicRepository repository;

	public void save(MusicDto music) {
		repository.save(MusicModel.builder()
				.name(music.getName())
				.trackNumber(music.getTrackNumber())
				.artist(music.getArtist())
				.album(music.getAlbum())
				.publisher(music.getPublisher())
				.year(music.getYear())
				.build());
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