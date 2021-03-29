package com.test.db;

import com.test.domain.User;
import com.test.helper.Row;
import com.test.helper.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLHandler {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SimpleJdbcInsert simpleJdbcInsert;

    private List<Row> executeQuery(String query) {
        return jdbcTemplate.query(query, new CustomRowMapper());
    }

    public boolean verifyUser(String username, String password) {
        String tableName = "";
        String query = "SELECT * FROM " + tableName + " WHERE Email = '" + username + "'";
        User user = jdbcTemplate.query(query, new UserExtractor());
        assert user != null;
        return user.getPass().equalsIgnoreCase(password);
    }

    public int createUser(String username, String password) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("Email", username);
        parameters.put("Password", password);
        String tableName = "";
        return simpleJdbcInsert.withTableName(tableName).execute(parameters);
    }

    public List<Row> getTables(String query) {
        return executeQuery(query);
    }

    public Table getTable(String query) {
        return new Table(executeQuery(query));
    }

}
