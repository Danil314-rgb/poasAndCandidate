package ru.job4j.dream.persistence;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Repository;
import ru.job4j.dream.model.Candidate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*@Repository
public class CandidateDbStore {

    private final BasicDataSource pool;

    public CandidateDbStore(BasicDataSource pool) {
        this.pool = pool;
    }

    public List<Candidate> findAll() {
        List<Candidate> candidates = new ArrayList<>();
        try (Connection cn = pool.getConnection();
             PreparedStatement statement = cn.prepareStatement(
                     "select * from candidates"
             )) {
            try (ResultSet res = statement.executeQuery()) {
                while (res.next()) {
                    candidates.add(new Candidate(
                            res.getInt("id"),
                            res.getString("name"),
                            res.getString("description"),
                            res.getTimestamp("created").toLocalDateTime(),
                            res.getBytes("photo")
                    ));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return candidates;
    }

    public Candidate create(Candidate candidate) {
        try (Connection cn = pool.getConnection();
             PreparedStatement statement = cn.prepareStatement(
                     "INSERT INTO candidates (name, description, created, photo)" +
                             " VALUES (?, ?, ?, ?)",
                     PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, candidate.getName());
            statement.setString(2, candidate.getDescription());
            statement.setTimestamp(3, Timestamp.valueOf(candidate.getCreated()));
            statement.setBytes(4, candidate.getPhoto());
            statement.execute();
            try (ResultSet id = statement.getGeneratedKeys()) {
                if (id.next()) {
                    candidate.setId(id.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return candidate;
    }

    public void update(Candidate candidate) {
        try (Connection cn = pool.getConnection();
             PreparedStatement statement =
                     cn.prepareStatement(
                             "UPDATE candidates" +
                                     " SET name = ?, description = ?, created = ?, photo = ? " +
                                     "where id = ?"
                     )) {
            statement.setString(1, candidate.getName());
            statement.setString(2, candidate.getDescription());
            statement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            statement.setBytes(4, candidate.getPhoto());
            statement.setInt(5, candidate.getId());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Candidate findById(int id) {
        try (Connection cn = pool.getConnection();
             PreparedStatement statement = cn.prepareStatement(
                     "SELECT * FROM candidates AS c WHERE c.id = ?")
        ) {
            statement.setInt(1, id);
            try (ResultSet it = statement.executeQuery()) {
                if (it.next()) {
                    return new Candidate(
                            it.getInt("id"),
                            it.getString("name"),
                            it.getString("description"),
                            it.getTimestamp("created").toLocalDateTime(),
                            it.getBytes("photo"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}*/
