package com.spring.meusfavoritos.dto;

import com.spring.meusfavoritos.model.MusicModel;

public record MusicResponse(Long id, String name, Integer trackNumber, String artist, String album, String publisher,
		Integer year) {

	public static MusicResponse from(MusicModel m) {
		return new MusicResponse(m.getId(), m.getName(), m.getTrackNumber(), m.getArtist(), m.getAlbum(),
				m.getPublisher(), m.getYear());
	}
}