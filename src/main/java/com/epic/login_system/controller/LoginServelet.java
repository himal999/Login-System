/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.epic.login_system.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author himal
 */
public class LoginServelet extends HttpServlet {

   private String userName;
   private String password;
    
   private LoginServelet loginServelet;
    
    private LoginServelet(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       
        loginServelet  = new LoginServelet(req.getParameter("username"),req.getParameter("password"));
        PrintWriter writer = resp.getWriter();
        writer.print(this.userName +" "+this.password);

     }
}
