/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epic.login_system.dto;

import java.util.Date;

/**
 *
 * @author himal
 */
public class UserDto {
   private String username;
   private String password;
   private String fname;
   private String lname;
   private String nic;
   private String address;
   private Date dob;
   private String email;

    public UserDto() {
    }

    public UserDto(String username, String password, String fname, String lname, String nic, String address, Date dob, String email) {
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.nic = nic;
        this.address = address;
        this.dob = dob;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDto{" + "username=" + username + ", password=" + password + ", fname=" + fname + ", lname=" + lname + ", nic=" + nic + ", address=" + address + ", dob=" + dob + ", email=" + email + '}';
    }
    
    
}
