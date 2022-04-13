package ru.job4j.dream.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.persistence.PostRepository;

import java.util.*;

@ThreadSafe
@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Collection<Post> findAll() {
        List<Post> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public Post findById(int id) {
        return repository.findById(id).get();
    }

    public void create(Post post) {
        repository.save(post);
    }

    public void update(Post post) {
        repository.updates(
                post.getName(),
                post.getDescription(),
                post.getCity().getId(),
                post.getId()
        );
    }
}
