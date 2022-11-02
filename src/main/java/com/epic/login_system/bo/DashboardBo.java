/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.epic.login_system.bo;

import com.epic.login_system.dto.UserDto;


/**
 *
 * @author himal
 */
public interface DashboardBo {
    boolean createUser(UserDto user);
    UserDto getUserData(String userName);
    boolean updateUserDetail(UserDto user,String userName);
    boolean isDeleteUser(String userName);
}
