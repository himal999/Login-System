/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.epic.login_system.controller;

import com.epic.login_system.bo.LoginBo;
import com.epic.login_system.bo.LoginBoImpl;
import com.epic.login_system.dto.Login;
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

    private LoginBo login = new LoginBoImpl();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (login.isValid(req.getParameter("username"), req.getParameter("password"))) {

            PrintWriter writer = resp.getWriter();
            writer.print("hello");
        }
    }
}
