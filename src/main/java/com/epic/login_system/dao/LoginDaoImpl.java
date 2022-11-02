package com.epic.login_system.dao;

import com.epic.login_system.dao.LoginDao;
import com.epic.login_system.db.DbConnector;
import com.epic.login_system.dto.LoginDto;
import com.epic.login_system.entity.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

                users.add(new Login(rst.getString("username"), rst.getString("password")));

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

}
