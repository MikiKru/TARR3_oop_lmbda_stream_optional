package com.company.distance_calculator;

import lombok.AllArgsConstructor;
import lombok.Data;

// 1. Konstruktor implementujący wartości x i y
// 2. Kontruktory domyślny przypisujący wartości x = 0 i y = 0
// 3. Gettery i Settery
// 4. Inkrementacja i dekrementacja składowych x i y
// 5. toString -> [x,y]
@Data
@AllArgsConstructor
public class Point {
    private Integer x;
    private Integer y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }
    @Override
    public String toString() {
        return "["+x+","+y+"]";
    }
    public void incrementX(){
        this.x ++;
    }
    public void incrementY(){
        this.y ++;
    }
    public void decrementX(){
        this.x --;
    }
    public void decrementY(){
        this.y --;
    }

}
