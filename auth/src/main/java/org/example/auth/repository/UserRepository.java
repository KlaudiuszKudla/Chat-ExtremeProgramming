package org.example.auth.repository;

import org.example.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findUserByLogin(String login);
    Optional<User> findUserByEmail(String email);
    @Query(nativeQuery = true, value = "SELECT * FROM users where login=?1 and is_locked=false and is_enabled=true")
    Optional<User> findUserByLoginAndIsLockedFalseAndIsEnabledTrue(String login);
    Optional<User> findUserByUuid(String uuid);
    Optional<User> findUserById(Long id);
    @Query(nativeQuery = true, value = "SELECT * FROM users where login=?1 and is_locked=false and is_enabled=true and role='ADMIN'")
    Optional<User> findUserByLoginAndLockAndEnabledAndIsAdmin(String login);


    @Query(nativeQuery = true, value = "SELECT u.* FROM users u  JOIN user_friends uf ON u.id = uf.user_id WHERE uf.friend_id=?1  AND is_accepted=false")
    Optional<List<User>> findFriendsByIdAndIsAcceptedByFriendFalse(Long id);

    @Query(nativeQuery = true, value = "SELECT u.* FROM users u  JOIN user_friends uf ON u.id = uf.friend_id WHERE uf.user_id=?1  AND is_accepted=false")
    Optional<List<User>> findFriendsByIdAndIsAcceptedByUserFalse(Long userId);

}
