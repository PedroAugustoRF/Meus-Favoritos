package com.spring.meusfavoritos.model.enumeration;

<<<<<<< HEAD
public enum Role {
	USER,
	ADM
=======
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
	USER,
	ADM;

	@Override
	public @Nullable String getAuthority() {
		return this.name();
	}
>>>>>>> 6916921 (v1.2)
}
