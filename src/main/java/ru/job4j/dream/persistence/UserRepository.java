package ru.job4j.dream.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.dream.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query
    User findByEmailAndPassword(String email, String password);
}
