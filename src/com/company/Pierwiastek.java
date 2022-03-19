//ZADANIE W JAVIE
package com.company;

import java.util.Scanner;

public abstract class Pierwiastek
{
    int[] tab = new int[3];
    Complex x1 = new Complex(0,0), x2= new Complex(0,0), x3 = new Complex(0,0), x4 = new Complex(0,0), s = new Complex(0,0), r = new Complex(0,0), i = new Complex(0,0);

    double delta, pdelta;

    Scanner scanner = new Scanner(System.in);

    public Pierwiastek()
    {
        System.out.println("a: ");
        tab[0] = scanner.nextInt();
        System.out.println("b");
        tab[1] = scanner.nextInt();
        System.out.println("c");
        tab[2] = scanner.nextInt();
        delta = obliczdelte();
        int a = 0;

    }

    public abstract double pierwiastek(double d, double err);

    public void oblicz(double err)
    {
        if (tab[0] == 0 && tab[1] != 0)
        {

            pdelta = pierwiastek(Math.abs(delta), err);

            if (delta > 0)
            {
                x1 = new Complex((-tab[0] - pdelta) / (2 * tab[1]), x1.Imaginary);
                x2 = new Complex((-tab[0] + pdelta) / (2 * tab[1]), x2.Imaginary);
            }
            if (delta == 0)
            {
                x1 = new Complex((-tab[0]) / (2 * tab[1]), x1.Imaginary);
            }
            if (delta < 0)
            {
                x1 = new Complex(tab[0] / (2 * tab[1]), (-pdelta) / (2 * tab[1]));
                x2 = new Complex(x1.Real, -x1.Imaginary);

            }
        }
        if (tab[0] != 0)
        {
            pdelta = pierwiastek(Math.abs(delta), err);
            if (delta > 0)
            {

                x1 = new Complex((-tab[1] - pdelta) / (2 * tab[0]), x1.Imaginary);
                x2 = new Complex((-tab[1] + pdelta) / (2 * tab[0]), x2.Imaginary);

                if (x2.Real == 0)
                {
                    x2 = new Complex(Math.abs(x2.Real), x2.Imaginary);
                }
                if (x1.Real == 0)
                {
                    x1 = new Complex(Math.abs(x1.Real), x1.Imaginary);
                }

                if (x1.Real == 0)
                {
                    if (x2.Real > 0)
                    {
                        x2 = new Complex(pierwiastek(Math.abs(x2.Real), err), x2.Imaginary);
                        x3 = new Complex(-x2.Real, x3.Imaginary);
                    }
                    if (x2.Real < 0)
                    {
                        x1 = new Complex(x1.Real, pierwiastek(Math.abs(x2.Real), err));
                        x2 = new Complex(x2.Real, -x1.Imaginary);
                    }

                }
                if (x2.Real == 0)
                {
                    if (x1.Real > 0)
                    {
                        x1 = new Complex(pierwiastek(Math.abs(x1.Real), err), x1.Imaginary);
                        x3 = new Complex(-x1.Real, x3.Imaginary);
                    }
                    if (x1.Real < 0)
                    {
                        x1 = new Complex(x1.Real, pierwiastek(Math.abs(x1.Real), err));
                        x2 = new Complex(x2.Real, -x1.Imaginary);
                    }

                }
                if (x2.Real < 0 && x1.Real > 0)
                {

                    x1 = new Complex(x1.Real, pierwiastek(Math.abs(x2.Real), err));
                    x2 = new Complex(x2.Real, -(x1.Imaginary));
                    x1 = new Complex(pierwiastek(Math.abs(x1.Real), err), x1.Imaginary);
                    x2 = new Complex(-(x1.Real), x2.Imaginary);

                }
                if (x2.Real > 0 && x1.Real < 0)
                {
                    x2 = new Complex(x2.Real, -(x1.Imaginary));
                    x1 = new Complex(x1.Real, pierwiastek(Math.abs(x1.Real), err));
                    x1 = new Complex(pierwiastek(Math.abs(x2.Real), err), x1.Imaginary);
                    x2 = new Complex(-(x1.Real), x2.Imaginary);

                }
                if (x2.Real > 0 && x1.Real > 0)
                {
                    x1 = new Complex(pierwiastek(x1.Real, err), x1.Imaginary);
                    x3 = new Complex(-(x1.Real), x2.Imaginary);
                    x2 = new Complex(pierwiastek(x2.Real, err), x3.Imaginary);
                    x4 = new Complex(-(x2.Real), x4.Imaginary);

                }
                if (x2.Real < 0 && x1.Real < 0)
                {
                    x1 = new Complex(x1.Real, pierwiastek(x1.Real, err));
                    x2 = new Complex(x2.Real, -(x1.Imaginary));
                    x3 = new Complex(x3.Real, pierwiastek(x2.Real, err));
                    x4 = new Complex(x4.Real, -(x3.Imaginary));

                }
            }
            if (delta == 0)
            {
                x1 = new Complex((-tab[1]) / (2 * tab[0]), x1.Imaginary);
                if (x1.Real > 0)
                {
                    x1 = new Complex(pierwiastek(x1.Real, err), x1.Imaginary);
                    x2 = new Complex(-x1.Real, x2.Imaginary);
                }
                else
                {
                    x1 = new Complex(x1.Real, pierwiastek(x1.Real, err));
                    x2 = new Complex(x2.Real, -x1.Imaginary);

                }
            }
            if (delta < 0)
            {

                pdelta = pierwiastek(Math.abs(delta), err);
                x1 = new Complex((1.0) * (-tab[1]) / (2 * tab[0]), x1.Imaginary);
                x2 = new Complex(x1.Real, x2.Imaginary);
                x1 = new Complex(x1.Real, ((-pdelta) / (2 * tab[0])));
                x2 = new Complex(x2.Real, -(x1.Imaginary));
                x3 = new Complex(x3.Real, pierwiastek(((pierwiastek((((x1.Real) * (x1.Real)) + ((x1.Imaginary) * (x1.Imaginary))), err) - (x1.Real)) / 2), err));
                x4 = new Complex(x4.Real, -x3.Imaginary);


                x3 = new Complex(pierwiastek(((pierwiastek((((x1.Real) * (x1.Real)) + ((x1.Imaginary) * (x1.Imaginary))), err) + (x1.Real)) / 2), err), pierwiastek(((pierwiastek((((x1.Real) * (x1.Real)) + ((x1.Imaginary) * (x1.Imaginary))), err) - (x1.Real)) / 2), err));
                x4 = new Complex(x3.Real, -(x3.Imaginary));
                x1 = new Complex(-x3.Real, -x3.Imaginary);
                x2 = new Complex(-x4.Real, -x4.Imaginary);
            }
        }
    }

