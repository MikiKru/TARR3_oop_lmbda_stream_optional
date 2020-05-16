package com.company;

import com.company.controller.UserController;
import com.company.model.Role;
import com.company.model.User;

public class Main {

    public static void main(String[] args) {
        UserController uc = new UserController();
        uc.getAllUsers();
        System.out.println(uc.getUserByEmailWithValidation("ak@ak.pl"));
        System.out.println(uc.getUserByEmailWithValidation("xx@xx.pl"));
    }
}
