package com.test.db;

import com.test.helper.Row;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CustomRowMapper implements RowMapper<Row> {

    @Override
    public Row mapRow(ResultSet rs, int rowNum) throws SQLException {
        Map<String, String> rowData = new HashMap<>();
        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
            rowData.put(rs.getMetaData().getColumnLabel(i), rs.getString(i));
        }
        return new Row(rowData);
    }
}