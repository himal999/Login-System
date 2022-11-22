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

    private static DbConnector dbConnector;
    private  Connection connection;

    private DbConnector() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
      
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginDb?autoReconnect=true", "root", "");
    }

    public static DbConnector getInstance() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return dbConnector == null ? dbConnector = new DbConnector() : dbConnector;
    }

    public Connection getConnection() {
        return connection;
    }
}
