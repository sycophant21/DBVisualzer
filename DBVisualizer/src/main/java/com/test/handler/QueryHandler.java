package com.test.handler;

import com.test.db.QueryBuilder;
import com.test.db.SQLHandler;
import com.test.helper.Row;
import com.test.helper.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QueryHandler {
    @Autowired
    private SQLHandler sqlHandler;
    @Autowired
    private QueryBuilder queryBuilder;

    public void insertUser(String username, String password) {
        sqlHandler.createUser(username, password);
    }

    public boolean verifyUser(String email, String password) {
        return sqlHandler.verifyUser(email, password);
    }

    public Table getTableInfo(String query) {
        return sqlHandler.getTable(query);
    }

    public Table getUsers() {
        String tableName = "";
        return new Table(sqlHandler.getTables(queryBuilder.select("DISTINCT Email").from(tableName).where("`INSERT` = false AND `READ` = false AND `UPDATE` = false AND `DELETE` = false").generateQuery()));
    }

    public List<String> getTableNames(String userId) {
        String tableName = "";
        List<Row> rows = sqlHandler.getTables(queryBuilder.select("TableName").from(tableName).where("Email = '" + userId + "'").generateQuery());
        List<String> tableNames = new ArrayList<>();
        for (Row row : rows) {
            tableNames.add(row.getValues().get(0));
        }
        return tableNames;
    }

    public List<String> getAllTables() {
        String dbName = "";
        List<Row> rows = sqlHandler.getTables(queryBuilder.select("TABLE_NAME").from("INFORMATION_SCHEMA.TABLES").where("TABLE_SCHEMA = '" + dbName + "'").generateQuery());
        List<String> tableNames = new ArrayList<>();
        for (Row row : rows) {
            tableNames.add(row.getValues().get(0));
        }
        return tableNames;
    }
}
