package br.com.dev.studyhateoas.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dev.studyhateoas.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
}
