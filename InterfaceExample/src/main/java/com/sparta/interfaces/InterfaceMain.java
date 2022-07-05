package com.sparta.interfaces;

import java.util.Random;

public class InterfaceMain {
    public static void main(String[] args) {
        Random r = new Random();
        Printable p;
        if(r.nextBoolean())
            p = new Cat();
        else
            p = new Invoice();
        // no idea whether I'm printing a Cat or an Invoice
        p.print();
        // can't do this (easily)
        // p.demandFood();
        // casting disables the type checking in the compiler
        // then we can call methods not in the interface, but
        // we're responsible for doing the type checking
        // ((Cat)p).demandFood();
    }
}
