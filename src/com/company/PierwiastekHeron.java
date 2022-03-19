package com.company;

public class PierwiastekHeron extends Pierwiastek {
    public double pierwiastek(double d, double err)
    {

        double pdelta, temp;
        pdelta = 1;

        for (; Math.abs(pdelta - ((Math.abs(d)) / pdelta)) >= err; pdelta = ((pdelta + Math.abs(d) / pdelta) / 2)) ;
        return pdelta;
    }
}
