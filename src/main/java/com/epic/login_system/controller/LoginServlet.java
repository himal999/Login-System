/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.epic.login_system.controller;

import com.epic.login_system.bo.DashboardBo;
import com.epic.login_system.bo.DashboardBoImpl;
import com.epic.login_system.bo.LoginBo;
import com.epic.login_system.bo.LoginBoImpl;
import com.epic.login_system.dto.UserDto;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author himal
 */
public class LoginServlet extends HttpServlet {

    private LoginBo login = new LoginBoImpl();
    private PrintWriter writer;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        writer = resp.getWriter();
        String type = req.getParameter("type");
        if (type.equalsIgnoreCase("username")) {
            if (login.isRegisterUser(req.getParameter("username"))) {

                writer.print("true");
            } else {
                writer.print("false");
            }
        } else if (type.equalsIgnoreCase("nic")) {

            if (login.isAlredyNic(req.getParameter("nic"))) {

                writer.print("true");
            } else {
                writer.print("false");
            }

        } else if (type.equalsIgnoreCase("email")) {

            if (login.isAlreadyEmail(req.getParameter("email"))) {

                writer.print("true");
            } else {
                writer.print("false");
            }
        } else {

            if (!login.isCheckAlredyUserName(req.getParameter("username"))) {
                writer.print("true");
            } else {
                writer.print("false");
            }
        }

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
      

        String state = login.isValid(req.getParameter("username"), req.getParameter("password"));

        if (state.equalsIgnoreCase("SUCCESS")) {

            HttpSession session = req.getSession();

            session.setAttribute("username", req.getParameter("username"));

            DashboardBo bo = new DashboardBoImpl();
            UserDto userData = bo.getUserData(req.getParameter("username"));

            session.setAttribute("user", userData);

            writer = resp.getWriter();
            writer.print("SUCCESS");

        } else if (state.equalsIgnoreCase("USERNAME_OR_PASSWORD_INCORRECT")) {
            writer = resp.getWriter();
            writer.print("USERNAME_OR_PASSWORD_INCORRECT");
        }

    }
}
