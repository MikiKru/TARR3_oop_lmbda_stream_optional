package com.company.controller;

import com.company.data.UserData;
import com.company.model.User;

import java.util.Optional;

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
    public Optional<User> getUserByEmail(String searchEmail){
        return UserData.users                                       // List<User>
                .stream()                                           // Stream<User>
                .filter(user -> user.getEmail().equals(searchEmail))// Stream<User>
                .findFirst();                                       // Optional<User>
    }
    public String getUserByEmailWithValidation(String searchEmail){
        Optional<User> userOpt = getUserByEmail(searchEmail);
        return userOpt.map(user -> "Znalezieono użytkownika: " + user.toString())
                .orElseGet(() -> "Nie znaleziono użytkownika o adresie: " + searchEmail);
    }
}
