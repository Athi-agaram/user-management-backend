package com.example.demo.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // INSERT
    public int save(User user) {
        String sql = "INSERT INTO user_details (name, email, password) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword());
    }

    // SELECT
    public List<User> findAll() {
        String sql = "SELECT * FROM user_details";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    // UPDATE
    public int update(User user) {
        String sql = "UPDATE user_details SET name=?, email=?, password=? WHERE id=?";
        return jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), user.getId());
    }

    // DELETE
    public int delete(Long id) {
        String sql = "DELETE FROM user_details WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }
}
