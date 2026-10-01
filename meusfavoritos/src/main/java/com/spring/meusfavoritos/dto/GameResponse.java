package com.spring.meusfavoritos.dto;

import com.spring.meusfavoritos.model.GameModel;

public record GameResponse(Long id, String name, String publisher, String developers, Integer year) {

	public static GameResponse from(GameModel g) {
		return new GameResponse(g.getId(), g.getName(), g.getPublisher(), g.getDeveloper(), g.getYear());
	}
}