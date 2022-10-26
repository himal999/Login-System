/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.epic.login_system.bo;

import com.epic.login_system.dto.Login;

/**
 *
 * @author himal
 */
public interface LoginBo {
   Boolean isValid(String userName,String passowrd);
}
