/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epic.login_system.controller;

import com.epic.login_system.bo.LogoutBo;
import com.epic.login_system.bo.LogoutBoImpl;
import java.io.IOException;
import java.io.PrintWriter;
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
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        LogoutBo logout = new LogoutBoImpl();
        HttpSession session = req.getSession();

        PrintWriter writer = resp.getWriter();

       
        if (logout.isInfoUpdate(String.valueOf(session.getAttribute("username")))) {
            session.removeAttribute("username");
            session.invalidate();
            writer.print("true");
        } else {
            writer.print("false");
        }
    }

}
