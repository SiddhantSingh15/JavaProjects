package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("Hello World again");
        System.out.println("My name: Siddhant");

        int a = 5;
        char b = 'i';
        long c = 400;
        double d = 3.2;

        String name = "Siddhant";

        System.out.println(name.toLowerCase());

        String exclaim = addExclamationPoint("Siddhant");
        System.out.println(exclaim);

        Animal e = new Animal();
        String dog = Animal.iAmDog();
        System.out.println(dog);

        System.out.println("-------------");

        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        int[] myNum = {10, 20, 30, 40};
        // printing an array in Java
        System.out.println(Arrays.toString(myNum));

        System.out.println("-------------");

        System.out.println(cars[0]);

        cars[0] = "Opel";
        System.out.println(cars[0]);

        System.out.println(cars.length);

        System.out.println("-------------");

        // looping through an array (proper)
        for (int i  = 0; i < cars.length; i++){
            System.out.println(cars[i]);
        }

        System.out.println("-------------");

        // looping through the array (easier)
        for (String i: cars){
            System.out.println(i);
        }

        System.out.println("-------------");

        int[][] myNumbers = {{1,2,3}, {4,5,6}};
        int x = myNumbers[1][2];
        System.out.println(x);

        System.out.println("-------------");

        // looping through a 2d array

        for (int i = 0; i < myNumbers.length; ++i){
            for (int j = 0; j < myNumbers[i].length; ++j){
                System.out.println(myNumbers[i][j]);
            }
        }

        System.out.println("-------------");

        Animal whileloop = new Animal();
        Animal.stuff();

        System.out.println("-------------");

        // use switch for big if statement codeblock

        int day = 4;

        switch (day){
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Not Found");
        }

        System.out.println("-------------");

        int i = 0;

        while (i < 5){
            System.out.println(i);
            i++;
        }

        System.out.println("-------------");

        int j = 0;

        do {
            System.out.println(j);
            j++;
        } while (j < 5);

        System.out.println("-------------");

    }

    public static String addExclamationPoint(String s){
        return s + "!";

    }

}
