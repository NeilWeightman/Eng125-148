package com.sparta.interfaces;

import java.io.Serializable;

public class Cat implements Printable, Cloneable, Serializable {
    public void print(){
        System.out.println("Meow");
    }
    public void demandFood(){
        System.out.println("Feed me!");
    }
}
