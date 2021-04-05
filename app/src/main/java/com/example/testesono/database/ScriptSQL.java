package com.example.testesono.database;

public class ScriptSQL {

    public static String getCreateTable(){
        StringBuilder sql = new StringBuilder();
        sql.append("    CREATE TABLE IF NOT EXISTS HISTORICO ( ");
        sql.append("        ID      INTEGER      PRIMARY KEY AUTOINCREMENT NOT NULL, ");
        sql.append("        NOME        VARCHAR (250) NOT NULL DEFAULT(''), ");
        sql.append("        RESULTADO   VARCHAR (3) NOT NULL DEFAULT(''), ");
        sql.append("        AVALIACAO   VARCHAR (300) NOT NULL DEFAULT('') ) ");

        return sql.toString();

    }
}
