package com.spring.meusfavoritos.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.spring.meusfavoritos.model.enumeration.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private Integer idade;
	private LocalDate aniversario;
	
	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@ManyToMany
	@JoinTable(
		name = "user_favorite_games",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "game_id"))
	private Set<GameModel> favoriteGames = new HashSet<>();

	@ManyToMany
	@JoinTable(
		name = "user_favorite_movies",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private Set<MovieModel> favoriteMovies = new HashSet<>();

	@ManyToMany
	@JoinTable(
		name = "user_favorite_musics",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "music_id"))
	private Set<MusicModel> favoriteMusics = new HashSet<>();
}
