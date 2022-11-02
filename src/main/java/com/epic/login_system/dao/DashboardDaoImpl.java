/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epic.login_system.dao;

import com.epic.login_system.db.DbConnector;
import com.epic.login_system.dto.UserDto;
import com.epic.login_system.entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author himal
 */
public class DashboardDaoImpl implements DashboardDao {

    private User user;

    @Override
    public User getAllData(String userName) {
        try {
            Connection connection = DbConnector.getInstance().getConnection();
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM `user_detail` WHERE username=?");
            pst.setString(1, userName);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                user = new User(rst.getString("username"), rst.getString("password"), rst.getString("fname"), rst.getString("lname"), rst.getString("nic"), rst.getString("address"), rst.getDate("dob"), rst.getString("email"));
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DashboardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DashboardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DashboardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DashboardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }

    @Override
    public boolean updateUserDetail(UserDto user, String userName) {

      

        User tempUser = new User(user.getUsername(), user.getPassword(), user.getFname(), user.getLname(), user.getNic(), user.getAddress(), user.getDob(), user.getEmail());

        try {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dob = formatter.format(tempUser.getDob());
            Connection connection = DbConnector.getInstance().getConnection();
            PreparedStatement pst = connection.prepareStatement("UPDATE `user_detail` SET username=?,password=?,fname=?,lname=?,nic=?,address=?,dob=?,email=? WHERE username=?");
            pst.setString(1, tempUser.getUsername());
            pst.setString(2, tempUser.getPassword());
            pst.setString(3, tempUser.getFname());
            pst.setString(4, tempUser.getLname());
            pst.setString(5, tempUser.getNic());

            pst.setString(6, tempUser.getAddress());

            pst.setDate(7, Date.valueOf(dob));

            pst.setString(8, tempUser.getEmail());
            pst.setString(9, userName);

            if (pst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DashboardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DashboardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DashboardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DashboardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteUser(String userName) {

        try {
            Connection connection = DbConnector.getInstance().getConnection();
            PreparedStatement pst = connection.prepareStatement("DELETE FROM `user_detail` WHERE username = ?");
            pst.setObject(1, userName);
            if (pst.executeUpdate() > 0) {
                return true;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DashboardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DashboardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DashboardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DashboardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    @Override
    public boolean addUser(UserDto user) {
         User tempUser = new User(user.getUsername(), user.getPassword(), user.getFname(), user.getLname(), user.getNic(), user.getAddress(), user.getDob(), user.getEmail());

        try {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dob = formatter.format(tempUser.getDob());
            Connection connection = DbConnector.getInstance().getConnection();
            PreparedStatement pst = connection.prepareStatement("INSERT INTO `user_detail` VALUES (?,?,?,?,?,?,?,?)");
            pst.setString(1, tempUser.getUsername());
            pst.setString(2, tempUser.getPassword());
            pst.setString(3, tempUser.getFname());
            pst.setString(4, tempUser.getLname());
            pst.setString(5, tempUser.getNic());

            pst.setString(6, tempUser.getAddress());

            pst.setDate(7, Date.valueOf(dob));

            pst.setString(8, tempUser.getEmail());
          

            if (pst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DashboardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DashboardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DashboardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DashboardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
