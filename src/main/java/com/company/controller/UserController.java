package com.company.controller;

import com.company.data.UserData;
import com.company.model.Role;
import com.company.model.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<User> getAllUsersWithStatus(boolean status){
        return UserData.users
                .stream()
                .filter(user -> user.isStatus() == status)
                .collect(Collectors.toList());
    }
    public void updateUserStatusById(int userId, boolean status){
        UserData.users
                .stream()
                .filter(user -> user.getUserId() == userId)
                .forEach(user -> user.setStatus(status));
    }
    public boolean updateUserRoleById(int userId, Role role){
        // sprawdzamy czy jest użytkownik o podany id
        Optional<User> userOpt = UserData.users.stream().filter(user -> user.getUserId() == userId).findFirst();
        if(userOpt.isPresent()){
            // userOpt          -> Optional<User>
            // userOpt.get()    -> User
            User user = userOpt.get();
            user.setRole(role);
            return true;
        }
        return false;
    }
    public int countActiveUsers(){
        return 0;
    }
    private int countAdmins(){
        return 0;
    }
}
