package com.company;

import java.io.Console;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner scanner = new Scanner(System.in);

        Pierwiastek p = null;
        double err;
        System.out.println("err: ");

        err = scanner.nextDouble();

        if (err > 0 && err <= 0.1)
        {
            p = new PierwiastekHeron();

        }
        if (err > 0.1)
        {
            p = new PierwiastekNewton();
        }
        if (err == 0)
        {
            p = new PierwiastekSqrt();
        }
        p.wyswietlanie();
        p.oblicz(err);
        p.dodaj_liczbe_zespolona();
        p.odejmij_liczbe_zespolona();
        p.pomnoz_liczbe_zespolona();
        p.wyswietlanie_wynikow();

        scanner.next();

    }
}
