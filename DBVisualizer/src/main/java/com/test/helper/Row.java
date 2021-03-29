package com.test.helper;

import java.util.*;

public class Row {
    private final Map<String, String> rowData;
    private final List<String> values;
    private final Set<String> keys;

    public Row(Map<String, String> rowData) {
        this.rowData = rowData;
        values = new ArrayList<>(rowData.values());
        keys = new HashSet<>(rowData.keySet());
    }

    public String getColumnName(String value) {
        if (rowData.containsValue(value)) {
            for (String columnName : rowData.keySet()) {
                if (rowData.get(columnName).equals(value)) {
                    return columnName;
                }
            }
        }
        return null;
    }

    public Set<String> getKeys() {
        return keys;
    }

    public List<String> getValues() {
        return values;
    }

    public String getRowValue(String columnName) {
        return rowData.get(columnName);
    }

    public String addColumn(String columnName, String value) {
        return rowData.put(columnName, value);
    }
}
