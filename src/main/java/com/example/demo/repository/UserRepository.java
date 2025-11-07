package com.example.demo.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // INSERT using string concatenation
    public int save(User user) {
        String sql = "INSERT INTO user_details (name, email, password, phone_number) VALUES ('"
                + user.getName() + "', '"
                + user.getEmail() + "', '"
                + user.getPassword() + "', '"
                + user.getPhoneNumber() + "')";
        return jdbcTemplate.update(sql);
    }

    // SELECT ALL
    public List<User> findAll() {
        String sql = "SELECT id, name, email, password, phone_number AS phoneNumber " +
                     "FROM user_details";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    // UPDATE using string concatenation
    public int update(User user) {
        String sql = "UPDATE user_details SET "
                + "name = '" + user.getName() + "', "
                + "email = '" + user.getEmail() + "', "
                + "password = '" + user.getPassword() + "', "
                + "phone_number = '" + user.getPhoneNumber() + "' "
                + "WHERE id = " + user.getId();
        return jdbcTemplate.update(sql);
    }

    // DELETE using string concatenation
    public int delete(Long id) {
        String sql = "DELETE FROM user_details WHERE id = " + id;
        return jdbcTemplate.update(sql);
    }

    // Example: Find by name (to show concatenation with WHERE clause)
    public List<User> findByName(String name) {
        String sql = "SELECT id, name, email, password, phone_number AS phoneNumber "
                   + "FROM user_details WHERE name = '" + name + "'";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }
}
