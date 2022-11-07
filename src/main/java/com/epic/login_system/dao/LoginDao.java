/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.epic.login_system.dao;


import com.epic.login_system.entity.Login;
import com.epic.login_system.entity.User;
import java.util.List;

/**
 *
 * @author himal
 */
public interface LoginDao {
   List<Login> getUsernamePassword();
   List<User> getAllUser();
   boolean updateLoginInfo(String userName,String time);
}
