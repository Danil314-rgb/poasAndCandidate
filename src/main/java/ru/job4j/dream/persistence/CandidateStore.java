package ru.job4j.dream.persistence;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.dream.model.Candidate;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/*@ThreadSafe
@Repository
public class CandidateStore {

    private static final AtomicInteger ID = new AtomicInteger(4);
    private static final CandidateStore INST = new CandidateStore();

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private CandidateStore() {
        candidates.put(1, new Candidate(1, "Java Junior", "Без опыта", LocalDateTime.now(), new byte[0]));
        candidates.put(2, new Candidate(2, "Java Middle", "Опты от года", LocalDateTime.now(), new byte[0]));
        candidates.put(3, new Candidate(3, "Java Senior", "Опыт от 3 лет", LocalDateTime.now(), new byte[0]));
    }

    public static CandidateStore instOf() {
        return INST;
    }

    public Collection<Candidate> findAll() {
        return candidates.values();
    }

    public void add(Candidate candidate) {
        candidate.setId(ID.incrementAndGet());
        candidates.put(candidate.getId(), candidate);
    }

    public Candidate findById(int id) {
        return candidates.get(id);
    }

    public void create(Candidate candidate) {
        candidate.setId(ID.incrementAndGet());
        candidates.put(candidate.getId(), new Candidate(
                candidate.getId(),
                candidate.getName(),
                candidate.getDescription(),
                LocalDateTime.now(),
                candidate.getPhoto()
        ));
    }

    public void update(Candidate candidate) {
        candidates.put(candidate.getId(), new Candidate(
                candidate.getId(),
                candidate.getName(),
                candidate.getDescription(),
                LocalDateTime.now(),
                candidate.getPhoto()
        ));
    }
}*/
