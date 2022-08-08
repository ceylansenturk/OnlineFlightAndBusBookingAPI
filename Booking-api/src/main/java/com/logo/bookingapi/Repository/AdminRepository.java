package com.logo.bookingapi.Repository;

import com.logo.bookingapi.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository  extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByEmailAndPassword(String email, String password);
    Optional<Admin> findById(Integer id);

    Optional<Admin> findByEmail(String email);
}