    public double obliczdelte()
    {
        delta = (tab[1] * tab[1]) - (4 * tab[0] * tab[2]);
        if (tab[0] == 0 && tab[1] != 0)
            delta = (0 - (4 * tab[1] * tab[2]));
        return delta;
    }

    public void wyswietlanie_wynikow()
    {
        if (tab[0] == 0 && tab[1] != 0)
        {
            if (delta != 0)
            {
                System.out.println("Delta wynosi: " + delta);
            }
            if (delta > 0)
            {
                System.out.println("Rownanie z delty wynosi: " + pdelta);
            }
            if (delta > 0)
            {
                System.out.println("x1.Real= " + x1.Real);
                System.out.println("x2.Real= " + x2.Real);
            }
            if (delta == 0)
            {
                System.out.println(" x1.Real= " + x1.Real);
            }
            if (delta < 0)
            {

                if (x1.Real != 0 && x1.Imaginary != 0)
                {
                    System.out.println("x1.Real= " + x1.Real);
                    System.out.println("x2.Real= " + x2.Real);
                    System.out.println("x1.Imaginary= " + x1.Imaginary);
                    System.out.println("x2.Imaginary= " + x2.Imaginary);

                    if (x1.Imaginary > 0 && x2.Imaginary > 0)
                    {
                        System.out.println(x1.Real + "+" + x1.Imaginary + "i");
                        System.out.println(x2.Real + "+" + x2.Imaginary + "i");
                    }
                    if (x1.Imaginary < 0 && x2.Imaginary < 0)
                    {
                        System.out.println(x1.Real + "+" + "(" + x1.Imaginary + ")" + "i");
                        System.out.println(x2.Real + "+" + "(" + x2.Imaginary + ")" + "i");
                    }
                    if (x1.Imaginary > 0 && x2.Imaginary < 0)
                    {
                        System.out.println(x1.Real + "+" + x1.Imaginary + "i");
                        System.out.println(x2.Real + "+" + "(" + x2.Imaginary + ")" + "i");
                    }
                    if (x1.Imaginary < 0 && x2.Imaginary > 0)
                    {
                        System.out.println(x1.Real + "+" + "(" + x1.Imaginary + ")" + "i");
                        System.out.println(x2.Real + "+" + x2.Imaginary + "i");
                    }
                }
                if (x1.Real == 0 && x1.Imaginary != 0)
                {

                    System.out.println("x1.Imaginary= " + x1.Imaginary);
                    System.out.println("x2.Imaginary= " + x2.Imaginary);

                }
                if (x1.Real != 0 && x1.Imaginary == 0)
                {
                    System.out.println("x1.Real= " + x1.Real);
                    System.out.println("x2.Real= " + x2.Real);
                }
            }
        }
        if (tab[0] != 0)
        {
            if (delta != 0)
            {
                System.out.println("Delta wynosi: " + delta);
            }
            if (delta > 0)
            {
                System.out.println("Rownanie z delty wynosi: " + pdelta);
            }
            if (delta > 0)
            {

                if (x1.Real == 0)
                {
                    if (x2.Real > 0)
                    {
                        System.out.println("x1.Real= " + x1.Real);
                        System.out.println("x2.Real= " + x2.Real);
                        System.out.println("x3.Real= " + x3.Real);

                    }
                    if (x2.Real < 0)
                    {
                        System.out.println("x1.Real= " + x1.Real);
                        System.out.println("x1.Imaginary= " + x1.Imaginary);
                        System.out.println("x2.Imaginary= " + x2.Imaginary);
                    }

                }
                if (x2.Real == 0)
                {
                    if (x1.Real > 0)
                    {
                        System.out.println("x1.Real= " + x1.Real);
                        System.out.println("x2.Real= " + x2.Real);
                        System.out.println("x3.Real= " + x3.Real);

                    }
                    if (x1.Real < 0)
                    {
                        System.out.println("x1.Real= " + x2.Real);
                        System.out.println("x1.Imaginary= " + x1.Imaginary);
                        System.out.println("x2.Imaginary= " + x2.Imaginary);
                    }

                }
                if (x2.Real < 0 && x1.Real > 0)
                {

                    System.out.println("x1.Real= " + x1.Real);
                    System.out.println("x2.Real= " + x2.Real);
                    System.out.println("x1.Imaginary= " + x1.Imaginary);
                    System.out.println("x2.Imaginary= " + x2.Imaginary);
                    System.out.println("sr= " + s.Real);
                    System.out.println("rr= " + r.Real);

                }
                if (x2.Real > 0 && x1.Real < 0)
                {

                    System.out.println("x1.Real= " + x1.Real);
                    System.out.println("x2.Real= " + x2.Real);
                    System.out.println("x1.Imaginary= " + x1.Imaginary);
                    System.out.println("x2.Imaginary= " + x2.Imaginary);
                    System.out.println("sr= " + s.Real);
                    System.out.println("rr= " + r.Real);
                }
                if (x2.Real > 0 && x1.Real > 0)
                {
                    System.out.println("x1.Real= " + x1.Real);
                    System.out.println("x3.Real= " + x3.Real);
                    System.out.println("x2.Real= " + x2.Real);
                    System.out.println("x4.Real= " + x4.Real);
                    System.out.println("sr= " + s.Real);
                    System.out.println("rr= " + r.Real);

                }
                if (x2.Real < 0 && x1.Real < 0)
                {
                    System.out.println("x1.Imaginary= " + x1.Imaginary);
                    System.out.println("x2.Imaginary= " + x2.Imaginary);
                    System.out.println("x3.Imaginary= " + x3.Imaginary);
                    System.out.println("x4.Imaginary= " + x4.Imaginary);
                }
            }
            if (delta == 0)
            {

                if (x1.Real > 0)
                {

                    System.out.println("x1.Real " + x1.Real);
                    System.out.println("x2.Real " + x2.Real);
                    System.out.println("sr= " + s.Real);
                    System.out.println("rr= " + r.Real);
                }
                if (x1.Real < 0)
                {
                    System.out.println("x1.Imaginary " + x1.Imaginary);
                    System.out.println("x2.Imaginary " + x2.Imaginary);
                }
                if (x1.Real == 0)
                {
                    System.out.println("x=0");
                }
            }
            if (delta < 0)
            {

                System.out.println("x1.Real= " + x1.Real);
                System.out.println("x2.Real= " + x2.Real);
                System.out.println("x1.Imaginary= " + x1.Imaginary);
                System.out.println("x2.Imaginary= " + x2.Imaginary);
                if (x1.Imaginary > 0 && x2.Imaginary < 0)
                {

                    System.out.println(x3.Real + "+" + x3.Imaginary + "i");
                    System.out.println(x4.Real + "+" + "(" + x4.Imaginary + ")" + "i");
                    System.out.println(x1.Real + "+" + "(" + x1.Imaginary + ")" + "i");
                    System.out.println(x2.Real + "+" + x2.Imaginary + "i");

                }
                if (x1.Imaginary < 0 && x2.Imaginary > 0)
                {

                    System.out.println(x3.Real + "+" + x3.Imaginary + "i");
                    System.out.println(x4.Real + "+" + "(" + x4.Imaginary + ")" + "i");
                    System.out.println(x1.Real + "+" + "(" + x1.Imaginary + ")" + "i");
                    System.out.println(x2.Real + "+" + x2.Imaginary + "i");
                }
                System.out.println("su= " + s.Imaginary);
                System.out.println("ru= " + r.Imaginary);
                System.out.println("sr= " + s.Real);
                System.out.println("rr= " + r.Real);

            }
        }
        if (tab[0] == 0 && tab[1] == 0 && tab[2] != 0)
        {
            System.out.println("rownanie sprzeczne");

        }
        if (tab[0] == 0 && tab[1] == 0 && tab[2] == 0)
        {
            System.out.println("rownanie tozsamosciowe");
        }

    }

