package ru.job4j.dream.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dream.model.User;
import ru.job4j.dream.persistence.UserDbStore;

import java.util.*;

@ThreadSafe
@Service
public class UserService {

    private final UserDbStore userDbStore;

    public UserService(UserDbStore userDbStore) {
        this.userDbStore = userDbStore;
    }

    public Collection<User> findAll() {
        return userDbStore.findAll();
    }

    public Optional<User> findUserByEmailAndPwd(String email, String password) {
        return userDbStore.findByEmailAndPwd(email, password);
    }

    public Optional<User> add(User user) {
        return userDbStore.add(user);
    }

    public void create(User user) {
        userDbStore.create(user);
    }

    public void update(User user) {
        userDbStore.update(user);
    }
}
