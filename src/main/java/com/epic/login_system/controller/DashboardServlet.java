/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epic.login_system.controller;

import com.epic.login_system.bo.DashboardBo;
import com.epic.login_system.bo.DashboardBoImpl;
import com.epic.login_system.dto.UserDto;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author himal
 */
public class DashboardServlet extends HttpServlet {

    //update user
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("username");

        if (userName == null) {
            try {
              
                String date = req.getParameter("dob");
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date tempDate = formatter.parse(date);
                DashboardBo dashboardImpl = new DashboardBoImpl();

                boolean isAdded = dashboardImpl.createUser(new UserDto(req.getParameter("username"), req.getParameter("password"), req.getParameter("firstname"), req.getParameter("lastname"), req.getParameter("nic"), req.getParameter("address"), tempDate, req.getParameter("email")));
                PrintWriter writer = resp.getWriter();
                if (isAdded) {
                    DashboardBo bo = new DashboardBoImpl();
                    UserDto userData = bo.getUserData(req.getParameter("username"));

                    HttpSession sess = req.getSession(true);
                    sess.putValue("username", req.getParameter("username"));
                    sess.putValue("user", userData);

                    writer.print("true");

                } else {
                    writer.print("false");
                }

            } catch (ParseException ex) {
                Logger.getLogger(DashboardServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            try {

                String date = req.getParameter("dob");
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date tempDate = formatter.parse(date);
                DashboardBo dashboardImpl = new DashboardBoImpl();

                boolean isUpdate = dashboardImpl.updateUserDetail(new UserDto(req.getParameter("username"), req.getParameter("firstname"), req.getParameter("lastname"), req.getParameter("nic"), req.getParameter("address"), tempDate, req.getParameter("email")), userName);
                PrintWriter writer = resp.getWriter();
                if (isUpdate) {
                    DashboardBo bo = new DashboardBoImpl();
                    UserDto userData = bo.getUserData(req.getParameter("username"));

                    HttpSession sess = req.getSession(true);
                    sess.putValue("username", req.getParameter("username"));
                    sess.putValue("user", userData);
                   
                    writer.print("true");
                }
                
                else{
                       
                    writer.print("false");
                }

            } catch (ParseException ex) {
                Logger.getLogger(DashboardServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    //delete user
    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("username");
        DashboardBo dashboardImpl = new DashboardBoImpl();
        PrintWriter writer = resp.getWriter();
        if (dashboardImpl.isDeleteUser(userName)) {
            session.removeAttribute("username");
            session.invalidate();
             writer.print("true");
        } else {
            writer.print("TRY_AGAIN_DELETED");
        }
    }

}