    public void wyswietlanie()
    {
        if (tab[0] == 0 && tab[1] != 0 && tab[2] != 0)
        {
            if (tab[1] > 0 && tab[2] > 0)
                System.out.println(tab[1] + "xx + " + tab[2] + "=0");
            if (tab[1] < 0 && tab[2] < 0)
                System.out.println("(" + tab[1] + ")xx  +(" + tab[2] + ")=0");
            if (tab[1] < 0 && tab[2] > 0)
                System.out.println(tab[1] + "xx + " + tab[2] + "=0");
            if (tab[1] > 0 && tab[2] < 0)
                System.out.println(tab[1] + "xx + (" + tab[2] + ")=0");
        }
        if (tab[0] != 0 && tab[1] != 0 && tab[2] != 0)
        {
            if (tab[0] > 0 && tab[1] > 0 && tab[2] > 0)
                System.out.println(tab[0] + "x^4 +" + tab[1] + "x^2 +" + tab[2] + "=0");
            if (tab[0] < 0 && tab[1] < 0 && tab[2] < 0)
                System.out.println("(" + tab[0] + ")x^4 +(" + tab[1] + ")x^2 +(" + tab[2] + ")=0");
            if (tab[0] < 0 && tab[1] > 0 && tab[2] > 0)
                System.out.println("(" + tab[0] + ")x^4 +" + tab[1] + "x^2 +" + tab[2] + "=0");
            if (tab[0] > 0 && tab[1] < 0 && tab[2] > 0)
                System.out.println(tab[0] + "x^4 +(" + tab[1] + ")x^2 +" + tab[2] + "=0");
            if (tab[0] > 0 && tab[1] > 0 && tab[2] < 0)
                System.out.println(tab[0] + "x^4 +" + tab[1] + "x^2 +(" + tab[2] + ")=0");
            if (tab[0] < 0 && tab[1] < 0 && tab[2] > 0)
                System.out.println("(" + tab[0] + ")x^4 +(" + tab[1] + ")x^2 +" + tab[2] + "=0");
            if (tab[0] > 0 && tab[1] < 0 && tab[2] < 0)
                System.out.println(tab[0] + "x^4 +(" + tab[1] + ")x^2 +(" + tab[2] + ")=0");
            if (tab[0] < 0 && tab[1] > 0 && tab[2] < 0)
                System.out.println("(" + tab[0] + ")x^4 +" + tab[1] + "x^2 +(" + tab[2] + ")=0");
        }
        if (tab[0] != 0 && tab[1] == 0 && tab[2] != 0)
        {
            if (tab[0] > 0 && tab[2] > 0)
                System.out.println(tab[0] + "x^4 + " + tab[2] + "=0");
            if (tab[0] < 0 && tab[2] < 0)
                System.out.println("(" + tab[0] + ")x^4  +(" + tab[2] + ")=0");
            if (tab[0] < 0 && tab[2] > 0)
                System.out.println(tab[0] + "x^4 + " + tab[2] + "=0");
            if (tab[0] > 0 && tab[2] < 0)
                System.out.println(tab[0] + "x^4 + (" + tab[2] + ")=0");
        }


    }

