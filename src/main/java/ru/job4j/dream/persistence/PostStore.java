package ru.job4j.dream.persistence;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/*
@ThreadSafe
@Repository
public class PostStore {

    private static final AtomicInteger ID = new AtomicInteger(4);

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private PostStore() {
        posts.put(1, new Post(1, "Junior Java Job", "Без опыта", new City(1, "Москва")));
        posts.put(2, new Post(2, "Middle Java Job", "Опыт 1 год", new City(2, "СПБ")));
        posts.put(3, new Post(3, "Senior Java Job", "Опыт 3 года", new City(3, "Екб")));
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public void add(Post post) {
        post.setId(ID.incrementAndGet());
        posts.put(post.getId(), post);
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public void create(Post post, String name) {
        post.setId(ID.incrementAndGet());
        post.setCity(new City(post.getCity().getId(), name));
        posts.put(post.getId(), new Post(
                post.getId(),
                post.getName(),
                post.getDescription(),
                post.getCity()
        ));
    }

    public void update(Post post) {
        posts.put(post.getId(), new Post(
                post.getId(),
                post.getName(),
                post.getDescription(),
                post.getCity()));
    }
}*/
