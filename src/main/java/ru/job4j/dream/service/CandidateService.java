package ru.job4j.dream.service;

import org.springframework.stereotype.Service;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.persistence.CandidateRepository;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CandidateService {

    private final CandidateRepository repository;

    public CandidateService(CandidateRepository repository) {
        this.repository = repository;
    }

    public Collection<Candidate> findAll() {
        List<Candidate> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public void create(Candidate candidate) {
        repository.save(candidate);
    }

    public void create(List<Candidate> candidates) {
        repository.saveAll(candidates);
    }

    public Candidate findById(int id) {
        return repository.findById(id).get();
    }

    public void update(Candidate candidate) {
        repository.update(
                candidate.getName(),
                candidate.getDescription(),
                LocalDateTime.now(),
                candidate.getPhoto(),
                candidate.getId()
                );
    }

    public void delete(Candidate candidate) {
        repository.delete(candidate);
    }
}
