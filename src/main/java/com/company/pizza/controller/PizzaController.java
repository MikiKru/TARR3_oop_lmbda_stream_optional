package com.company.pizza.controller;

import com.company.pizza.model.Ingredient;
import com.company.pizza.model.Pizza;

import java.util.Arrays;
import java.util.Comparator;

// klasa kontrolera -> obsługa żądań i implementacja logiki biznesowej
public class PizzaController {
    // Wyszukaj i zwróć najtańszą pizze ostrą
    public Pizza findCheapestSpicy() {
        return Arrays.stream(Pizza.values())                                    // Stream<Pizza>
                .filter(pizza -> pizza.getIngredients()
                        .stream()
                        .anyMatch(ingredient -> ingredient.isSpicy()))      // Stream<Pizza>
                .min(Comparator.comparing(this::getPizzaPrice))     // Stream<Pizza>                                            // Optional<Pizza>
                .get();
    }
    // Wyszukaj najtańszą pizze
    public Pizza findCheapest(){
        return Arrays.stream(Pizza.values())                        // Stream<Pizza>
                .min(Comparator.comparing(this::getPizzaPrice))     // Stream<Pizza>                                            // Optional<Pizza>
                .get();                                             // Pizza
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
        System.out.println("Najtańsza pizza ostra: " + pc.findCheapestSpicy());

//        System.out.println("Najtańsza pizza ostra to: " + pc.findCheapestSpicy());
    }
}
