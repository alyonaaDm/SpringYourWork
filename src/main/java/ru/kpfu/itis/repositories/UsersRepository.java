package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.models.User;

import java.util.Optional;

@Repository("usersRepository")
public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
