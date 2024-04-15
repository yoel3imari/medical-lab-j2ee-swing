package com.mycompany.medicallab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Database {

    // usage: Database.getInstance().getConnection()
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/swinglab";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Database instance;
    private Connection connection;

    private Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    new JFrame("Connection Error"),
                    "Error: " + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (ClassNotFoundException nf) {
            nf.printStackTrace();
            JOptionPane.showMessageDialog(
                    new JFrame("Connection Error"),
                    "Error: " + nf.getMessage() + " Not Found",
                    "Driver Error",
                    JOptionPane.ERROR_MESSAGE
            );
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
