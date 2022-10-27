/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epic.login_system.controller;

import java.io.IOException;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author himal
 */
public class LogoutServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      
        HttpSession session = req.getSession();
        session.removeAttribute("username");
        session.invalidate();
        resp.sendRedirect("index.jsp");
        
      
    }
    
}
   
