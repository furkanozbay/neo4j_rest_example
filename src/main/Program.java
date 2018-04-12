package main;

import db.DbOperation;

public class Program {

    private static String url = "neo4j_db_url"; // example: https://example.dbs.graphenedb.com:24780/db/data/
    private static String userName = "neo4j_user_name"; // default: neo4j
    private static String password = "neo4j_password"; // default: neo4j

    public static void main(String[] args) {
        new DbOperation(url, userName, password).test();
    }
}
