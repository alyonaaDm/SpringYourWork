package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.models.Resume;
import ru.kpfu.itis.models.User;

import java.util.Optional;

@Repository("resumesRepository")
public interface ResumesRepository extends JpaRepository<Resume, Long> {
}
