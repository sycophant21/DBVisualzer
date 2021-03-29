package com.test.helper;

import java.util.List;

public class Table {
    private final List<Row> rows;

    public Table(List<Row> rows) {
        this.rows = rows;
    }

    public List<Row> getRows() {
        return rows;
    }
}
