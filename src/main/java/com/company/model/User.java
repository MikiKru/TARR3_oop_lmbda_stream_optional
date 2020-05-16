package com.company.model;

import java.time.LocalDateTime;

// Klasa modelu -> determinuje strukturę danych w projekcie
public class User {
    // prywatne pola klasowe ->
    private String name;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime registrationDate = LocalDateTime.now();
    private boolean status = true;
    // przypisanie uprawnień
    private Role role = Role.ROLE_USER;
}
