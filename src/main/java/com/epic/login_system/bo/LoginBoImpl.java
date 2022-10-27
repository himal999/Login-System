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

    private LoginDto login;

    private LoginDao loginDao = new LoginDaoImpl();

    private List<LoginDto> dtoUsers = new ArrayList();

    @Override
    public String isValid(String userName, String password) {

        try {

            List<Login> users = loginDao.getUsernamePassword();

            if (!users.isEmpty()) {

                for (Login tempUser : users) {
                    dtoUsers.add(new LoginDto(tempUser.getUserName(), tempUser.getPassword()));
                }

                for (LoginDto tempDto : dtoUsers) {
                    if (tempDto.getUserName().equals(userName) && tempDto.getPassword().equals(password)) {
                        return "SUCCESS";
                    } else if (!tempDto.getUserName().equals(userName) && !tempDto.getPassword().equals(password)) {
                        return "USERNAME_PASSWORD_INCORRECT";
                    } else if (!tempDto.getUserName().equals(userName)) {
                        return "USERNAME_INCORRECT";
                    } else if (!tempDto.getPassword().equals(password)) {
                        return "PASSWORD_INCORRECT";
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("can't load user" + " " + e.getMessage());
        }
        return "FAILD";

    }

}
