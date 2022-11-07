package com.epic.login_system.bo;

import com.epic.login_system.dao.LoginDao;
import com.epic.login_system.dao.LoginDaoImpl;

import com.epic.login_system.dto.LoginDto;
import com.epic.login_system.dto.UserDto;
import com.epic.login_system.entity.Login;
import com.epic.login_system.entity.User;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author himal
 */
public class LoginBoImpl implements LoginBo {

    LoginDao loginDao = new LoginDaoImpl();

    @Override
    public String isValid(String userName, String password) {

        final LoginDto tempDto = mathchUser(userName);

        if (tempDto != null) {
            if (tempDto.getUserName().equals(userName) && tempDto.getPassword().equals(password)) {

                if(updateLoginInfo(userName)){
                   return "SUCCESS";
                }

             
            }

        }

        return "USERNAME_OR_PASSWORD_INCORRECT";

    }

    @Override
    public boolean isCheckAlredyUserName(String userName) {

        List<LoginDto> dtoUsers = new ArrayList();

        List<Login> users = loginDao.getUsernamePassword();

        if (!users.isEmpty()) {
            for (Login tempUser : users) {
                dtoUsers.add(new LoginDto(tempUser.getUserName(), tempUser.getPassword()));
            }

            for (LoginDto tempDto : dtoUsers) {
                if (tempDto.getUserName().equalsIgnoreCase(userName)) {

                    return true;
                }
            }
        }
        return false;
    }

    private LoginDto mathchUser(String userName) {

        LoginDao loginDao = new LoginDaoImpl();

        List<LoginDto> dtoUsers = new ArrayList();

        List<Login> users = loginDao.getUsernamePassword();

        if (!users.isEmpty()) {

            for (Login tempUser : users) {
                dtoUsers.add(new LoginDto(tempUser.getUserName(), tempUser.getPassword()));
            }
            for (LoginDto tempDto : dtoUsers) {
                if (tempDto.getUserName().equalsIgnoreCase(userName)) {
                    return tempDto;
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    @Override
    public boolean isRegisterUser(String userName) {
        LoginDao loginDao = new LoginDaoImpl();

        List<LoginDto> dtoUsers = new ArrayList();

        List<Login> users = loginDao.getUsernamePassword();

        if (!users.isEmpty()) {

            for (Login tempUser : users) {
                dtoUsers.add(new LoginDto(tempUser.getUserName(), tempUser.getPassword()));
            }
            for (LoginDto tempDto : dtoUsers) {
                if (tempDto.getUserName().equalsIgnoreCase(userName)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isAlredyNic(String nic) {
        LoginDao loginDao = new LoginDaoImpl();

        List<UserDto> dtoUsers = new ArrayList();

        List<User> users = loginDao.getAllUser();

        if (!users.isEmpty()) {

            for (User tempUser : users) {
                dtoUsers.add(new UserDto(tempUser.getUsername(), tempUser.getPassword(), tempUser.getFname(), tempUser.getLname(), tempUser.getNic(), tempUser.getAddress(), tempUser.getDob(), tempUser.getEmail()));
            }
            for (UserDto tempDto : dtoUsers) {
                if (tempDto.getNic().equalsIgnoreCase(nic)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isAlreadyEmail(String email) {
        LoginDao loginDao = new LoginDaoImpl();

        List<UserDto> dtoUsers = new ArrayList();

        List<User> users = loginDao.getAllUser();

        if (!users.isEmpty()) {

            for (User tempUser : users) {
                dtoUsers.add(new UserDto(tempUser.getUsername(), tempUser.getPassword(), tempUser.getFname(), tempUser.getLname(), tempUser.getNic(), tempUser.getAddress(), tempUser.getDob(), tempUser.getEmail()));
            }
            for (UserDto tempDto : dtoUsers) {
                if (tempDto.getEmail().equalsIgnoreCase(email)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean updateLoginInfo(String userName) {
        String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
        if (loginDao.updateLoginInfo(userName, time)) {
            return true;
        }
        return false;
    }

}
