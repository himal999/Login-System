
package com.epic.login_system.entity;

/**
 *
 * @author himal
 */
public class Login {
     private String userName;
     private String password;

    public Login() {
    }

    
    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    @Override
    public String toString() {
        return "Login{" + "userName=" + userName + ", password=" + password + '}';
    }
}