package com.company;

import com.company.controller.UserController;
import com.company.model.Role;
import com.company.model.User;

import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        UserController uc = new UserController();
        uc.getAllUsers();
        System.out.println(uc.getUserByEmailWithValidation("ak@ak.pl"));
        System.out.println(uc.getUserByEmailWithValidation("xx@xx.pl"));
        uc.updateUserStatusById(1, false);
        uc.updateUserStatusById(4, false);
        System.out.println("Aktywni użytkownicy");
        uc.getAllUsersWithStatus(true).forEach(System.out::println);
        System.out.println(uc.updateUserRoleById(2, Role.ROLE_ADMIN));
        System.out.println(uc.updateUserRoleById(3, Role.ROLE_ADMIN));
        System.out.println(uc.updateUserRoleById(33, Role.ROLE_ADMIN));
        System.out.println("Liczba aktywnych: " + uc.countActiveUsers());
        System.out.println("Liczba administratorów: " + uc.countAdmins());
        uc.getAllUsersOrderByregistrationDateDesc().forEach(System.out::println);
        System.out.println("Administratorzy posortowani:");
        uc.getAllActiveAdminsOrderByEmailAsc().forEach(System.out::println);
        System.out.println("3 pierwszych użytkowników w aplikacji");
        uc.getFirst3UsersOrderByRegistrationDateAsc().forEach(System.out::println);
        uc.printAdmins();
    }
}
