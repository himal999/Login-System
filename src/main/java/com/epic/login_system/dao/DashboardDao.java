/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.epic.login_system.dao;

import com.epic.login_system.dto.UserDto;
import com.epic.login_system.entity.User;

/**
 *
 * @author himal
 */
public interface DashboardDao {
  boolean addUser(UserDto user);
  User getAllData(String userName);  
  boolean updateUserDetail(UserDto user,String userName,String time);
  boolean deleteUser(String userName);
}
