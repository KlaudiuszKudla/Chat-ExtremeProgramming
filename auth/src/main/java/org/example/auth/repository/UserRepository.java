package org.example.auth.repository;

import org.example.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findUserByLogin(String login);
    Optional<User> findUserByEmail(String email);
    @Query(nativeQuery = true, value = "SELECT * FROM users where login=?1 and is_locked=false and is_enabled=true")
    Optional<User> findUserByLoginAndIsLockedFalseAndIsEnabledTrue(String login);
}
