package com.masuguar.foolish.dialect;

public enum InheritDialect {

    POSTGRESSQL("select count(*) userId from pg_class where relname =#{}")
    ;

    private String queryTableStatement;

    InheritDialect(String queryTableStatement) {
        this.queryTableStatement = queryTableStatement;
    }

    public String getQueryTableStatement() {
        return queryTableStatement;
    }
}
