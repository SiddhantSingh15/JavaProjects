package com.company;

public class Main {

//    METHOD OVERLOADING (using the same method for different data types)

    static int addition(int x, int y){
        return x+y;
    }

    static double addition(double x, double y){
        return x+y;
    }

    public static void main(String[] args) {
	    Class1 c = new Class1();
	    Class1 a = new Class1();
        System.out.println(c.x);
        System.out.println(c.chars);
        System.out.println(a.chars);
        c.printHi();

        Class2 b = new Class2();
        System.out.println(b.y);

        System.out.println("--------");

        int num1 = addition(5,12);
        double num2 = addition(11.285,26.478);

        System.out.println(num1);
        System.out.println(num2);

        System.out.println("--------");

    }
}
