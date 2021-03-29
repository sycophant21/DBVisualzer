package com.test.helper;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("static")
public class TableHeaders {
    private List<String> accessibleTables;
    private List<String> allTables;
    private String userId;

    public TableHeaders(List<String> accessibleTables, List<String> allTables, String userId) {
        this.accessibleTables = accessibleTables;
        this.allTables = allTables;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getAccessibleTables() {
        return accessibleTables;
    }

    public void setAccessibleTables(List<String> tableNames) {
        this.accessibleTables = tableNames;
    }

    public List<String> getAllTables() {
        return allTables;
    }

    public void setAllTables(List<String> tableNames) {
        this.allTables = tableNames;
    }
}
