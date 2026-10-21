package com.spring.meusfavoritos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.meusfavoritos.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{
<<<<<<< HEAD
	Optional<UserModel> findByEmail(String email);
	boolean existsByEmail(String email);
}
=======
    Optional<UserModel> findByUserName(String userName);
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
    Optional<UserModel> findByEmail(String email);
}

>>>>>>> 6916921 (v1.2)
