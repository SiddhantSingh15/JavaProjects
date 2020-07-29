package com.company;

public class Main {

    public static void main(String[] args) {
        int res1 = sum(100);
        System.out.println(res1);
        int res2 = factorial(4);
        System.out.println(res2);
    }

    public static int sum(int k){
        if (k>0){
            return k + sum(k-1);
        } else{
            return 0;
        }
    }

    public static int factorial(int x){
        if (x==1){
            return 1;
        } else {
            return x * factorial(x-1);
        }
    }

}
