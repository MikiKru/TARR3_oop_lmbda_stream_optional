package com.company.pizza.controller;

import com.company.pizza.model.Ingredient;
import com.company.pizza.model.Pizza;

import java.util.Arrays;
import java.util.Comparator;

// klasa kontrolera -> obsługa żądań i implementacja logiki biznesowej
public class PizzaController {
    // Wyszukaj i zwróć najtańszą pizze ostrą
    public Pizza findCheapestSpicy(){
        return null;
    }
    // Wyszukaj najtańszą pizze
    public Pizza findCheapest(){
        return Arrays.stream(Pizza.values())                                 // Stream<Pizza>
                .sorted(Comparator.comparing(pizza -> getPizzaPrice(pizza))) // Stream<Pizza>
                .limit(1)                                                    // Stream<Pizza>
                .findFirst()                                                 // Optional<Pizza>
                .get();                                                      // Pizza
    }
    // Metoda zwracająca cenę pizzy podanej w argumencie metody
    public double getPizzaPrice(Pizza pizza){
        return pizza.getIngredients()           // List<Ingerdeint>
                                .stream()       // Stream<Ingredient>
                                .mapToDouble(Ingredient::getPrice)   // Double
                                .sum();         // Double
    }

    public static void main(String[] args) {
        PizzaController pc = new PizzaController();
        System.out.println("Najtańsza pizza: " + pc.findCheapest());

//        System.out.println("Najtańsza pizza ostra to: " + pc.findCheapestSpicy());
    }
}
