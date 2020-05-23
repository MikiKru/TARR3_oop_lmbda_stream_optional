package com.company.pizza.controller;

import com.company.pizza.model.Ingredient;
import com.company.pizza.model.Pizza;

import java.util.Arrays;

// klasa kontrolera -> obsługa żądań i implementacja logiki biznesowej
public class PizzaController {
    // Wyszukaj i zwróć najtańszą pizze ostrą
    public Pizza findCheapestSpicy(){
        return null;
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
        System.out.println(pc.getPizzaPrice(Pizza.MARGHERITA));
//        System.out.println("Najtańsza pizza ostra to: " + pc.findCheapestSpicy());
    }
}
