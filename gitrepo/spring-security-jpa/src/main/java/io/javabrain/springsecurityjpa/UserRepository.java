package io.javabrain.springsecurityjpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



import io.javabrain.springsecurityjpa.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
 
	Optional<User> findByUserName(String userName);
}
