package com.spring.meusfavoritos.service;

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
import org.springframework.stereotype.Service;
=======
import org.apache.coyote.BadRequestException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
>>>>>>> 6916921 (v1.2)

import com.spring.meusfavoritos.dto.UserDto;
import com.spring.meusfavoritos.model.GameModel;
import com.spring.meusfavoritos.model.MovieModel;
import com.spring.meusfavoritos.model.MusicModel;
import com.spring.meusfavoritos.model.UserModel;
import com.spring.meusfavoritos.repository.GameRepository;
import com.spring.meusfavoritos.repository.MovieRepository;
import com.spring.meusfavoritos.repository.MusicRepository;
import com.spring.meusfavoritos.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository repository;
	private final GameRepository gameRepository;
	private final MovieRepository movieRepository;
	private final MusicRepository musicRepository;

<<<<<<< HEAD
=======
	private final PasswordEncoder passwordEncoder;
	
>>>>>>> 6916921 (v1.2)
	private UserModel findUserOrThrow(Long userId) {
		return repository.findById(userId)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
	}
<<<<<<< HEAD

=======
	
	@Transactional
>>>>>>> 6916921 (v1.2)
	public void addFavoriteGame(Long userId, Long gameId) {
		UserModel user = findUserOrThrow(userId);
		GameModel game = gameRepository.findById(gameId)
				.orElseThrow(() -> new RuntimeException("Jogo não encontrado"));

		user.getFavoriteGames().add(game);
		repository.save(user);
	}
<<<<<<< HEAD

=======
	
	@Transactional
>>>>>>> 6916921 (v1.2)
	public void addFavoriteMovie(Long userId, Long movieId) {
		UserModel user = findUserOrThrow(userId);
		MovieModel movie = movieRepository.findById(movieId)
				.orElseThrow(() -> new RuntimeException("Filme não encontrado"));

		user.getFavoriteMovies().add(movie);
		repository.save(user);
	}
<<<<<<< HEAD

=======
	
	@Transactional
>>>>>>> 6916921 (v1.2)
	public void addFavoriteMusic(Long userId, Long musicId) {
		UserModel user = findUserOrThrow(userId);
		MusicModel music = musicRepository.findById(musicId)
				.orElseThrow(() -> new RuntimeException("Música não encontrada"));

		user.getFavoriteMusics().add(music);
		repository.save(user);
	}

<<<<<<< HEAD
	public void save(UserDto user) {
=======
	public void save(UserDto user) throws BadRequestException {		
		if(repository.existsByEmail(user.getEmail())) {
			throw new BadRequestException("Usuário já cadastrado com esse email");
		}
	
>>>>>>> 6916921 (v1.2)
		repository.save(UserModel.builder()
				.nome(user.getNome())
				.idade(user.getIdade())
				.aniversario(user.getAniversario())
				.email(user.getEmail())
<<<<<<< HEAD
				.password(user.getPassword())
=======
				.password(passwordEncoder.encode(user.getPassword()))
>>>>>>> 6916921 (v1.2)
				.role(user.getRole())
				.build());
	}

	public List<UserModel> findAll() {
		return repository.findAll();
	}

	public Optional<UserModel> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}