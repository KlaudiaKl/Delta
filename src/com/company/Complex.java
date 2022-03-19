package com.company;

public class Complex {
    public double Real;
    public double Imaginary;

    public Complex(double r, double i) {
        Real = r;
        Imaginary = i;
    }

    public Complex add(Complex c2) {
        return new Complex(Real + c2.Real, Imaginary + c2.Imaginary);
    }


    public Complex sub(Complex c2) {
        return new Complex(Real - c2.Real, Imaginary - c2.Imaginary);
    }


    public Complex mult(Complex c2) {
        return new Complex(Real * c2.Real, Imaginary * c2.Imaginary);
    }

}
