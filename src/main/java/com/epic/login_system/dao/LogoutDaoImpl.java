/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epic.login_system.dao;

import com.epic.login_system.db.DbConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author himal
 */
public class LogoutDaoImpl implements LogoutDao {

    @Override
    public boolean LogoutInfoUpdate(String userName, String time) {
   try {

            Connection connection = DbConnector.getInstance().getConnection();

            PreparedStatement pst = connection.prepareStatement("UPDATE `user_detail` SET acc_last_logout=? WHERE username=?");
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
