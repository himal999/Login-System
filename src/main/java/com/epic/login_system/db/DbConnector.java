/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epic.login_system.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author himal
 */
public class DbConnector {

    private DbConnector dbConnector;
    private Connection connection;

    private DbConnector() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc://localhost:3306/loginDb", "root", "");
    }

    public DbConnector getInstance() throws ClassNotFoundException, SQLException {
        return dbConnector == null ? dbConnector = new DbConnector() : dbConnector;
    }

    public Connection getConnection() {
        return connection;
    }
}