    public void dodaj_liczbe_zespolona()
    {
        if (delta > 0)
        {
            if (x2.Real < 0 && x1.Real > 0)
            {
                s = x1.add(x2);
            }
            if (x2.Real > 0 && x1.Real > 0)
            {

                s = x1.add(x2).add(x3).add(x4);

            }
        }
        if (delta == 0)
        {
            if (x1.Real > 0)
            {
                s = x1.add(x2);
            }

        }
        if (delta < 0)
        {
            s = x1.add(x2).add(x3).add(x4);
        }
    }
    public void odejmij_liczbe_zespolona()
    {
        if (delta > 0)
        {

            if (x2.Real < 0 && x1.Real > 0)
            {
                r = x1.sub(x2);
            }


            if (x2.Real > 0 && x1.Real > 0)
            {

                r = x1.sub(x2).sub(x3).sub(x4);

            }

        }
        if (delta == 0)
        {
            if (x1.Real > 0)
            {
                r = x1.sub(x2);
            }
        }
        if (delta < 0)
        {
            r = x1.sub(x2).sub(x3).sub(x4);
        }

    }

    public void pomnoz_liczbe_zespolona()
    {
        if (delta > 0)
        {

            if (x2.Real < 0 && x1.Real > 0)
            {
                i = x1.mult(x2);
            }


            if (x2.Real > 0 && x1.Real > 0)
            {

                i = x1.mult(x2).mult(x3).mult(x4);

            }

        }
        if (delta == 0)
        {
            if (x1.Real > 0)
            {
                i = x1.mult(x2);
            }
        }
        if (delta < 0)
        {
            i = x1.mult(x2).mult(x3).mult(x4);
        }

    }
}

