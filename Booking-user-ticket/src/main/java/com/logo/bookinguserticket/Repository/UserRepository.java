package com.logo.bookinguserticket.Repository;

import com.logo.bookinguserticket.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Integer> {
    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findById(Integer id);

    Optional<User> findByEmail(String email);
}
