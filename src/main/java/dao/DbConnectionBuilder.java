package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionBuilder {

    private static final String URL = "jdbc:postgresql://localhost:5432/librarydb";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "1234";

    public DbConnectionBuilder() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, LOGIN, PASSWORD);
    }
}