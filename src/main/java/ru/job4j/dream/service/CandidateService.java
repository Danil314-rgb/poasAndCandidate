package ru.job4j.dream.service;

import org.springframework.stereotype.Service;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.persistence.CandidateRepository;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CandidateService {

    /*private final CandidateDbStore candidateDbStore;*/
    /**/
    private final CandidateRepository repository;

    public CandidateService(/*CandidateDbStore candidateStore,*/ CandidateRepository repository) {
        this.repository = repository;
        /*this.candidateDbStore = candidateStore;*/
    }

    public Collection<Candidate> findAll() {
        List<Candidate> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
        /*return candidateDbStore.findAll();*/
    }

    public void create(Candidate candidate) {
        repository.save(candidate);
        /*candidateDbStore.create(candidate);*/
    }

    public Candidate findById(int id) {
        return repository.findById(id).get();
        /*return candidateDbStore.findById(id);*/
    }

    public void update(Candidate candidate) {
        repository.update(
                candidate.getName(),
                candidate.getDescription(),
                LocalDateTime.now(),
                candidate.getPhoto(),
                candidate.getId()
                );
        /*candidateDbStore.update(candidate);*/
    }
}
