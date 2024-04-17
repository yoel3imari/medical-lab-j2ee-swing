package com.mycompany.medicallab;

import com.mycompany.medicallab.utils.JavaUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    // usage: Database.getInstance().getConnection()
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/medicallab";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Database instance;
    private Connection connection;

    private Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            JavaUtil.fireError(e);
        }
    }

    // Public method to get the singleton instance
    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    // Public method to get the database connection
    public Connection getConnection() {
        return connection;
    }
}
