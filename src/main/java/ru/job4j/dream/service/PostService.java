package ru.job4j.dream.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.persistence.PostDbStore;

import java.util.Collection;

@ThreadSafe
@Service
public class PostService {

    private final PostDbStore postDbStore;

    public PostService(PostDbStore postDbStore) {
        this.postDbStore = postDbStore;
    }

    public Collection<Post> findAll() {
        return postDbStore.findAll();
    }

    public Post findById(int id) {
        return postDbStore.findById(id);
    }

    public void create(Post post) {
        postDbStore.create(post);
    }

    public void update(Post post) {
        postDbStore.update(post);
    }
}
