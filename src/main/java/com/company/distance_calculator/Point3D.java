package com.company.distance_calculator;

import lombok.Data;

// rozszerzenie Point o składową z
@Data
public class Point3D extends Point {
    private Integer z;

    public Point3D(Integer x, Integer y, Integer z) {
        super(x,y);
        this.z = z;
    }
    public Point3D(){
        super();
        this.z = z;
    }

    @Override
    public String toString() {
        return "["+super.getX()+","+super.getY()+","+this.z+"]";
    }
    public void incrementZ(){ this.z ++; }
    public void decrementZ(){
        this.z --;
    }
}
