package br.com.danilo.application.repository;

import br.com.danilo.application.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by danilopereira on 13/11/17.
 */
@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll(){
        List<User> result = jdbcTemplate.query("SELECT id, name, email, age FROM user", (rs, rowNum)->new User(rs.getLong("id"),
                rs.getString("name"), rs.getString("email"), rs.getLong("age")));

        return result;
    }


    public void addUser(String name, String email, String age){
        jdbcTemplate.update("INSERT INTO user(name, email, age) VALUES(?,?,?)", name, email, age);
    }

}
