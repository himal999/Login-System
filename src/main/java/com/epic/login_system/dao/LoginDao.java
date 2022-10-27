/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.epic.login_system.dao;


import com.epic.login_system.entity.Login;
import java.util.List;

/**
 *
 * @author himal
 */
public interface LoginDao {
   List<Login> getUsernamePassword();
}
