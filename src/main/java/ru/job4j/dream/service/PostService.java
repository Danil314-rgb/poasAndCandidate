package ru.job4j.dream.service;

import org.springframework.stereotype.Service;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.persistence.PostStore;

import java.util.Collection;
import java.util.List;

@Service
public class PostService {

    private final PostStore postStore;
    private final CityService cityService;

    public PostService(PostStore postStore, CityService cityService) {
        this.postStore = postStore;
        this.cityService = cityService;
    }

    public Collection<Post> findAll() {
        //return postStore.findAll();
        /*Collection<Post> posts = postStore.findAll();
        posts.forEach(
                post -> post.setCity(
                        cityService.findById(post.getCity().getId())
                )
        );*/
        return postStore.findAll();
    }

    public void add(Post post) {
        postStore.add(post);
    }

    public Post findById(int id) {
        return postStore.findById(id);
    }

    public void create(Post post, String name) {
        postStore.create(post, name);
    }

    public void update(Post post) {
        postStore.update(post);
    }
}
