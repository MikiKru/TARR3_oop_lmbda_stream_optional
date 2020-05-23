package com.company.pizza.controller;

import com.company.pizza.model.Ingredient;
import com.company.pizza.model.Pizza;

import java.util.*;
import java.util.stream.Collectors;

// klasa kontrolera -> obsługa żądań i implementacja logiki biznesowej
public class PizzaController {
    // Wyszukaj i zwróć najtańszą pizze ostrą
    public Pizza findCheapestSpicy() {
        return Arrays.stream(Pizza.values())                                // Stream<Pizza>
                .filter(pizza -> pizza.getIngredients()
                        .stream()
                        .anyMatch(ingredient -> ingredient.isSpicy()))      // Stream<Pizza>
                .min(Comparator.comparing(pizza -> getPizzaPrice(pizza)))   // Stream<Pizza>                                            // Optional<Pizza>
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
    // Wyszykaj i zwróć najdroższą pizze wegetariańską
    Pizza findMostExpensiveVegetarian(){
        return Arrays.stream(Pizza.values())
                    .filter(pizza -> pizza.getIngredients()
                                            .stream()
                                            .noneMatch(Ingredient::isMeat))
                    .max(Comparator.comparing(pizza -> getPizzaPrice(pizza)))   // Stream<Pizza>                                            // Optional<Pizza>
                    .get();
    }
    // metoda zwracająca pizze mięsne posortowane malejąco po liczbie składników
    public List<Pizza> iLikeMeat(){
        return Arrays.stream(Pizza.values())
                        .filter(pizza -> pizza.getIngredients()
                                .stream()
                                .anyMatch(Ingredient::isMeat))
                        .sorted(Comparator.comparing(pizza -> pizza.getIngredients()
                                .stream()
                                .filter(Ingredient::isMeat)
                                .count(), Comparator.reverseOrder()))
                        .collect(Collectors.toList());
    }
    // metoda grupująca pizze po cenie
    public Map groupByPrice(){
        return Arrays.stream(Pizza.values())
                    .collect(Collectors.groupingBy(this::getPizzaPrice));
    }
    // metoda grupujące pizze po liczbie składników ostrych
    public TreeMap<Long, List<Pizza>> groupByNumberOfSpicyIngredients(){
        return new TreeMap<Long, List<Pizza>>(Arrays.stream(Pizza.values())
                    .collect(Collectors.groupingBy(pizza -> pizza.getIngredients()
                            .stream()
                            .filter(Ingredient::isSpicy)
                            .count())
                    ));
    }
    // 3 - 2 X
    // 4 - 2 X
    // 5 - 1 OK
    // Grupowanie pizzy po ilości składników, ale zwróć tylko te które mają ich więcej niż 4
    public TreeMap<Integer, List<Pizza>> groupByNumberOfIngredientsGreaterThan4(){
        return new TreeMap<Integer, List<Pizza>>(Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().size() > 4 && pizza.getIngredients().size() < 7)
                .collect(Collectors.groupingBy(pizza -> pizza.getIngredients().size()))
        );
    }

    public static void main(String[] args) {
        PizzaController pc = new PizzaController();
        System.out.println("Najtańsza pizza: " + pc.findCheapest());
        System.out.println("Najtańsza pizza ostra: " + pc.findCheapestSpicy());
        System.out.println("Najdroższa pizza wegetariańska to: " + pc.findMostExpensiveVegetarian());
        System.out.println("Pizze mięsne posortowane po ilości składników mięsnych DESC");
        pc.iLikeMeat().forEach(pizza -> System.out.println(
                pizza + " " +
                pizza.getIngredients().size() + " " +
                pizza.getIngredients().stream().filter(Ingredient::isMeat).count()));
        System.out.println("Pizze pogrupowane po cenie");
        new TreeMap<>(pc.groupByPrice())
                .forEach((key, value) -> System.out.printf("%5.1f | %s \n", key, value));
        System.out.println("Pizze pogrupowane po ilości składników ostrych");
        pc.groupByNumberOfSpicyIngredients()
                .forEach((key, value) -> System.out.printf("%5d | %s \n", key, value));
        System.out.println("Pizze pogrupowane po ilości składników, ale tylko większe od 4");
        pc.groupByNumberOfIngredientsGreaterThan4()
                .forEach((key, value) -> System.out.printf("%5d | %s \n", key, value));
    }
}
