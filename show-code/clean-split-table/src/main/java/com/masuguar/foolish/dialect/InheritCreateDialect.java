package com.masuguar.foolish.dialect;

public enum  InheritCreateDialect {
    POSTGRESSQL(" create table ${inheritTable}() inherits ( ${mainTable}) ")
            ;

    private String createTableStatement;

    InheritCreateDialect(String createTableStatement) {
        this.createTableStatement = createTableStatement;
    }

    public String getCreateTableStatement() {
        return createTableStatement;
    }
}
