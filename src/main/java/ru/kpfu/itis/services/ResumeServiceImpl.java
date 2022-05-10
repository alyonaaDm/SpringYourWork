package ru.kpfu.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.models.Resume;
import ru.kpfu.itis.repositories.ResumesRepository;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumesRepository resumesRepository;

    @Override
    public Resume getById(Long resumeId) {
        return resumesRepository.getById(resumeId);
    }

    @Override
    public List<Resume> findAll() {
        return resumesRepository.findAll();
    }
}
