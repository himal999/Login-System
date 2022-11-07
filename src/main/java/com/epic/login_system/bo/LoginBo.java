/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.epic.login_system.bo;



/**
 *
 * @author himal
 */
public interface LoginBo {
   String isValid(String userName,String passowrd);
   boolean isCheckAlredyUserName(String username);
   boolean isRegisterUser(String userName);
   boolean isAlredyNic(String nic);
   boolean isAlreadyEmail(String email);
}
