package ru.job4j.dream.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dream.model.User;
import ru.job4j.dream.persistence.UserRepository;

import java.util.*;


@ThreadSafe
@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User findUserByEmailAndPwd(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    public void create(User user) {
        repository.save(user);
    }

    public Collection<User> findAll() {
        List<User> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }
}
