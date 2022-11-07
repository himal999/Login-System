/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epic.login_system.bo;

import com.epic.login_system.dao.DashboardDao;
import com.epic.login_system.dao.DashboardDaoImpl;
import com.epic.login_system.dto.UserDto;
import com.epic.login_system.entity.User;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author himal
 */
public class DashboardBoImpl implements DashboardBo {

    private DashboardDao dashboardDao = new DashboardDaoImpl();
    private String key = "Bar12345Bar12345";

    @Override
    public UserDto getUserData(String userName) {
        User user = dashboardDao.getAllData(userName);
        return new UserDto(user.getUsername(), user.getPassword(), user.getFname(), user.getLname(), user.getNic(), user.getAddress(), user.getDob(), user.getEmail());
       
    }

    @Override
    public boolean updateUserDetail(UserDto user, String userName) {

           String time  = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());

            return dashboardDao.updateUserDetail(user, userName,time);

       

        
    }

    @Override
    public boolean isDeleteUser(String userName) {
        return dashboardDao.deleteUser(userName);
    }

    @Override
    public boolean createUser(UserDto user) {


            String time  = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
            return dashboardDao.addUser(new UserDto(user.getUsername(), user.getPassword(), user.getFname(), user.getLname(), user.getNic(), user.getAddress(), user.getDob(), user.getEmail(),time,time,time));


    }

}
