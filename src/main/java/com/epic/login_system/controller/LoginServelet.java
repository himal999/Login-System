/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.epic.login_system.controller;

import com.epic.login_system.bo.LoginBo;
import com.epic.login_system.bo.LoginBoImpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author himal
 */
public class LoginServelet extends HttpServlet {

    private LoginBo login = new LoginBoImpl();
    private PrintWriter writer;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String state = login.isValid(req.getParameter("username"), req.getParameter("password"));

        if (state.equalsIgnoreCase("SUCCESS")) {

            writer = resp.getWriter();
            writer.print("Success Login !!!");
        } else if (state.equalsIgnoreCase("USERNAME_PASSWORD_INCORRECT")) {
            writer = resp.getWriter();
            writer.print("Please enter corrent username and password !!!");
        } else if (state.equalsIgnoreCase("USERNAME_INCORRECT")) {
            writer = resp.getWriter();
            writer.print("Please enter corrent username !!!");
        } else if (state.equalsIgnoreCase("PASSWORD_INCORRECT")) {
            writer = resp.getWriter();
            writer.print("Please enter corrent password !!!");
        } else if(state.equalsIgnoreCase("FAILD")) {
            writer = resp.getWriter();
            writer.print("faild to login !!!");
        }

    }
}
