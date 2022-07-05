package com.sparta.interfaces;

public class Invoice implements Displayable {
    public void print() {
        System.out.println("Your invoice is being printed");
    }

    public void draw() {

    }

    @Override
    public void customise() {

    }
}
