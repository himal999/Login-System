/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epic.login_system.bo;

import com.epic.login_system.dao.LogoutDao;
import com.epic.login_system.dao.LogoutDaoImpl;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author himal
 */
public class LogoutBoImpl implements LogoutBo {

    LogoutDao logoutDao = new LogoutDaoImpl();

    @Override
    public boolean isInfoUpdate(String userName) {
        System.out.println(userName);

        String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());

        if (logoutDao.LogoutInfoUpdate(userName, time)) {
            return true;
        }
        return false;
    }

}
