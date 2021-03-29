package com.test.db;

import com.test.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserExtractor implements ResultSetExtractor<User> {
    @Override
    public User extractData(ResultSet rs) throws SQLException, DataAccessException {
        if (rs.next()) {
            String email = rs.getString("Email");
            String password = rs.getString("Password");
            return new User(password, email);
        } else {
            return null;
        }
    }
}
