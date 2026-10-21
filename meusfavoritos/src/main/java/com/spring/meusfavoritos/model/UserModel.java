package com.spring.meusfavoritos.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class UserModel implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Column(name = "user_name", nullable = false, unique = true)
	private String userName;
	
	private Integer idade;
	
	private LocalDate aniversario;
	
	@Column(nullable = false, unique = true)
	private String email;

	@JsonIgnore
	@Column(nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@ManyToMany
	@JoinTable(
		name = "user_favorite_games",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "game_id"))
	@Builder.Default
	private Set<GameModel> favoriteGames = new HashSet<>();

	@ManyToMany
	@JoinTable(
		name = "user_favorite_movies",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "movie_id"))
	@Builder.Default
	private Set<MovieModel> favoriteMovies = new HashSet<>();

	@ManyToMany
	@JoinTable(
		name = "user_favorite_musics",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "music_id"))
	@Builder.Default
	private Set<MusicModel> favoriteMusics = new HashSet<>();
	
	@PrePersist
	public void gerarUserName() {
		if (this.userName == null && this.nome != null) {
			this.userName = this.nome.toLowerCase()
					.replace(" ", "")
					.concat("#" + UUID.randomUUID().toString().substring(0, 8));
		}
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(role);
	}

	@Override
	public String getUsername() {
		return email;
	}
}
