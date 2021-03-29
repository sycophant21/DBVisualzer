package com.test.db;

public class QueryBuilder {
    private String SELECT;
    private String FROM;
    private String WHERE;
    private String ORDER_BY;
    private String LIMIT;
    private String GROUP_BY;

    public QueryBuilder(String SELECT, String FROM, String WHERE, String ORDER_BY, String LIMIT, String GROUP_BY) {
        select(SELECT).from(FROM).where(WHERE).limit(LIMIT).groupBy(GROUP_BY).orderBy(ORDER_BY);
    }

    public String generateQuery() {
        String query = SELECT + "\n" + FROM;
        if (WHERE.length() >= 7 && !WHERE.contains("null")) {
            query += "\n" + WHERE;
        }
        if (ORDER_BY.length() >= 10 && !ORDER_BY.contains("null")) {
            query += "\n" + ORDER_BY;
        }
        if (GROUP_BY.length() >= 10 && !GROUP_BY.contains("null")) {
            query += "\n" + GROUP_BY;
        }
        if (LIMIT.length() >= 7 && !LIMIT.contains("null")) {
            query += "\n" + LIMIT;
        }
/*        else {
            query += "\nLIMIT 10";
        }*/
        return query + ";";
    }

    public QueryBuilder groupBy(String groupBy) {
        this.GROUP_BY = "GROUP BY " + groupBy;
        return this;
    }

    public QueryBuilder limit(String limit) {
        this.LIMIT = "LIMIT " + limit;
        return this;
    }

    public QueryBuilder orderBy(String orderBy) {
        this.ORDER_BY = "ORDER BY " + orderBy;
        return this;
    }

    public QueryBuilder where(String where) {
        this.WHERE = "WHERE " + where;
        return this;
    }

    public QueryBuilder from(String from) {
        this.FROM = "FROM " + from;
        return this;
    }

    public QueryBuilder select(String select) {
        this.SELECT = "SELECT " + select;
        return this;
    }
}
