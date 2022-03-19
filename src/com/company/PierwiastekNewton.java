package com.company;

public class PierwiastekNewton extends Pierwiastek {
    public double pierwiastek(double d, double err)
    {
        double pdelta;
        pdelta = Math.abs(d);

        for (; Math.abs(pdelta - ((Math.abs(d)) / pdelta)) >= err; pdelta = pdelta - (((pdelta * pdelta - Math.abs(d))) / (2 * pdelta))) ;

        return pdelta;
    }

}