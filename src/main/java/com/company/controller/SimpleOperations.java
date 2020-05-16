package com.company.controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SimpleOperations {
    private int [] numbers = {2,-1,34,21,21,1,2,-4,3,5,5,55,3};

    public int getMaxValue(){
        return Arrays.stream(numbers).max().getAsInt();
    }
    public int getMinValue(){
        return Arrays.stream(numbers)
                .min().getAsInt();
    }
    public double getAvg(){
        return Arrays.stream(numbers)
                .average().getAsDouble();
    }
    // wypisz elementy tablicy większe od średniej wszystkich elementów
    public void getElementsGreaterThanAvg(){
        System.out.println("Elementy większe od średniej: " + Arrays.stream(numbers)
                .filter(number -> number > getAvg())
                .mapToObj(Integer::new)
                .sorted(Comparator.reverseOrder())
                .map(number -> number.toString())
                .collect(Collectors.joining(",")));
    }
    public static void main(String[] args) {
        SimpleOperations so = new SimpleOperations();
        System.out.println("MAX: " + so.getMaxValue());
        System.out.println("MIN: " + so.getMinValue());
        System.out.println("AVG: " + so.getAvg());
        so.getElementsGreaterThanAvg();
    }
}
