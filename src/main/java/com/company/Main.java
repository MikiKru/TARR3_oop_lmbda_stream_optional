package com.company;

import com.company.model.Role;
import com.company.model.User;

public class Main {

    public static void main(String[] args) {
        User u1 = new User();
        User u2 = new User(
                "Michał",
                "Kruczkowski",
                "mk@mk.pl",
                "mk"
        );
        System.out.println(u1.toString());
        System.out.println(u2);
        // edycja roli użytkownika
        u2.setRole(Role.ROLE_ADMIN);
        System.out.println("Nowa rola: " + u2.getRole());
        System.out.println(u2);
    }
}
