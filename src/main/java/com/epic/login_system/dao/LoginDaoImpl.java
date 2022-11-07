package com.epic.login_system.dao;

import com.epic.login_system.dao.LoginDao;
import com.epic.login_system.db.DbConnector;
import com.epic.login_system.dto.LoginDto;
import com.epic.login_system.dto.UserDto;
import com.epic.login_system.entity.Login;
import com.epic.login_system.entity.User;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDaoImpl implements LoginDao {

    private ArrayList<Login> users = new ArrayList();

    @Override
    public List<Login> getUsernamePassword() {

        try {

            Connection connection = DbConnector.getInstance().getConnection();

            PreparedStatement pst = connection.prepareStatement("SELECT username,password FROM `user_detail`");

            ResultSet rst = pst.executeQuery();

            while (rst.next()) {

                Blob by = rst.getBlob("password");
                byte[] bytes = by.getBytes(1, (int) by.length());
                users.add(new Login(rst.getString("username"), new String(bytes)));

            }

        } catch (SQLException ex) {
            System.out.println("Can't load data" + " " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(LoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;
    }

    @Override
    public List<User> getAllUser() {

        List<User> users = new ArrayList();

        try {
            Connection connection = DbConnector.getInstance().getConnection();

            PreparedStatement pst = connection.prepareStatement("SELECT * FROM `user_detail`");

            ResultSet rst = pst.executeQuery();

            while (rst.next()) {
                Blob by = rst.getBlob("password");
                byte[] bytes = by.getBytes(1, (int) by.length());

                users.add(new User(rst.getString("username"), new String(bytes), rst.getString("fname"), rst.getString("lname"), rst.getString("nic"), rst.getString("address"), rst.getDate("dob"), rst.getString("email")));

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(LoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public boolean updateLoginInfo(String userName, String time) {

        try {

            Connection connection = DbConnector.getInstance().getConnection();

            PreparedStatement pst = connection.prepareStatement("UPDATE `user_detail` SET acc_last_login=? WHERE username=?");
            pst.setObject(1, time);
            pst.setObject(2, userName);

            if (pst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(LoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
