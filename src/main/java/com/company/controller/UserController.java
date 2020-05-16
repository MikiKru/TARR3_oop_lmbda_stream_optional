package com.company.controller;

import com.company.data.UserData;
import com.company.model.User;

// Klasa kontrolra implementuje metody obsługujące żądania
public class UserController {
    public void getAllUsers(){
//        for (User user : UserData.users) {
//            System.out.println(user);
//        }
        // tworzenie predykatu CTRL + Space
//        UserData.users                                      // List<User>
//                .stream()                                   // Stream<User>
//                .forEach(user -> System.out.println(user)); // operacja kończąca void
        // wersja uproszczona
        UserData.users.forEach(System.out::println);
    }
    public User getUserById(int userId){
        return ???
    }
}
