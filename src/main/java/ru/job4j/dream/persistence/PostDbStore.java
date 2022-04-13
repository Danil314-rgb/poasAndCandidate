package ru.job4j.dream.persistence;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Repository;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*@Repository
public class PostDbStore {

    private final BasicDataSource pool;

    public PostDbStore(BasicDataSource pool) {
        this.pool = pool;
    }

    public List<Post> findAll() {
        List<Post> posts = new ArrayList<>();
        try (Connection cn = pool.getConnection();
             PreparedStatement statement = cn.prepareStatement(
                     "SELECT p.id, p.name, p.description, c.name AS city_name FROM posts AS p "
                             + "JOIN cities c ON c.id = p.city_id "
                             + "ORDER BY p.id"
             )) {
            try (ResultSet res = statement.executeQuery()) {
                while (res.next()) {
                    posts.add(new Post(
                            res.getInt("id"),
                            res.getString("name"),
                            res.getString("description"),
                            new City(res.getString("city_name"))
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }

    public Post create(Post post) {
        try (Connection cn = pool.getConnection();
             PreparedStatement statement = cn.prepareStatement(
                     "INSERT INTO posts (name, description, city_id)" +
                             " VALUES (?, ?, ?)",
                     PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, post.getName());
            statement.setString(2, post.getDescription());
            statement.setInt(3, post.getCity().getId());
            statement.execute();
            try (ResultSet id = statement.getGeneratedKeys()) {
                if (id.next()) {
                    post.setId(id.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return post;
    }

    public void update(Post post) {
        try (Connection cn = pool.getConnection();
             PreparedStatement statement =
                     cn.prepareStatement(
                             "UPDATE posts " +
                                     "SET name = ?, description = ?, city_id = ? " +
                                     "where id = ?"
                     )) {
            statement.setString(1, post.getName());
            statement.setString(2, post.getDescription());
            statement.setInt(3, post.getCity().getId());
            statement.setInt(4, post.getId());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Post findById(int id) {
        try (Connection cn = pool.getConnection();
             PreparedStatement statement = cn.prepareStatement(
                     "SELECT p.id, p.name, p.description, c.name AS city_name FROM posts AS p "
                             + "JOIN cities c ON c.id = p.city_id "
                             + "WHERE p.id = ?")
        ) {
            statement.setInt(1, id);
            try (ResultSet it = statement.executeQuery()) {
                if (it.next()) {
                    return new Post(
                            it.getInt("id"),
                            it.getString("name"),
                            it.getString("description"),
                            new City(it.getString("city_name"))
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}*/
