package com.eliteMart.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eliteMart.entity.User;

public class UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUsername(String username);

    public Optional<User> findByEmail(String email);

    public boolean existsByUsername(String username);

    public boolean existsByEmail(String email);

    @Query("SELECT u FROM USER u WHERE u.username = ?1 OR u.email = ?2")
    Optional<User> findByUsernameOrEmail(@Param("username") String username, @Param("email") String email);
}
