package ru.kpfu.itis.services;

import ru.kpfu.itis.models.Resume;

import java.util.List;

public interface ResumeService {
    Resume getById(Long resumeId);
    List<Resume> findAll();
}

