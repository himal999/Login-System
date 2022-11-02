package com.epic.login_system.bo;

import com.epic.login_system.dao.LoginDao;
import com.epic.login_system.dao.LoginDaoImpl;

import com.epic.login_system.dto.LoginDto;
import com.epic.login_system.entity.Login;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author himal
 */
public class LoginBoImpl implements LoginBo {

    @Override
    public String isValid(String userName, String password) {

       final LoginDto tempDto = mathchUser(userName);

        if (tempDto != null) {
            if (tempDto.getUserName().equals(userName) && tempDto.getPassword().equals(password)) {
                return "SUCCESS";
            } else if (!tempDto.getPassword().equals(password)) {
                return "PASSWORD_INCORRECT";
            }

        } else {

            return "USERNAME_INCORRECT";

        }

        return "FAILD";

    }

    @Override
    public boolean isCheckAlredyUserName(String userName) {

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

}
