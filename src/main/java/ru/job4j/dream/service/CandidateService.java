package ru.job4j.dream.service;

import org.springframework.stereotype.Service;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.persistence.CandidateStore;

import java.util.Collection;

@Service
public class CandidateService {

    /*private static final CandidateService INST = new CandidateService();*/

    private final CandidateStore candidateStore;

    public CandidateService(CandidateStore candidateStore) {
        this.candidateStore = candidateStore;
    }

    public Collection<Candidate> findAll() {
        return candidateStore.findAll();
    }

    public void add(Candidate candidate) {
        candidateStore.add(candidate);
    }

    public Candidate findById(int id) {
        return candidateStore.findById(id);
    }

    public void create(Candidate candidate) {
        candidateStore.create(candidate);
    }

    public void update(Candidate candidate) {
        candidateStore.update(candidate);
    }
}
