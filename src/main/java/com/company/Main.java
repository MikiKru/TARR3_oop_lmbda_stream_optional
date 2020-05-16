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
        uc.updateUserStatusById(1, false);
        uc.updateUserStatusById(4, false);
        System.out.println("Aktywni użytkownicy");
        uc.getAllUsersWithStatus(true).forEach(System.out::println);

    }
}
